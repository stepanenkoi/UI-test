package oasis.letu.tests.authTests.loginTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToLoginScreenScenario
import oasis.letu.screens.authScreens.LoginSmsCodeScreen
import oasis.letu.testData.TestDataScreen.INCORRECT_SMS_CODE1
import oasis.letu.testData.TestDataScreen.INCORRECT_SMS_CODE2
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/58630?treeId=14&search=

class LoginErrorTest :
    DefaultTest("UAE. Mobile. Android. Auth. Регистрация. Отправка не до конца заполненного поля для смс RTL") {
    @Test
    @AllureId("58630")
    @Step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с телефоном")
    fun authTest_58630() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с телефоном") {
            scenario(GoToLoginScreenScenario())
            LoginSmsCodeScreen {
                clickLogIn()
                checkError()
                enterCode(INCORRECT_SMS_CODE1)
                clickLogIn()
                checkError()
                enterCode(INCORRECT_SMS_CODE2)
                clickLogIn()
                checkError()
            }
        }
    }
}
