package com.group.libraryapp.calculator.domain.user.loanhistory

import com.group.libraryapp.domain.user.JavaUser
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class UserLoanHistory(

    @ManyToOne
    val user: User,

    /**
     * val : null 불가능하며 불변이다.
     */
    val bookName: String,


    /**
     * var : null 불가능이며 가변이다.
     */
    var isReturn: Boolean,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    fun doReturn(){
        this.isReturn = true;
    }
}