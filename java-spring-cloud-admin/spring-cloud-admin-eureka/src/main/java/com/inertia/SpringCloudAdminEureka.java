package com.inertia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudAdminEureka {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAdminEureka.class, args);
    }
}