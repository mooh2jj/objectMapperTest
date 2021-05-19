package com.example.objectmapper.controller;

import com.example.objectmapper.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    public Object User(){

        Object objectMapper = new ObjectMapper();

        User user = new User("steve", 10);

        objectMapper.

        return user;
    }
}
