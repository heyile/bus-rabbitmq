package com.example.hystrixturbinestream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@EnableTurbineStream
@SpringBootApplication
public class HystrixTurbineStreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixTurbineStreamApplication.class, args);
    }
}
