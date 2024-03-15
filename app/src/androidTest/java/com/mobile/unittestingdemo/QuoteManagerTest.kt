package com.mobile.unittestingdemo

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {


    @Test(expected = FileNotFoundException::class)
    fun populateQuotesFromAssests() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssests(context, "")
    }


    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuotesFromAssests_invalidJson_expected_Exception() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssests(context, "malformed.json")
    }



    @Test
    fun testPopulateQuotesFromAssests_ValidJson_expected_count() {
        val quoteManager = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManager.populateQuotesFromAssests(context, "quotes.json")
        assertEquals(32,quoteManager.quoteList.size)
    }


    @Test
    fun testPreviousQuote_expected_CorrectQuote(){
        //arrange
        val quoteManager  = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("this os first quote","1"),
            Quote("this os second quote","2"),
            Quote("this os third quote","3")
        ))

        //act
        val previousQuote = quoteManager.getPreviousQuote()

        //assert
        assertEquals("1",previousQuote.author)

    }

    @Test
    fun testNextQuote_expected_CorrectQuote(){
        //arrange
        val quoteManager  = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("this os first quote","1"),
            Quote("this os second quote","2"),
            Quote("this os third quote","3")
        ))

        //act
        val nextQuote = quoteManager.getNextQuote()

        //assert
        assertEquals("2",nextQuote.author)

    }


    @Test
    fun testCurrentQuote_expected_CorrectQuote(){
        //arrange
        val quoteManager  = QuoteManager()
        quoteManager.populateQuotes(arrayOf(
            Quote("this os first quote","1"),
            Quote("this os second quote","2"),
            Quote("this os third quote","3")
        ))

        //act
        val nextQuote = quoteManager.getNextQuote()
        val currentQuote = quoteManager.getCurrentQuote()

        //assert
        assertEquals("2",currentQuote.author)

    }
}