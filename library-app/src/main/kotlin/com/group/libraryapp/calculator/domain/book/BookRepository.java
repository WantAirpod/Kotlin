package com.group.libraryapp.calculator.domain.book;

import com.group.libraryapp.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<com.group.libraryapp.domain.book.Book, Long> {

  Optional<Book> findByName(String bookName);

}
