package com.xpeppers.nicolamargoni.telephonedirectorymobileedition;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.activities.HomePageActivity;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EditEntryEspressoTest {

    @Rule
    public ActivityTestRule<HomePageActivity> activityTestRule =
            new ActivityTestRule(HomePageActivity.class);

    @Test
    public void editEntry() throws Exception {

        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_firstname)).perform(typeText("Nic"));
        onView(withId(R.id.editText_lasttname)).perform(typeText("Margoni"));
        onView(withId(R.id.editText_telephone_number)).perform(typeText("+39 340 5789420"));
        onView(withId(R.id.button_add)).perform(click());

        onView(withId(R.id.button_edit)).perform(click());
        onView(withId(R.id.editText_firstname)).perform(typeText("ola"));
        onView(withId(R.id.button_edit)).perform(click());

        onView(withText("Nicola Margoni")).check(matches(isDisplayed()));
    }
}