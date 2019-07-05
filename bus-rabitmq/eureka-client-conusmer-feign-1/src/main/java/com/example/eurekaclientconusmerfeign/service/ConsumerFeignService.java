package com.example.eurekaclientconusmerfeign.service;

import com.example.eurekaclientconusmerfeign.config.ErrorHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "DEMO-PROVIDER", fallback = ErrorHystrix.class)
public interface ConsumerFeignService {

    @RequestMapping(value = "/hello")
    String hello();

    @RequestMapping(value = "/hello2")
    String hello2();

    @RequestMapping(value = "/hello3")
    String hello3();

    @RequestMapping(value = "/say")
    String say();

    @RequestMapping(value = "/say2")
    String say2();
}
