package oasis.letu.tests.authTests.registrationTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToRegistrationUAEScreenScenario
import oasis.letu.screens.authScreens.RegistrationSmsCodeScreen
import oasis.letu.screens.authScreens.WelcomeToLetoileWorldWithCardScreen
import oasis.letu.testData.TestDataScreen
import org.junit.Test

// #56135 UAE.Mobile.Android.Auth.Регистрация.Телефон. Регистрации юзера с UAE телефоном (ВЫключенный тоггл I would like)

class RegistrationWithUAEPhoneTest :
    DefaultTest(
        "UAE.Mobile.Android.Auth.Регистрация." +
        "Телефон. Регистрации юзера с UAE телефоном (ВЫключенный тоггл I would like)"
    ) {
    @Test
    @AllureId("56135")
    @Step("Mobile.Android.Auth.Регистрация.Телефон. Регистрация юзера с  телефоном")
    fun authTest_56135() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Регистрация.Телефон. Регистрация юзера с  телефоном") {
            scenario(GoToRegistrationUAEScreenScenario())
            RegistrationSmsCodeScreen {
                enterPhoneCode(TestDataScreen.LOGIN_SMS_CODE)
                clickPrivacyPolicyAgreementToggle()
                clickRegisterUAEButton()
            }
            WelcomeToLetoileWorldWithCardScreen {
                clickActivateCardButton()
            }
        }
    }
}
