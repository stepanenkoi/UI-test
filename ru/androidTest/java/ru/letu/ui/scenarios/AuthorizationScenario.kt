package ru.letu.ui.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import ru.letu.ui.base.DefaultTest.Companion.WAIT_TIME
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

class AuthorizationScenario(phone: String, sms: String) : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Авторизоваться по телефону $phone") {
            scenario(GoToLoginScreenScenario())
            SimplifiedAuthorizationScreen {
                enterPhoneNumber(phone)
                continueAuthClick()
                enterPhoneCode(sms)
            }
            waitForDisplayed(ru.letu.R.id.userName, WAIT_TIME)
        }
    }
}
