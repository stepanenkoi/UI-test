package oasis.letu.tests.authTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToAuthScreenScenario
import oasis.letu.screens.authScreens.AuthorizationScreen
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/56682?treeId=14&search=

class AuthScreenElementsTest :
    DefaultTest("UAE.Mobile.iOS.Auth.Регистрация. Телефон. Проверка верстки на экрах флоу регистрации") {
    @Test
    @AllureId("56682")
    @Step("UAE.Mobile.iOS.Auth.Регистрация. Телефон. Проверка верстки на экрах флоу регистрации")
    fun authTest_56682() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон.Ввод номера телефона") {
            scenario(GoToAuthScreenScenario())
            AuthorizationScreen {
                checkLoginOrRegister()
                checkCountrySelectionField()
                checkPhoneField()
                checkSendCodeBtn()
                checkAgreementText()
            }
        }
    }
}
