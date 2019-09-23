package com.inertia.services;

import com.inertia.resource.GreetingsResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetServiceTwo {
    private static final Logger logger = LoggerFactory.getLogger(GreetingsResource.class);

    @Autowired
    RestTemplate restTemplate;

    @NewSpan("ServiceTwoCall")
    public String greetFromServiceTwo() {
        logger.info("---Service Two---" + " , "  + Thread.currentThread().getName());
        String msgResourceUrl = "http://zipkin-service-three/hello";
        return restTemplate.getForObject(msgResourceUrl, String.class);
    }
}
