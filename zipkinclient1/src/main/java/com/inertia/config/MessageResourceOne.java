package com.inertia.config;

import brave.Tracer;
import brave.Tracing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import brave.Span;

@RestController
public class MessageResourceOne {
    private static final Logger logger = LoggerFactory.getLogger(MessageResourceOne.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Tracer tracer;

    @Autowired
    Tracing tracing;

    @GetMapping("/message")
    public String getMsg() throws InterruptedException{
        logger.info("---Sending msg to service provider---");
        String msgResourceUrl = "http://zipkin-service-two/greetings";

        Span initialSpan = this.tracer.currentSpan();

        initialSpan.tag("foo", "bar");

        initialSpan.annotate("tx.started");

        return restTemplate.getForObject(msgResourceUrl, String.class);
    }
}
