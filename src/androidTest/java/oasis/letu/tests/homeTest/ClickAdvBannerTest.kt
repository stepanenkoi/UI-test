package oasis.letu.tests.homeTest

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import oasis.letu.helper.accessLocationPermissions
import oasis.letu.screens.HomeScreen
import org.junit.Rule
import org.junit.Test
import ru.letu.ui.base.MainActivity

// https://testops.letoile.tech/project/2/test-cases/57734?treeId=14

class ClickAdvBannerTest : TestCase() {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun myTest() = run {
        before {
            accessLocationPermissions()
        }.after {
        }.run {
            step("Click banner") {
                HomeScreen {
                    Thread.sleep(4000)
                    advertisingBannerVP {
                        click()
                    }
                }
            }
            step("Check screen") {
            }
        }
    }
}
