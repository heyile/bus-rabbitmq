package com.example.eurekaclientprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@EnableCircuitBreaker
@RestController
@RefreshScope
public class ProviderSayController {

    private int indexSay = 0;

    private int indexSay2 = 0;

    @Value("${server.port}")
    String port;

    @HystrixCommand(fallbackMethod = "serviceFallback")
    @RequestMapping("/say")
    public String getSay() {
        if (indexSay++ % 2 == 0) {
            throw new RuntimeException();
        }
        return "Hello World,my name is heyile I'm from port : " + port;
    }

    public String serviceFallback() { // fallback方法
        return "error";
    }

    @HystrixCommand
    @RequestMapping("/say2")
    public String getSay2() {
        if (indexSay2++ % 2 == 0) {
            throw new RuntimeException();
        }
        return "Hello World,my name is 3333 I'm from port : " + port;
    }
}
