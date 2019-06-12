package com.inertia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBootAdminClient {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminClient.class, args);
    }
}
