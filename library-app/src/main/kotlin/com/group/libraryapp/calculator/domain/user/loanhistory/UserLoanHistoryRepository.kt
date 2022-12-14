package com.group.libraryapp.calculator.domain.user.loanhistory

import org.springframework.data.jpa.repository.JpaRepository

interface UserLoanHistoryRepository : JpaRepository<UserLoanHistory, Long> {

    //java
    //UserLoanHistory findByBookNameAndIsReturn(String bookName, boolean isReturn);
    //?가 붙으면 nullable 이다.
    fun findByBookNameAndIsReturn(booName: String, isReturn: Boolean): UserLoanHistory?

}