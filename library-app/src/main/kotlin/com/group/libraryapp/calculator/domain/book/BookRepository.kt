package com.group.libraryapp.calculator.domain.book

import com.group.libraryapp.calculator.domain.book.Book
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface BookRepository : JpaRepository<Book, Long> {


    //java
    //Optional<Book> findByName(String bookName);
    fun findByName(bookName: String): Optional<Book>

}