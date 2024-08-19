package ru.letu.ui.screens

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

class AuthUserScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Перейти на экран авторизации") {
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
                openBottomMenu()
            }
            MenuScreen {
                openAuthorizationScreen()
            }
        }
        step("Авторизоваться пользователем по email") {
            SimplifiedAuthorizationScreen {
                emailTitle.click()
                enterEmail("cord@mail.ru")
                continueAuthClick()
                enterPassword("123456789")
                closeSoftKeyboard()
                continueAuthClick()
            }
        }
    }
}
