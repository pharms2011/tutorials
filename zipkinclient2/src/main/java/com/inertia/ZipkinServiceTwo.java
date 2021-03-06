package com.inertia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableEurekaClient
public class ZipkinServiceTwo {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServiceTwo.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){ return new RestTemplate(); }

}
