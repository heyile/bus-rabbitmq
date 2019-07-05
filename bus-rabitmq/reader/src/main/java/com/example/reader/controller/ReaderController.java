package com.example.reader.controller;

import com.example.reader.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReaderController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/read")
    public String toRead() {
        return bookService.readingList();
    }
}
