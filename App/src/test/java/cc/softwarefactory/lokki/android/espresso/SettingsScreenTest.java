package cc.softwarefactory.lokki.android.espresso;

import cc.softwarefactory.lokki.android.R;
import cc.softwarefactory.lokki.android.espresso.utilities.TestUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



public class SettingsScreenTest extends MainActivityBaseTest {

    private void enterSettingsScreen() {
        getActivity();
        TestUtils.toggleNavigationDrawer();
        onView(withText(R.string.settings)).perform(click());
    }

    public void testSettingsScreenOpens() {
        enterSettingsScreen();
        onView(withId(R.id.user_name)).check(matches(isDisplayed()));
        onView(withId(R.id.lokki_id_text)).check(matches(isDisplayed()));
        onView(withId(R.id.visibility)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner_visibility)).check(matches(isDisplayed()));
        onView(withId(R.id.map_type)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner_map)).check(matches(isDisplayed()));
    }

    public void testVisibilityMenuOpensWhenClicked() {
        enterSettingsScreen();
        onView(withId(R.id.spinner_visibility)).perform(click());
        for (String choice : getResources().getStringArray(R.array.visibility_modes)) {
            onView(withText(choice)).check(matches(isDisplayed()));
        }
    }


    public void testMapModesMenuOpensWhenClicked() {
        enterSettingsScreen();
        onView(withId(R.id.spinner_map)).perform(click());
        for (String choice : getResources().getStringArray(R.array.map_modes)) {
            onView(withText(choice)).check(matches(isDisplayed()));
        }
    }

}