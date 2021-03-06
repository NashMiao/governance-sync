package com.github.ontio.governancesync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class GovernanceSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(GovernanceSyncApplication.class, args);
    }

}
