package ru.letu.ui.base

import android.content.Context
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters
import ru.letu.network.features.test.TestUtils.startTests
import ru.letu.ui.helpers.other.UiTestsHandler

/**
 * !!!DO NOT REMOVE!!!
 * There's nothing to watch here. Move along, traveler.
 * Class seems useless, but is needed for correct UI-test work.
 * Removal or switching for another class or interface may cause unpredictable troubles.
 * Consider this class having @Magic and @DoNotTouch annotations.
 */
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)
class BaseTest {
    @Before
    fun setup() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        Espresso.setFailureHandler(UiTestsHandler(instrumentation))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
                "pm grant " + ApplicationProvider.getApplicationContext<Context>().packageName +
                    " android.permission.ACCESS_FINE_LOCATION"
            )
            InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
                "pm grant " + ApplicationProvider.getApplicationContext<Context>().packageName +
                    " android.permission.ACCESS_COARSE_LOCATION"
            )
        }
        startTests()
    }

    @Rule
    var mActivityTestRule = ActivityScenarioRule(MainActivity::class.java)
}
