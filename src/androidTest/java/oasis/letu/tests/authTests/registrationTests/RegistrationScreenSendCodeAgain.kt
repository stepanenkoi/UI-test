package oasis.letu.tests.authTests.registrationTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToRegistrationScreenScenario
import oasis.letu.screens.authScreens.RegistrationSmsCodeScreen
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/58631?treeId=14&search=

class RegistrationScreenSendCodeAgain :
    DefaultTest(
        "UAE. Mobile. Android. Auth. Регистрация." +
        " Проверка отображения функции повторного отправления смс по окончанию таймера RTL"
    ) {
    @Test
    @AllureId("58631")
    @Step(
        "UAE. Mobile. Android. Auth. Регистрация." +
        " Проверка отображения функции повторного отправления смс по окончанию таймера RTL"
    )
    fun authTest_58631() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Регистрация.Телефон. Регистрация юзера с  телефоном") {
            scenario(GoToRegistrationScreenScenario())
            RegistrationSmsCodeScreen {
                SendCodeAgainButton {
                    isNotDisplayed()
                }
                flakySafely(timeoutMs = 120000000) { // так ожидание происходит
                    this@RegistrationSmsCodeScreen.SendCodeAgainButton.isVisible()
                }
            }
        }
    }
}
