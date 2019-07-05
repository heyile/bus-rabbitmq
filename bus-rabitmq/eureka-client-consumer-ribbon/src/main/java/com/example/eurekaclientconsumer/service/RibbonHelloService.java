package com.example.eurekaclientconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RibbonHelloService {

    @Autowired
    RestTemplate restTemplate;

    private long index = 0;

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String hello() {
        return restTemplate.getForObject("http://DEMO-PROVIDER/hello", String.class);
    }

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String hello2() {
        if (index++ % 2 == 0) {
            throw new RuntimeException();
        }
        return restTemplate.getForObject("http://DEMO-PROVIDER/hello2", String.class);
    }

    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String hello3() {
        if (index++ % 2 == 0) {
            throw new RuntimeException();
        }
        return restTemplate.getForObject("http://DEMO-PROVIDER/hello3", String.class);
    }

    public String helloFallBack() {
        return "sorry ribbon, it's error!";
    }
}
