package com.jesusgsdev.services;

import com.jesusgsdev.entities.Book;
import com.jesusgsdev.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }

    @Transactional
    public List<Book> findBooksByAuthor(String author){
        return bookRepository.findBookByAuthor(author).collect(Collectors.toList());
    }

    public Optional<Book> findBookByDetails(String title, Double price, String author, Integer pages, String provider){
        return bookRepository.findBookByTitleAndPriceAndAuthorAndPagesAndProvider(title, price, author, pages, provider);
    }
}
