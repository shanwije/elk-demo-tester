package com.example.demotester;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DemoController {

    DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping(value = "/hello")
    public String helloWorld() {
        log.info("Welcome home page");
        return "working";
    }

//    @GetMapping(value = "/data")
//    public JSONArray getData() {
//        log.info("Welcome data page");
//        return service.getData();
//    }

    @GetMapping(value = "/users")
    public List<RandomUser> getUsers(){
        var users =  service.getUsers();
        log.info("Data " + users);
        return users;
    }
}
