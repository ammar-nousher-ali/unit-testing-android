package com.mobile.unittestingdemo.utils

import org.junit.Assert.*

import org.junit.Test

class HelperTest {

    @Test
    fun isPalindrome_inputString_level_TRUE() {

        //arrange
        var helper = Helper()

        //act
        val palindrome = helper.isPalindrome("level")

        //assert
        assertEquals(true,palindrome)
    }



    @Test
    fun isPalindrome_inputString_hello_FALSE() {

        //arrange
        var helper = Helper()

        //act
        val palindrome = helper.isPalindrome("hello")

        //assert
        assertEquals(true,palindrome)
    }
}