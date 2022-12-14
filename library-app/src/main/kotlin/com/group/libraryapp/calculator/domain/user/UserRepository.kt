package com.group.libraryapp.calculator.domain.user

import com.group.libraryapp.calculator.domain.user.loanhistory.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepository : JpaRepository<User, Long> {

    fun findBYName(name: String): Optional<User>
}