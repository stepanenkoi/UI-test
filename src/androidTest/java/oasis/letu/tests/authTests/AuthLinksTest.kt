package oasis.letu.tests.authTests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import ru.letu.ui.base.MainActivity

class AuthLinksTest : TestCase() {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun myTest() = run {
        step("") {
            before {
            }.after {
            }.run {

// жду линки
            }
        }
    }
}
