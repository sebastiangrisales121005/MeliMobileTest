package com.ceiba.melimobiletest.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ceiba.melimobiletest.R
import com.ceiba.melimobiletest.idling.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class MainActivityTest {
    @Rule
    @JvmField
    public val activityRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource)
    }

    @Test
    fun validateShowProducts_isSuccess() {
        Espresso.onView(ViewMatchers.withId(R.id.list_products))
            .check(matches(isDisplayed()))
    }

    @Test
    fun searchProducts_isSuccess() {
        Espresso.onView(ViewMatchers.withId(R.id.search_products))
            .check(matches(isDisplayed()))
            .perform(ViewActions.typeText("Samsung"))

        Espresso.onView(ViewMatchers.withId(R.id.list_products))
            .check(matches(isDisplayed()))
    }

}