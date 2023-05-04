package com.example.demotester;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class DemoController {
    // Initializing instance of Logger for Controller
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);
    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping(value = "/hello")
    public String helloWorld() {
        log.info("Inside Hello World");
        log.info("working");
        return "working";
    }

    @GetMapping(value = "/data")
    public JSONArray getData() {
        log.info("Inside service getdata");
        return service.getData();
    }
}
