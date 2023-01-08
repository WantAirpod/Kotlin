package com.group.libraryapp.calculator.domain.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Book (
    //test

    val name: String,
    /**
     * val : null 불가능 이며 id는 한 번 생기면 불변이다.
     * Long : type 이며
     * ? : null이 가능하다.
     * = null : 초기화
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {


    //초기화 블록
    init{
        if(name.isBlank()){
            throw IllegalArgumentException("이름은 비어 있을 수 없습니다.")
        }
    }
}