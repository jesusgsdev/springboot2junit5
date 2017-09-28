package com.jesusgsdev.repositories;

import com.jesusgsdev.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Stream<Book> findBookByAuthor(String author);

}
