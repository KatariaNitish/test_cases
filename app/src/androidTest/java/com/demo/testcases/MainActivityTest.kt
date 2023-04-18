package com.demo.testcases


import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{


    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()


    @Test
    fun testSubmitButton_expectedCorrect(){
        val email = "test@yopmail.com"
        val password = "1234567"
        onView(withId(R.id.edtEmail)).perform(typeText(email))
        onView(withId(R.id.edtPassword)).perform(typeText(password))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnSignup)).perform(click())

    }

   @Test
    fun testSubmitButton_expectedEmpty(){
        val email = ""
        val password = ""
        onView(withId(R.id.edtEmail)).perform(typeText(email))
        onView(withId(R.id.edtPassword)).perform(typeText(password))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnSignup)).perform(click())
        onView(withId(R.id.edtEmail)).check(matches(withText("")))
        onView(withId(R.id.edtPassword)).check(matches(withText("")))

    }

  @Test
    fun testSubmitButton_expectedCorrectEmailOnHome(){

        onView(withId(R.id.edtEmail)).perform(typeText("test@yopmail.com"))
        onView(withId(R.id.edtPassword)).perform(typeText("1234567"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnSignup)).perform(click())
      onView(withId(R.id.txt_message)).check(matches(withText("Email - test@yopmail.com")))

    }


}