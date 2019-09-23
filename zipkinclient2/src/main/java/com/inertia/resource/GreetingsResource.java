package com.inertia.resource;

import com.inertia.services.GreetServiceOne;
import com.inertia.services.GreetServiceTwo;
import com.netflix.client.http.HttpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsResource {
    private static final Logger logger = LoggerFactory.getLogger(GreetingsResource.class);


    @Autowired
    GreetServiceOne greetServiceOne;

    @Autowired
    GreetServiceTwo greetServiceTwo;

    @GetMapping("/greetings")
    public String greet(HttpRequest httpRequest){
        logger.info("Message from greetings resource");
        return greetServiceOne.greetFromServiceOne();
    }

}
