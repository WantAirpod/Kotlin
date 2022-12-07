package com.group.libraryapp.service.book

import com.group.libraryapp.domain.book.Book
import com.group.libraryapp.domain.book.BookRepository
import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository
import com.group.libraryapp.dto.book.request.BookLoanRequest
import com.group.libraryapp.dto.book.request.BookRequest
import com.group.libraryapp.dto.book.request.BookReturnRequest
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.lang.IllegalArgumentException

@SpringBootTest
class BookServiceTest @Autowired constructor(
    private val bookService: BookService,
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val userLoanHistoryRepository: UserLoanHistoryRepository,
){

    @AfterEach
    fun clean(){
        bookRepository.deleteAll()
        userRepository.deleteAll()
    }
    @Test
    @DisplayName("책 등록이 정상동작한다.")
    fun saveBookTest(){
        //given
        val req = BookRequest("이상한 나라의 엘리스")

        //when
        bookService.saveBook(req)

        //then
        val books = bookRepository.findAll()
        assertThat(books).hasSize(1)
        assertThat(books[0].name).isEqualTo("이상한 나라의 엘리스")
    }

    @Test
    @DisplayName("책 대출이 정상동작한다")
    fun loanBookTest(){
        //given
        bookRepository.save(Book("이상한"))
        userRepository.save(User("최진영",null))
        val saveUser = userRepository.save(User("최진영",null))
        val req = BookLoanRequest("최진영","이상한");

        //when
        bookService.loanBook(req)

        //then
        val result = userLoanHistoryRepository.findAll()
        assertThat(result).hasSize(1)
        assertThat(result[0].bookName).isEqualTo("이상한")
        //assertThat(result[0].bookName).isEqualTo(saveUser.id)

    }

    @Test
    @DisplayName("책이 진작 대출되어 있다면, 신규 대출이 실패한다")
    fun loanBookFailTest(){
        //given

        //이상한 나라의 엘리스라는 책을 저장한다.
        bookRepository.save(Book("이상한 나라의 엘리스"))
        // 이름:최진영, 나이:null인 유저정보를 저장한다.
        val saveUser = userRepository.save(User("최진영",null))
        //유저정보와, 책이름, 반납여부를 기록하여 저장한다.
        userLoanHistoryRepository.save(UserLoanHistory(saveUser,"이상한 나라의 엘리스",false))
        // 이름과 도서명을 던지기 위해 req 를 정한다.
        val req = BookLoanRequest("최진영","이상한 나라의 엘리스")

        //when & then
        val message = assertThrows<IllegalArgumentException> {
            bookService.loanBook(req)
        }.message
        assertThat(message).isEqualTo("진작 대출되어 있는 책입니다")

    }

    @Test
    @DisplayName("책 반납이 정상 동작한다.")
    fun returnBookTest(){
        //given
        //이상한 나라의 엘리스라는 책을 저장한다.
        bookRepository.save(Book("이상한 나라의 엘리스"))
        // 이름:최진영, 나이:null인 유저정보를 저장한다.
        val saveUser = userRepository.save(User("최진영",null))
        //유저정보와, 책이름, 반납여부를 기록하여 저장한다.
        userLoanHistoryRepository.save(UserLoanHistory(saveUser,"이상한 나라의 엘리스",false))
        //리턴 정보를 입력한다.
        val req = BookReturnRequest("최진영","이상한 나라의 엘리스")

        //when
        bookService.returnBook(req)


        // then
        // 빌린 도서 데이터를 전부 뒤진다.
        val result = userLoanHistoryRepository.findAll()
        assertThat(result).hasSize(1)

    }
}