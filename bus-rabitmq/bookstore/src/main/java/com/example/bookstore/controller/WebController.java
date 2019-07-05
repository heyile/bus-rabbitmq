package com.example.bookstore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @GetMapping(value = "/hello")
    public String readingList(){
        return "hello , my name is heyile";
    }
}
