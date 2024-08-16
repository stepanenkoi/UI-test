package oasis.letu.helper

import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.widget.NestedScrollView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.PerformException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.util.HumanReadables
import androidx.test.espresso.util.TreeIterables
import com.google.android.material.appbar.CollapsingToolbarLayout
import io.github.kakaocup.kakao.common.views.KView
import oasis.letu.exceptions.TestUtilsException
import org.hamcrest.BaseMatcher
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import ru.letoile.android.logger.Logger
import ru.letu.network.utils.TestUtils.networkCountingResource
import java.util.concurrent.TimeoutException

object TestUtils {
    /* watch logs*/
    fun dumpThreads() {
        val activeCount = Thread.activeCount()
        val threads = arrayOfNulls<Thread>(activeCount)
        Thread.enumerate(threads)
        for (thread in threads) {
            Logger.e(TestUtilsException("${thread?.name} : ${thread?.state}"))
            val stackTraceList = thread?.stackTrace.orEmpty()
            for (stackTraceElement in stackTraceList) {
                Logger.e(TestUtilsException("\t$stackTraceElement"))
            }
        }
    }

    fun getText(matcher: Matcher<View?>?): String {
        val stringHolder = arrayOf<String?>(null)
        onView(matcher).perform(object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return isAssignableFrom(TextView::class.java)
            }

            override fun getDescription(): String {
                return "getting text from a TextView"
            }

            override fun perform(uiController: UiController, view: View) {
                val tv = view as TextView // Save, because of check in getConstraints()
                stringHolder[0] = tv.text.toString()
            }
        })
        return stringHolder[0] ?: "0"
    }

    fun sleep(time: Int) {
        try {
            Thread.sleep(time.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun sleep() {
        sleep(10000)
    }

    fun waitAnimation() {
        sleep(1000)
    }

    fun waitLoading() {
        sleep(7000)
    }

    fun waitFor(viewInfo: ViewInfo) {
        Espresso.onView(ViewMatchers.isRoot()).perform(waitId(viewInfo, 1000))
    }

    fun waitForDisappear(viewInfo: ViewInfo) {
        Espresso.onView(ViewMatchers.isRoot()).perform(waitElementToDisappear(viewInfo, 1000))
    }

    fun waitForResponses() {
        IdlingRegistry.getInstance().register(networkCountingResource)
    }

    fun scrollDownBy(y: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return Matchers.allOf(
                    ViewMatchers.isDescendantOfA(
                        ViewMatchers.isAssignableFrom(
                            NestedScrollView::class.java
                        )
                    ),
                    ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
                )
            }

            override fun getDescription(): String {
                return "Find parent with type " + NestedScrollView::class.java +
                    " of matched view and programmatically scroll to bottom."
            }

            override fun perform(uiController: UiController, view: View) {
                try {
                    val nestedScrollView = findFirstParentLayoutOfClass(
                        view,
                        NestedScrollView::class.java
                    ) as NestedScrollView?
                    if (nestedScrollView != null) {
                        val coordinatorLayout = findFirstParentLayoutOfClass(
                            view,
                            CoordinatorLayout::class.java
                        ) as CoordinatorLayout?
                        if (coordinatorLayout != null) {
                            val collapsingToolbarLayout =
                                findCollapsingToolbarLayoutChildIn(coordinatorLayout)
                            if (collapsingToolbarLayout != null) {
                                val toolbarHeight = collapsingToolbarLayout.height
                                nestedScrollView.startNestedScroll(ViewCompat.SCROLL_AXIS_VERTICAL)
                                nestedScrollView.dispatchNestedPreScroll(0, toolbarHeight, null, null)
                            }
                        }
                        nestedScrollView.scrollBy(0, y)
                    } else {
                        throw TestUtilsException("Unable to find NestedScrollView parent.")
                    }
                } catch (e: Exception) {
                    throw PerformException.Builder()
                        .withActionDescription(this.description)
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(e)
                        .build()
                }
                uiController.loopMainThreadUntilIdle()
            }
        }
    }

    private fun findCollapsingToolbarLayoutChildIn(viewGroup: ViewGroup): CollapsingToolbarLayout? {
        for (i in 0 until viewGroup.childCount) {
            val child = viewGroup.getChildAt(i)
            if (child is CollapsingToolbarLayout) {
                return child
            } else if (child is ViewGroup) {
                return findCollapsingToolbarLayoutChildIn(child)
            }
        }
        return null
    }

    private fun findFirstParentLayoutOfClass(view: View, parentClass: Class<out View>): View? {
        var parent: ViewParent? = FrameLayout(view.context)
        var incrementView: ViewParent? = null
        var i = 0
        while (parent != null && parent.javaClass != parentClass) {
            parent = if (i == 0) {
                view.parent
            } else {
                incrementView?.parent
            }
            incrementView = parent
            i++
        }
        return parent as? View
    }

    fun <T> first(matcher: Matcher<T>): Matcher<T> {
        return object : BaseMatcher<T>() {
            var isFirst = true
            var count = 0
            var view: View? = null
            override fun matches(item: Any): Boolean {
                return if (item is View) {
                    val view = item
                    if (matcher.matches(item)) {
                        Logger.d("matches $view")
                        if (isFirst) {
                            Logger.d("isFirst")
                            this.view = view
                            isFirst = false
                            count++
                            true
                        } else {
                            val theSameView = this.view == view
                            Logger.d("this equals: $theSameView")
                            theSameView
                        }
                    } else {
                        false
                    }
                } else {
                    false
                }
            }

            override fun describeTo(description: Description) {
                description.appendText("should return first matching item$isFirst$view")
            }
        }
    }

    fun <T> atPosition(matcher: Matcher<T>, position: Int): Matcher<T> {
        return object : BaseMatcher<T>() {
            var count = 0
            var view: View? = null
            override fun matches(item: Any): Boolean {
                return if (item is View) {
                    val view = item
                    if (matcher.matches(item)) {
                        Logger.d("matches $view")
                        if (count == position) {
                            Logger.d("Position")
                            this.view = view
                            count++
                            true
                        } else {
                            val theSameView = this.view == view
                            Logger.d("this equals: $theSameView")
                            theSameView
                        }
                    } else {
                        false
                    }
                } else {
                    false
                }
            }

            override fun describeTo(description: Description) {
                description.appendText("should return first matching item at desired position$view")
            }
        }
    }

    fun childAtPosition(
        parentMatcher: Matcher<View?>,
        position: Int
    ): Matcher<View?> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return (
                    parent is ViewGroup && parentMatcher.matches(parent) &&
                        view == parent.getChildAt(position)
                    )
            }
        }
    }

    fun textIsEqual(element: ViewInteraction, text: String?) {
        element.check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString(text))))
    }

    /**
     * Perform action of waiting for a specific view id.
     * @param viewInfo The info of the view to wait for.
     * @param millis The timeout of until when to wait for.
     */
    private fun waitId(viewInfo: ViewInfo, millis: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isRoot()
            }

            override fun getDescription(): String =
                "wait for a specific view with id <${viewInfo.viewName}> during $millis millis."

            override fun perform(uiController: UiController, view: View) {
                uiController.loopMainThreadUntilIdle()
                val startTime = System.currentTimeMillis()
                val endTime = startTime + millis
                val viewMatcher =
                    Matchers.allOf(ViewMatchers.withId(viewInfo.viewId), ViewMatchers.isDisplayed())
                do {
                    for (child in TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child)) {
                            return
                        }
                    }
                    uiController.loopMainThreadForAtLeast(50)
                } while (System.currentTimeMillis() < endTime)
                throw PerformException.Builder()
                    .withActionDescription(this.description)
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(TimeoutException())
                    .build()
            }
        }
    }

    /**
     * Perform action of waiting for a specific view id to disappear.
     * @param viewInfo The info of the view to wait for.
     * @param millis The timeout of until when to wait for.
     */
    private fun waitElementToDisappear(viewInfo: ViewInfo, millis: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> {
                return ViewMatchers.isRoot()
            }

            override fun getDescription(): String =
                "wait to disappear for a specific view with id <${viewInfo.viewName}> during $millis millis."

            override fun perform(uiController: UiController, view: View) {
                uiController.loopMainThreadUntilIdle()
                val startTime = System.currentTimeMillis()
                val endTime = startTime + millis
                val viewMatcher =
                    Matchers.allOf(ViewMatchers.withId(viewInfo.viewId), ViewMatchers.isDisplayed())
                do {
                    var found = false
                    for (child in TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child)) {
                            found = true
                        }
                    }
                    if (!found) {
                        return
                    }
                    uiController.loopMainThreadForAtLeast(50)
                } while (System.currentTimeMillis() < endTime)
                throw PerformException.Builder()
                    .withActionDescription(this.description)
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(TimeoutException())
                    .build()
            }
        }
    }

    fun setTextAndClose(@IdRes editTextId: Int, text: String) {
        Espresso.onView(ViewMatchers.withId(editTextId))
            .perform(ScrollToAction(), ViewActions.replaceText(text), ViewActions.closeSoftKeyboard())
    }

    fun setTextAndApplyIME(@IdRes editTextId: Int, text: String) {
        Espresso.onView(ViewMatchers.withId(editTextId))
            .perform(ScrollToAction(), ViewActions.replaceText(text), ViewActions.pressImeActionButton())
    }

    fun withIndex(matcher: Matcher<View?>, index: Int): Matcher<View?> {
        return object : TypeSafeMatcher<View?>() {
            var currentIndex = 0
            override fun describeTo(description: Description) {
                description.appendText("with index: ")
                description.appendValue(index)
                matcher.describeTo(description)
            }

            override fun matchesSafely(view: View?): Boolean {
                return matcher.matches(view) && currentIndex++ == index
            }
        }
    }

    fun clickText(text: String) {
        val view = KView {
            withText(text)
        }
        view.click()
    }

    fun clickText(text: Int) {
        KView { withText(text) }.click()
    }

    fun waitForViewIndex(viewId: Int, index: Int, timeout: Long): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): org.hamcrest.Matcher<View>? {
                return isRoot()
            }

            override fun getDescription(): String {
                return "wait for a specific view with id $viewId; during $timeout millis."
            }

            override fun perform(uiController: UiController, rootView: View) {
                uiController.loopMainThreadUntilIdle()
                val startTime = System.currentTimeMillis()
                val endTime = startTime + timeout
                val viewMatcher = allOf(withIndex(withId(viewId), index)) // index(index)

                do {
                    // Iterate through all views on the screen and see if the view we are looking for is there already
                    for (child in TreeIterables.breadthFirstViewTraversal(rootView)) {
                        // found view with required ID
                        if (viewMatcher.matches(child)) {
                            return
                        }
                    }
                    // Loops the main thread for a specified period of time.
                    // Control may not return immediately, instead it'll return after the provided delay has passed and the queue is in an idle state again.
                    uiController.loopMainThreadForAtLeast(100)
                } while (System.currentTimeMillis() < endTime) // in case of a timeout we throw an exception -> test fails
                throw PerformException.Builder()
                    .withCause(TimeoutException())
                    .withActionDescription(this.description)
                    .withViewDescription(HumanReadables.describe(rootView))
                    .build()
            }
        }
    }
}
