package com.sudzu.trtlmtest.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sudzu.trtlmtest.R
import com.sudzu.trtlmtest.ui.bugdetails.BugDetailsActivity
import com.sudzu.trtlmtest.ui.main.MainActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var activityTestRule = IntentsTestRule(MainActivity::class.java, true, false)

    @Test
    fun displayBugsList() {
        activityTestRule.launchActivity(null)
        onView(withId(R.id.rv_bugs)).check(matches(isDisplayed()))
        onView(withId(R.id.progress_bar)).check(matches(not(isDisplayed())))
    }

    @Test
    fun openBugDetailsOnBugItemClicked() {
        activityTestRule.launchActivity(null)

        onView(withId(R.id.rv_bugs))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                    0,
                    click()
                )
            )
        intended(hasComponent(BugDetailsActivity::class.java.name))
    }
}