package oasis.letu.tests.authTests.loginTests

import oasis.letu.screens.authScreens.LoginSmsCodeScreen
import org.junit.Test
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.base.DefaultTest
import oasis.letu.testData.TestDataScreen.LOGIN_SMS_CODE
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.scenarios.GoToLoginScreenScenario

// #56131 Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с НЕ UAE телефоном

class LoginWithPhoneTest :
    DefaultTest("Mobile. Android. Auth. Авторизация. Email. Логин по телефону и СМС - позитивный") {
    @Test
    @AllureId("56131")
    @Step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  телефоном")
    fun authTest_56131() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  телефоном") {
            scenario(GoToLoginScreenScenario())
            LoginSmsCodeScreen {
                enterPhoneCode(LOGIN_SMS_CODE)
                clickLogInButton()
            }
        }
    }
}
