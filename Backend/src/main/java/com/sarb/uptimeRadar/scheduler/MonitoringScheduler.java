package com.sarb.uptimeRadar.scheduler;

import com.sarb.uptimeRadar.service.MonitoringService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MonitoringScheduler {
    private final MonitoringService monitoringService;

    public MonitoringScheduler(MonitoringService monitoringService) {
        this.monitoringService = monitoringService;
    }
    @Scheduled(fixedRate = 60000)
    public void checkEndpoints(){
        monitoringService.checkUptime();
    }
}
