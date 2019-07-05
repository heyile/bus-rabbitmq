package com.example.eurekaclientconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RibbonSayService {

    @Autowired
    RestTemplate restTemplate;

    private int inx = 0;

    @HystrixCommand(fallbackMethod = "sayFallBack")
    public String say() {
        if (inx++ % 3 == 0) {
            throw new RuntimeException();
        }
        return restTemplate.getForObject("http://DEMO-PROVIDER/say", String.class);
    }

    @HystrixCommand(fallbackMethod = "sayFallBack")
    public String say2() {
        return restTemplate.getForObject("http://DEMO-PROVIDER/say2", String.class);
    }

    public String sayFallBack() {
        return "sorry ribbon, it's error!";
    }
}
