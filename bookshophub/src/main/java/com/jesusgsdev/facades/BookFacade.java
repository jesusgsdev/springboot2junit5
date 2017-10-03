package com.jesusgsdev.facades;

import com.jesusgsdev.dtos.BookDTO;
import com.jesusgsdev.entities.Book;
import com.jesusgsdev.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookFacade {

    @Autowired
    BookService bookService;

    public BookDTO addBook(BookDTO bookDTO) {
        if(bookService.findBookByDetails(bookDTO.getTitle(), bookDTO.getPrice(), bookDTO.getAuthor(), bookDTO.getPages(), bookDTO.getProvider()).isPresent()) {
            bookDTO.setErrorMessage("Books already exists");
            bookDTO.setError("0001");
        }
        else {
            Book book = new Book(bookDTO.getTitle(), bookDTO.getPrice(), bookDTO.getAuthor(), bookDTO.getPages(), bookDTO.getProvider());
            book = bookService.save(book);
            bookDTO.setId(book.getId());
        }
        return bookDTO;
    }

    public List<BookDTO> findAll(){
        return bookService.findAll()
                .stream().map(b -> new BookDTO.Builder()
                        .id(b.getId())
                        .author(b.getAuthor())
                        .title(b.getTitle())
                        .pages(b.getPages())
                        .price(b.getPrice())
                        .provider(b.getProvider())
                        .build())
                .collect(Collectors.toList());
    }
}
