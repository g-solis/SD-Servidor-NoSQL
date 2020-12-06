package com.ufu.sd.dbnosql;

import com.ufu.sd.dbnosql.controller.DbNosqlServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@EnableScheduling
@RestController
@Component
public class SpringScheduler {
    @Scheduled(fixedDelay = 60000, initialDelay = 60000)
    private void SaveRoutine() {
        if(DbNosqlServer.ServiceInstance != null)
            DbNosqlServer.ServiceInstance.writeHashtableFile();
    }
}
