package com.group.libraryapp

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class JunitTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeEach() {
            println("시작전")
        }

    }


    @Test
    fun test1() {
        println("test1")
    }

    @Test
    fun test2() {
        println("test2")
    }
}
