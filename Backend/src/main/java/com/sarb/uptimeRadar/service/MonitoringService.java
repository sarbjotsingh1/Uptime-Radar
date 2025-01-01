package com.sarb.uptimeRadar.service;

import com.sarb.uptimeRadar.entity.Endpoint;
import com.sarb.uptimeRadar.repository.AlertRepository;
import com.sarb.uptimeRadar.repository.EndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class MonitoringService {
    private final EndpointRepository endpointRepository;
    private final AlertService alertService;

    @Autowired
    public MonitoringService(EndpointRepository endpointRepository, AlertService alertService, AlertService alertService1, AlertService alertService2) {
        this.endpointRepository = endpointRepository;
        this.alertService = alertService;
    }

    public void checkUptime() {
        List<Endpoint> endpoints = endpointRepository.findAll();
        for (Endpoint endpoint : endpoints) {
            boolean isUp = checkEndpointService(endpoint.getUrl());
            if (isUp != endpoint.isUp()) {
                endpoint.setUp(isUp);
                endpointRepository.save(endpoint);
                alertService.createAlertIfStatusChanged(endpoint, isUp);
            }
        }

    }

    private boolean checkEndpointService(String url) {
        try {
            URL endpointUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) endpointUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.connect();
            return connection.getResponseCode() == HttpURLConnection.HTTP_OK;

        } catch (IOException e) {
            return false;
        }

    }


}
