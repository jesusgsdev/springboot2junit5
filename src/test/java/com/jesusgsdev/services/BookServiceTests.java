package com.jesusgsdev.services;


import com.jesusgsdev.entities.Book;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

    @Autowired
    BookService bookService;

    @Test
    @DisplayName("Add a new book in the Bookshop")
    public void saveTest(){
        Book book = new Book("Book Name", 9.99, "Author Name", 200);
        Book savedBook = bookService.save(book);

        assertNotNull(savedBook);
    }

}
