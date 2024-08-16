package oasis.letu.tests.authTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToAuthScreenScenario
import oasis.letu.screens.authScreens.AuthorizationScreen
import oasis.letu.testData.TestDataScreen
import org.junit.Test

// #56128 UAE.Mobile.Android.Auth.Авторизация.Телефон. Показ сообщений об ошибке для пустого/неверного/неизвестного формата номера телефона

class AuthErrorTest :
    DefaultTest(
        "UAE.Mobile.Android.Auth.Авторизация.Телефон. " +
        "Показ сообщений об ошибке для пустого/неверного/неизвестного формата номера телефона"
    ) {
    @Test
    @AllureId("56128")
    @Step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  телефоном")
    fun authTest_56128() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон.Ввод номера телефона") {
            scenario(GoToAuthScreenScenario())
            AuthorizationScreen {
                clickSendCode()
                checkError()
                enterPhone(TestDataScreen.INCORRECT_PHONE1)
                clickSendCode()
                checkError()
                enterPhone(TestDataScreen.INCORRECT_PHONE2)
                clickSendCode()
                checkError()
            }
        }
    }
}
