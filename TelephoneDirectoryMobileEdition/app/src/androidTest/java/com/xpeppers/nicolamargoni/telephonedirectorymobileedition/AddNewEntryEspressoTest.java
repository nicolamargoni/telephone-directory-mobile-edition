package com.xpeppers.nicolamargoni.telephonedirectorymobileedition;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.activities.HomePageActivity;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.Contact;
import com.xpeppers.nicolamargoni.telephonedirectorymobileedition.models.ContactItem;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.EasyMock2Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class AddNewEntryEspressoTest {

    @Rule
    public ActivityTestRule<HomePageActivity> activityTestRule =
            new ActivityTestRule(HomePageActivity.class);

    @Test
    public void addNewEntry() throws Exception {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_firstname)).perform(typeText("Nicola"));
        onView(withId(R.id.editText_lasttname)).perform(typeText("Margoni"));
        onView(withId(R.id.editText_telephone_number)).perform(typeText("+39 340 5789420"));
        onView(withId(R.id.button_add)).perform(click());

        onView(withText("Nicola Margoni")).check(matches(isDisplayed()));
    }

    @Test
    public void addNotValidEntry() throws Exception {
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_lasttname)).perform(typeText("Margoni"));
        onView(withId(R.id.editText_telephone_number)).perform(typeText("+39 340 5789420"));
        onView(withId(R.id.button_add)).perform(click());

        onView(withText("The first name is empty")).check(matches(isDisplayed()));
    }



    @Test
    public void addMoreEntries() throws Exception {
        for (Contact contact : contacts) {
            onView(withId(R.id.button_add)).perform(click());
            onView(withId(R.id.editText_firstname)).perform(typeText(contact.firstName));
            onView(withId(R.id.editText_lasttname)).perform(typeText(contact.lastName));
            onView(withId(R.id.editText_telephone_number)).perform(typeText(contact.telephoneNumber));
            onView(withId(R.id.button_add)).perform(click());

            onView(withText(contact.firstName + " " + contact.lastName)).check(matches(isDisplayed()));
        }
    }

    private Contact[] contacts = {
            new Contact("Franco", "Rossi", "+39 334 565433"),
            new Contact("Sara", "Avancini", "+39 340 568234")
    };

}