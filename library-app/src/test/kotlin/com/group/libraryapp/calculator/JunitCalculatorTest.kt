package com.group.libraryapp.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class JunitCalculatorTest {

    @Test
    fun addTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.add(3)

        //then
        assertThat(calculator.number).isEqualTo(8)
    }

    @Test
    fun divideTest() {
        //given
        val calculator = Calculator(5)

        //when
        calculator.divide(2)

        //then
        assertThat(calculator.number).isEqualTo(2)

    }

    @Test
    fun divideExceptionTest() {
        //given
        val calculator = Calculator(5)

        // when
//        val message = assertThrows<IllegalArgumentException> {
//            calculator.divide(0)
//        }.message
//        assertThat(message).isEqualTo("0으로 나눌 수 없습니다")

        assertThrows<IllegalArgumentException> {
            calculator.divide(0)
        }.apply {
            assertThat(message).isEqualTo("0으로 나눌 수 없습니다")
        }
    }

}
