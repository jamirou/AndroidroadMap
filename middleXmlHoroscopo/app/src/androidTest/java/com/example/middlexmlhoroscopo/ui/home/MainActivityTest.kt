package com.example.middlexmlhoroscopo.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.middlexmlhoroscopo.R
import com.example.middlexmlhoroscopo.ui.detail.HoroscopoDetailActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        hiltRule.inject()
        Intents.init()
    }
    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun when_main_activity_is_created_then_should_show_horoscope() {
        onView(withId(R.id.luckFragment)).perform(click())
    }

    @Test
    fun when_horoscope_is_selected_should_show_detail() {
        onView(withId(R.id.RecyclerViewHoroscopo)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        intended(hasComponent((HoroscopoDetailActivity::class.java.name)))
    }
}