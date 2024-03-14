package com.mobile.unittestingdemo.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {


    lateinit var helper: Helper

    @Before
    fun before(){
         helper = Helper()
        println("before every test case")
    }

    @After
    fun tearDown(){
        println("after every test case")
    }

    @Test
    fun isPalindrome_inputString_level_TRUE() {




        //act
        val palindrome = helper.isPalindrome("level")

        //assert
        assertEquals(true,palindrome)
    }



    @Test
    fun isPalindrome_inputString_hello_FALSE() {


        //act
        val palindrome = helper.isPalindrome("hello")

        //assert
        assertEquals(false,palindrome)
    }
}