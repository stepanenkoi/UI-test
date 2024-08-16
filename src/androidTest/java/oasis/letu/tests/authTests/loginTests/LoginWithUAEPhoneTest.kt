package oasis.letu.tests.authTests.loginTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToLoginUAEScreenScenario
import oasis.letu.screens.authScreens.LoginSmsCodeScreen
import oasis.letu.testData.TestDataScreen.LOGIN_SMS_CODE
import org.junit.Test
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step

class LoginWithUAEPhoneTest :
    DefaultTest("Mobile. Android. Auth. Авторизация. Логин по телефону и СМС - позитивный") {
    @Test
    @AllureId("56126")
    @Step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с UAE телефоном")
    fun authTest_56126() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с UAE телефоном") {
            scenario(GoToLoginUAEScreenScenario())
            LoginSmsCodeScreen {
                enterPhoneCode(LOGIN_SMS_CODE)
                clickLogInButton()
            }
        }
    }
}
