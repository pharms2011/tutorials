package com.inertia.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageResourceThree {
    private static final Logger logger = LoggerFactory.getLogger(MessageResourceThree.class);

    @GetMapping("/hello")
    public String sayHello() {
        logger.info("Message from msg resource");
        return "Hello from third service";
    }
}
