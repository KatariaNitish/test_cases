package com.demo.testcases

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test




class PasswordTest {


    @Test
    fun validatePassword_blankInput_expectedRequiredFields(){
        val sut = Utils()
        val result = sut.validatePasswordd("   ")
        assertEquals("Password is required field",result)


    }

    @Test
    fun validatePassword_2CharInput_expectedValidationMsg(){
        val sut = Utils()
        val result = sut.validatePasswordd("ab")
        assertEquals("Length of password should be greater than 6",result)

    }
    @Test
    fun validatePassword_CorrectInput_expectedValidPassword(){
        val sut = Utils()
        val result = sut.validatePasswordd("Pass123")
        assertEquals("Valid",result)


    }
}