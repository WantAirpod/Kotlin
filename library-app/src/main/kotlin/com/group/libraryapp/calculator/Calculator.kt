package com.group.libraryapp.calculator

import java.lang.IllegalArgumentException

class Calculator (
    //private var number: Int
    //var number: Int // setter를 연 상태
    private var _number: Int

){

    /**
     * getter를 연상태
     */
    val number: Int
        get() = this._number

    fun add(operand: Int){
        this._number += operand
    }

    fun minus(operand: Int){
        this._number -= operand
    }

    fun multiply(operand: Int){
        this._number *= operand
    }

    fun divide(operand: Int){
        if(operand == 0){
            throw IllegalArgumentException("0으로 못나눔")
        }
        this._number /= operand
    }
}