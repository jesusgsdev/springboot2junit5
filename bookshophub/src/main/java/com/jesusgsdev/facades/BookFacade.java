package com.jesusgsdev.facades;

import com.jesusgsdev.dtos.BookDTO;
import com.jesusgsdev.entities.Book;
import com.jesusgsdev.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jesusgsdev.constants.ErrorCode.BOOK_ALREADY_EXISTS;

@Service
public class BookFacade {

    @Autowired
    private BookService bookService;

    public BookDTO addBook(BookDTO bookDTO) {
        Optional<Book> bookOptional = bookService.findBookByISBN(bookDTO.getISBN());
        if(bookOptional.isPresent()) {
            bookDTO.setErrorMessage(BOOK_ALREADY_EXISTS.getMessage());
            bookDTO.setError(BOOK_ALREADY_EXISTS.getCode());
            return bookDTO;
        } else {
            Book book = new Book(bookDTO.getISBN(), bookDTO.getTitle(), bookDTO.getPrice(), bookDTO.getAuthor(), bookDTO.getPages(), bookDTO.getProvider());
            book = bookService.save(book);
            bookDTO.setId(book.getId());
        }
        return bookDTO;
    }

    public List<BookDTO> findAll(){
        return bookService.findAll().stream().map(BookDTO::fromBook).collect(Collectors.toList());
    }
}
