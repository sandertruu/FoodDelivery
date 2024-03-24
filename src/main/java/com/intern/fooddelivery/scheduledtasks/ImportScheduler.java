package com.intern.fooddelivery.scheduledtasks;

import com.intern.fooddelivery.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ImportScheduler {
    @Autowired
    private ImportService importService;

    @Scheduled(cron = "0 * * * * *")
    public void execute(){
        try {
            importService.importData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
