package com.example.hystrixsingle.controller;


import com.example.hystrixsingle.HystrixDashboardProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/")
public class HomeController {
    public static final String UTF_8 = "UTF-8";

    @Autowired
    private HystrixDashboardProperties config;

    @GetMapping
    public String home() throws UnsupportedEncodingException {
        return "redirect:/hystrix/monitor?stream=" + URLEncoder.encode(config.getTurbine().getUri(), UTF_8);
    }
}
