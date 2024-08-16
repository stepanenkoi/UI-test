package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.helper.TestUtils.clickText
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation

class LogOutScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("LogOut") {
            BottomNavigation {
                flakySafely(timeoutMs = 1000) {
                    openBottomMenu()
                    MenuScreen {
                        flakySafely(timeoutMs = 4000) {
                            scrollToEnd()
                            clickText("Log Out")
                        }
                    }
                }
            }
        }
    }
}
