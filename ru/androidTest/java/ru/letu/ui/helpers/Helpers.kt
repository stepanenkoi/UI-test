package ru.letu.ui.helpers

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

fun ViewInteraction.isGone() = getViewAssertion(Visibility.GONE)

fun ViewInteraction.isVisible() = getViewAssertion(Visibility.VISIBLE)

fun ViewInteraction.isDisplayed() = check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

fun ViewInteraction.isInvisible() = getViewAssertion(Visibility.INVISIBLE)

fun clickOnRecyclerViewAtPosition(index: Int): ViewAction =
    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(index, click())

fun withPositionOnView(recyclerViewId: Int, position: Int, viewId: Int): Matcher<View> {
    return object : TypeSafeMatcher<View>() {
        var childView: View? = null
        override fun describeTo(description: Description?) {
            description ?: return
            description.appendText("Is ")
        }

        override fun matchesSafely(item: View?): Boolean {
            item ?: return false
            if (null == childView) {
                val recyclerView = item.rootView.findViewById<RecyclerView?>(recyclerViewId) ?: return false
                childView = recyclerView.findViewHolderForAdapterPosition(position)?.itemView
            }

            if (childView != null) {
                return item == childView?.findViewById(viewId)
            }
            return false
        }
    }
}

fun clickOnRecyclerViewByItemPositionAndViewId(index: Int, @IdRes viewId: Int): ViewAction =
    RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(index, clickOnViewWithId(viewId))

private fun clickOnViewWithId(@IdRes id: Int): ViewAction = object : ViewAction {
    override fun getConstraints(): Matcher<View>? = null

    override fun getDescription(): String = "Click on a child view with specified id."

    override fun perform(uiController: UiController?, view: View?) {
        view?.findViewById<View?>(id)?.performClick()
    }
}

private fun getViewAssertion(visibility: Visibility): ViewAssertion? {
    return ViewAssertions.matches(withEffectiveVisibility(visibility))
}

fun childViewById(@IdRes parent: Int, @IdRes child: Int) =
    Espresso.onView(
        Matchers.allOf(
            ViewMatchers.withId(child),
            ViewMatchers.isDescendantOfA(ViewMatchers.withId(parent))
        )
    )

fun checkScreenIsDisplayed(@IdRes idRes: Int) {
    Espresso.onView(ViewMatchers.withId(idRes)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
}
