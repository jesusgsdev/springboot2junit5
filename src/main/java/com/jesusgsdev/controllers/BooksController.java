package com.jesusgsdev.controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class BooksController {

    @RequestMapping("/books")
    String home() {
        return "Hello SpringBoot 2.0!";
    }

}
