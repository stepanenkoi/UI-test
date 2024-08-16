package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation

class GoToAuthScreenScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {

        step("Открыть экран ввода телефона ") {
            BottomNavigation.openBottomMenu()
            MenuScreen.openAuthorizationScreen()
        }
    }
}
