package com.ufu.sd.dbnosql.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan("com.ufu.sd.dbnosql")
public class SpringBooter {
    public SpringBooter() {}
}
