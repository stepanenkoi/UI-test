package ru.letu.ui.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class GoToLoginScreenScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        Navigation.openBottomMenu()
        MenuScreen.openAuthorizationScreen()
    }
}
