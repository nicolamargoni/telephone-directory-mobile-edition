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
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
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
public class SearchEntryEspressoTest {

    @Rule
    public ActivityTestRule<HomePageActivity> activityTestRule =
            new ActivityTestRule(HomePageActivity.class);



    @Test
    public void searchEntry() throws Exception {
        for (Contact contact : contacts) {
            onView(withId(R.id.button_add)).perform(click());
            onView(withId(R.id.editText_firstname)).perform(typeText(contact.firstName));
            onView(withId(R.id.editText_lasttname)).perform(typeText(contact.lastName));
            onView(withId(R.id.editText_telephone_number)).perform(typeText(contact.telephoneNumber));
            onView(withId(R.id.button_add)).perform(click());
        }

        onView(withId(R.id.search_button)).perform(click());
        onView(withId(R.id.search_src_text)).perform(typeText("ola"));

        onView(withText("Nicola Margoni")).check(matches(isDisplayed()));
        onView(withText("Franco Rossi")).check(doesNotExist());
        onView(withText("Sara Avancini")).check(doesNotExist());
    }


    private Contact[] contacts = {
            new Contact("Nicola", "Margoni", "+39 340 568974"),
            new Contact("Franco", "Rossi", "+39 334 565433"),
            new Contact("Sara", "Avancini", "+39 340 568234")
    };
}