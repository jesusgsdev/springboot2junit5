package com.jesusgsdev.controllers;

import com.jesusgsdev.dtos.BookDTO;
import com.jesusgsdev.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@EnableAutoConfiguration
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookFacade bookFacade;

    @RequestMapping("/")
    public BookDTO addBook(@Valid BookDTO bookDTO) {
        return bookFacade.addBook(bookDTO);
    }


}
