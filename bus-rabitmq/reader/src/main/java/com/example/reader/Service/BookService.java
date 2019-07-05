package com.example.reader.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookService {
    private final RestTemplate restTemplate;

    public BookService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "heyileBack")
    public String readingList() {
        URI uri = URI.create("http://localhost:8090/hello");

        return this.restTemplate.getForObject(uri, String.class);
    }

    public String heyileBack() {
        return "这个是我自己定义的";
    }

}
