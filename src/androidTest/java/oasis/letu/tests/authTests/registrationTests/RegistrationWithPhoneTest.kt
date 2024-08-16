package oasis.letu.tests.authTests.registrationTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToRegistrationScreenScenario
import oasis.letu.screens.authScreens.RegistrationSmsCodeScreen
import oasis.letu.screens.authScreens.WelcomeToLetoileWorldScreen
import oasis.letu.testData.TestDataScreen
import org.junit.Test

// #56136 UAE.Mobile.Android.Auth.Регистрация.Телефон. Регистрации юзера с НЕ UAE телефоном (включенный тоггл I would like)

class RegistrationWithPhoneTest :
    DefaultTest(
        "UAE.Mobile.Android.Auth.Регистрация.Телефон. " +
        "Регистрации юзера с НЕ UAE телефоном (включенный тоггл I would like)"
    ) {
    @Test
    @AllureId("56136")
    @Step("Mobile.Android.Auth.Регистрация.Телефон. Регистрация юзера с  телефоном")
    fun authTest_56136() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Регистрация.Телефон. Регистрация юзера с  телефоном") {
            scenario(GoToRegistrationScreenScenario())
            RegistrationSmsCodeScreen {
                enterPhoneCode(TestDataScreen.LOGIN_SMS_CODE)
                clickNewsToggle()
                clickPrivacyPolicyAgreementToggle()
                clickRegisterButton()
            }
            WelcomeToLetoileWorldScreen {
                clickStartShoppingButton()
            }
        }
    }
}
