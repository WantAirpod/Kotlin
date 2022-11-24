package com.group.libraryapp.calculator

import java.util.Calendar

/**
 * main 생성
 */

fun main(){
    val calculatorTest = CalculatorTest()
    calculatorTest.addTest();
}
class CalculatorTest {
    fun addTest() {
        // given
        val calculator = Calculator(5)

        //when
        calculator.add(3)
        /*
        val expectedCalculator = Calculator(8)
        if(calculator != expectedCalculator){
            throw IllegalStateException()
        }  */
        //then
        if (calculator.number != 8) {
            throw IllegalStateException()
        }
    }

    fun minusTest() {
        // given
        val calculator = Calculator(5)

        //when
        calculator.minus(3)
        /*
        val expectedCalculator = Calculator(8)
        if(calculator != expectedCalculator){
            throw IllegalStateException()
        }  */
        //then
        if (calculator.number != 2) {
            throw IllegalStateException()
        }
    }


    fun mulTest() {
        // given
        val calculator = Calculator(5)

        //when
        calculator.multiply(3)
        /*
        val expectedCalculator = Calculator(8)
        if(calculator != expectedCalculator){
            throw IllegalStateException()
        }  */
        //then
        if (calculator.number != 15) {
            throw IllegalStateException()

        }
    }
}


