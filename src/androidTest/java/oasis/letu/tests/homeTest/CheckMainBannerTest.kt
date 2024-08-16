package oasis.letu.tests.homeTest

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import oasis.letu.helper.accessLocationPermissions
import oasis.letu.screens.HomeScreen
import org.junit.Rule
import org.junit.Test
import ru.letu.ui.base.MainActivity

// https://testops.letoile.tech/project/2/test-cases/56747?treeId=14

class CheckMainBannerTest : TestCase() {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun myTest() = run {
        before {
            accessLocationPermissions()
        }.after {
        }.run {
            step("Check banner details") {
                Thread.sleep(4000)
                HomeScreen {
                    logoImage {
                        isVisible()
                    }
                    bannerTitle {
                        isVisible()
                    }
                    bannerDescription {
                        isVisible()
                    }
                    bannerIndicator {
                        isVisible()
                    }
                }
            }
        }
    }
}
