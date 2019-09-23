package com.inertia.services;

import com.inertia.resource.GreetingsResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;

@Service
public class GreetServiceOne {
    private static final Logger logger = LoggerFactory.getLogger(GreetingsResource.class);

    @Autowired
    GreetServiceTwo greetServiceTwo;

    @NewSpan("ServiceOnecall")
    public String greetFromServiceOne() {
        logger.info("---ServiceOne---" + Thread.currentThread().getName());
        return greetServiceTwo.greetFromServiceTwo();
    }
}
