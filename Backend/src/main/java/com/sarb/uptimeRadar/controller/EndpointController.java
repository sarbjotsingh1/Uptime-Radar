package com.sarb.uptimeRadar.controller;

import com.sarb.uptimeRadar.entity.Alert;
import com.sarb.uptimeRadar.entity.Endpoint;
import com.sarb.uptimeRadar.repository.EndpointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/endpoints")
public class EndpointController {

    private static final Logger log = LoggerFactory.getLogger(EndpointController.class);
    private final EndpointRepository endpointRepository;


    public EndpointController(EndpointRepository endpointRepository) {
        this.endpointRepository = endpointRepository;
    }

    @GetMapping
    public List<Endpoint> getAllEndpoints(){
        return endpointRepository.findAll();
    }

    @PostMapping
    public Endpoint addEndpoint(@RequestBody Endpoint endpoint){
        return endpointRepository.save(endpoint);
    }

    @GetMapping("/{id}/alerts")
    public List<Alert> getAlertsForEndpoint(@PathVariable Long id) {
        return endpointRepository.findById(id)
                .map(endpoint -> endpoint.getAlerts())
                .orElse(Collections.emptyList());
    }
}
