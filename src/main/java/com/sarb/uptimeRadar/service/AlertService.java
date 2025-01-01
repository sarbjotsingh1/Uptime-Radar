package com.sarb.uptimeRadar.service;

import com.sarb.uptimeRadar.entity.Alert;
import com.sarb.uptimeRadar.entity.Endpoint;
import com.sarb.uptimeRadar.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AlertService {
    private final AlertRepository alertRepository;

    @Autowired
    public AlertService(AlertRepository alertRepository) {
        this.alertRepository = alertRepository;
    }

    public void CreateAlert(Endpoint endpoint, boolean isUp) {
        Alert alert = new Alert();
        alert.setEndpoint(endpoint);
        alert.setMessage(isUp ? "Service is up" : "Service is down");
        alert.setTimestamp(LocalDateTime.now());
        alertRepository.save(alert);
    }
}
