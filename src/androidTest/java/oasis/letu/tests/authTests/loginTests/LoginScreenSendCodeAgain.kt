package oasis.letu.tests.authTests.loginTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToLoginScreenScenario
import oasis.letu.screens.authScreens.LoginSmsCodeScreen
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/56355?treeId=14&search=

class LoginScreenSendCodeAgain :
    DefaultTest("UAE.Mobile.Android.Auth.Авторизация.Телефон. Проверка повторной отправки смс кода.") {
    @Test
    @AllureId("56355")
    @Step("UAE.Mobile.Android.Auth.Авторизация.Телефон. Проверка повторной отправки смс кода.")
    fun authTest_56355() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  телефоном") {
            scenario(GoToLoginScreenScenario())
            LoginSmsCodeScreen {
                SendCodeAgainButton {
                    isNotDisplayed()
                }
                flakySafely(timeoutMs = 120000000) { // так ожидание происходит
                    this@LoginSmsCodeScreen.SendCodeAgainButton.isVisible()
                }
            }
        }
    }
}
