package com.inertia;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import zipkin2.Span;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.SpanAdjuster;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableEurekaClient
public class ZipkinServiceOne {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServiceOne.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    SpanAdjuster spanAdjuster(){
        return new SpanAdjuster(){
            @Override
            public Span adjust(Span span){
                if("/messages".equals(span.tags().get("http.path"))){
                    return span.toBuilder().name("Messenger")
                            .build();
                }
                else return span;
            }
        };
    }
}
