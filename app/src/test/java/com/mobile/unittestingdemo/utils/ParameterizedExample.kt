package com.mobile.unittestingdemo.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ParameterizedExample(val inputString: String, val expectedValue: Boolean) {


    @Test
    fun test() {
        var helper = Helper()
        val result = helper.isPalindrome(inputString)
        assertEquals(expectedValue, result)
    }


    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "{index} : {0} is palindrome - {1}")
        fun data(): List<Array<Any>>{
            return listOf(
                arrayOf("hello",false),
                arrayOf("level",true),
                arrayOf("a",true),
                arrayOf("",true),

            )

        }

    }

}