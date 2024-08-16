package oasis.letu.tests.authTests.loginTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToRegistrationScreenScenario
import oasis.letu.screens.authScreens.RegistrationSmsCodeScreen
import oasis.letu.testData.TestDataScreen
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/56138?treeId=14&search=

class RegistrationErrorTest :
    DefaultTest("UAE. Mobile. Android. Auth. Регистрация. Отправка не до конца заполненного поля для смс RTL") {
    @Test
    @AllureId("58138")
    @Step("Mobile.Android.Auth.Регистрация.Телефон. Регистрация юзера с  телефоном")
    fun authTest_58138() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  телефоном") {
            scenario(GoToRegistrationScreenScenario())
            RegistrationSmsCodeScreen {
                clickRegister()
                checkFieldError()
                checkToggleError()
                enterCode(TestDataScreen.INCORRECT_SMS_CODE1)
                clickRegister()
                checkFieldError()
                checkToggleError()
                enterCode(TestDataScreen.INCORRECT_SMS_CODE2)
                clickRegister()
                checkFieldError()
                checkToggleError()
                clickPrivacyPolicyAgreementToggle()
                checkFieldError()
                checkNoToggleError()
            }
        }
    }
}
