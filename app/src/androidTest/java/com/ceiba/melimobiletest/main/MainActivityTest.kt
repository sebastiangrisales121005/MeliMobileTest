package com.ceiba.melimobiletest.main

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ceiba.melimobiletest.R
import org.junit.Rule
import org.junit.Test


class MainActivityTest {
    @Rule
    @JvmField
    public val activityRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun validateShowLoading_isSuccess() {
        Espresso.onView(ViewMatchers.withId(R.id.loading))
            .check(matches(isDisplayed()))
    }
}