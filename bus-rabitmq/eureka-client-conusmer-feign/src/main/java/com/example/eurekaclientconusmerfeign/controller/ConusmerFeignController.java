package com.example.eurekaclientconusmerfeign.controller;

import com.example.eurekaclientconusmerfeign.service.ConsumerFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConusmerFeignController {

    @Autowired
    ConsumerFeignService consumerFeignService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return consumerFeignService.hello();
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2() {
        return consumerFeignService.hello2();
    }

    @RequestMapping(value = "/hello3", method = RequestMethod.GET)
    public String hello3() {
        return consumerFeignService.hello3();
    }

    @RequestMapping(value = "/say2", method = RequestMethod.GET)
    public String say2() {
        return consumerFeignService.say2();
    }

    @RequestMapping(value = "/say", method = RequestMethod.GET)
    public String say() {
        return consumerFeignService.say();
    }
}
