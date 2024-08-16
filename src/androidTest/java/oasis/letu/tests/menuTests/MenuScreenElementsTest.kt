package oasis.letu.tests.menuTests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.idlewaiting.KautomatorWaitForIdleSettings
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import oasis.letu.helper.accessLocationPermissions
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation
import org.junit.Rule
import org.junit.Test
import ru.letu.navigation.core.routing.featureRouter
import ru.letu.routes.MainFlowRoute
import ru.letu.ui.base.MainActivity

class MenuScreenElementsTest : TestCase(
    kaspressoBuilder = Kaspresso.Builder.simple {
        kautomatorWaitForIdleSettings = KautomatorWaitForIdleSettings.boost()
    }
) {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun myTest() = run {
        before {
            featureRouter newRoot MainFlowRoute()
            accessLocationPermissions()
        }.after {
        }.run {
            step("Открыть меню") {
                Thread.sleep(5000)
                BottomNavigation {
                    openBottomMenu()
                }
                step("Проверка элементов на экране") {
                    MenuScreen {
                        loginOrRegisterButton {
                            isVisible()
                            isClickable()
                        }
                    }
                }
            }
        }
    }
}
