package com.example.eurekaclientprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderHelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String getPort() {
        return "Hello World,my name is heyile I'm from port : " + port;
    }

    @RequestMapping("/hello2")
    public String getPort2() {
        return "Hello World,my name is heyile2222 I'm from port : " + port;
    }

    @RequestMapping("/hello3")
    public String getPort23() {
        return "Hello World,my name is 3333 I'm from port : " + port;
    }
}
