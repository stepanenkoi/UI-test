package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

import oasis.letu.screens.navigation.BottomNavigation

class GoToMenuScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Открыть меню") {
            BottomNavigation {
                bottomMenu {
                    flakySafely(timeoutMs = 10000) { isVisible() }
                    setSelectedItem(4)
                }
            }
        }
    }
}
