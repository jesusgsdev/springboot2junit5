package com.jesusgsdev.controllers;

import com.jesusgsdev.dtos.BookDTO;
import com.jesusgsdev.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookFacade bookFacade;

    @PostMapping
    public BookDTO addBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookFacade.addBook(bookDTO);
    }

    @GetMapping
    public List<BookDTO> findAll(){
        return bookFacade.findAll();
    }

}
