package com.example.eurekaclientconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eurekaclientconsumer.service.RibbonHelloService;
import com.example.eurekaclientconsumer.service.RibbonSayService;

@RestController
public class DemoConsumerController {

    @Autowired
    private RibbonHelloService ribbonHelloService;

    @Autowired
    private RibbonSayService ribbonSayService;

    @RequestMapping("/hello")
    public String hello() {
        return ribbonHelloService.hello();
    }

    @RequestMapping("/hello2")
    public String hello2() {
        return ribbonHelloService.hello2();
    }

    @RequestMapping("/hello3")
    public String hello3() {
        return ribbonHelloService.hello3();
    }

    @RequestMapping("/say")
    public String say() {
        return ribbonSayService.say();
    }

    @RequestMapping("/say2")
    public String say2() {
        return ribbonSayService.say2();
    }
}
