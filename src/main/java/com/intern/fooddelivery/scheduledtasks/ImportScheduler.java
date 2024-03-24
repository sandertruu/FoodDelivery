package com.intern.fooddelivery.scheduledtasks;

import com.intern.fooddelivery.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * configureable scheduler for importing weather data
 */
@Profile("!test")
@Component
public class ImportScheduler {
    @Autowired
    private ImportService importService;

    /**
     * Configure the value for the scheduler in appliation.properties
     */
    @Value(value = "${scheduler.cron.every_15_past_hour}")
    private String cronConfig;

    /**
     * execute the data import on service level
     */
    @Scheduled(cron= "${scheduler.cron.every_15_past_hour}")
    public void execute(){
        try {
            importService.importData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
