package com.example.eurekaclientconusmerfeign.config;

import com.example.eurekaclientconusmerfeign.service.ConsumerFeignService;
import org.springframework.stereotype.Component;

@Component
public class ErrorHystrix implements ConsumerFeignService {
    @Override public String say() {
        return "sorry feign, say";
    }

    @Override public String say2() {
        return "sorry feign ,say2";
    }

    @Override
    public String hello() {
        return "sorry, it's error in feign!";
    }

    @Override
    public String hello2() {
        return "sorry hello2";
    }

    @Override
    public String hello3() {
        return "hello3 sorry";
    }
}