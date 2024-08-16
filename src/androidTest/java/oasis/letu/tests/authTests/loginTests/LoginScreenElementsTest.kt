package oasis.letu.tests.authTests.loginTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToLoginScreenScenario
import oasis.letu.screens.authScreens.LoginSmsCodeScreen
import org.junit.Test

// #56127 Mobile.Android.Auth.Авторизация.Телефон. Проверка отображения элементов на экране Логин или Регистрация и экране ввода кода

class LoginScreenElementsTest :
    DefaultTest("Mobile.Android.Auth.Авторизация.Телефон. Проверка отображения элементов на экране Логин") {
    @Test
    @AllureId("56127")
    @Step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  телефоном")
    fun authTest_56127() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  телефоном") {
            scenario(GoToLoginScreenScenario())
            LoginSmsCodeScreen {
                checkCodeSendToNumberText()
                checkPhoneNumber()
                checkSmsCodeField()
                checkTimerText()
                checkLogInButton()
            }
        }
    }
}
