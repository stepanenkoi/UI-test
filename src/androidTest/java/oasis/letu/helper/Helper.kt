package oasis.letu.helper

import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.assertion.ViewAssertions
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
