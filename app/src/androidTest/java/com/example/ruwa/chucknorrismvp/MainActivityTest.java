package com.example.ruwa.chucknorrismvp;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.example.ruwa.chucknorrismvp.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

/**
 * Created by ruwanka on 4/24/2016.
 * ChuckNorrisMVP is a sample project that shows how to use MVP architectural pattern in android
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest{

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void jokeStringAppearsOnGetRandomJoke(){
        onView(withId(R.id.btnRandomJoke)).perform(click());
        onView(withId(R.id.txtstatus)).check(matches(withText(not(isEmptyOrNullString()))));
    }

}
