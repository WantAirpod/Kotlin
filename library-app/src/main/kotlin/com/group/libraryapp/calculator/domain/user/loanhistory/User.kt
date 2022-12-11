package com.group.libraryapp.calculator.domain.user.loanhistory

import com.group.libraryapp.calculator.domain.book.Book
import java.lang.IllegalArgumentException
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne

@Entity
class User
    (
    var name: String,
    /**
     * Int : null 가능
     * val : 불변!
     */
    val age:Int?,
    /**
     * val : 기존에 final 처리
     * MutableList : 가변 리스트
     */
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHostoryes: MutableList<UserLoanHistory> = mutableListOf(),

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    init{
        if(name.isBlank()){
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }

    }

    fun updateName(name: String){
        this.name = name
    }

    fun loanBook(book: Book){
        this.userLoanHostoryes.add(UserLoanHistory(this, book.name,false))
    }

    /**
     * 책 반납하는 함수
     * 책 이름이 문자열로 들어온다.
     * first 기능 : 들어오는 문자열에 만족하는 {}의 안쪽이 True인 첫 번째 책을 반환한다.
     * history -> history.bookName == bookName : history의 bookName과 들어온 bookName이 같은 경우 (true/false)
     */
    fun returnBook(bookName: String){
        this.userLoanHostoryes.first{history -> history.bookName == bookName}.doReturn()

    }


}