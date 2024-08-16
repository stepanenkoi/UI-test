package oasis.letu.tests.authTests.registrationTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToRegistrationScreenScenario
import oasis.letu.screens.authScreens.RegistrationSmsCodeScreen
import org.junit.Test

// #56139 UAE.Mobile.Android.Auth.Регистрация.Телефон. Проверка отображения элементов на экране ввода кода

class RegistrationScreenElementsTest :
    DefaultTest("UAE.Mobile.Android.Auth.Регистрация.Телефон. Проверка отображения элементов на экране ввода кода") {
    @Test
    @AllureId("56139")
    @Step("Mobile.Android.Auth.Регистрация.Телефон. Регистрация юзера с  телефоном")
    fun authTest_56139() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Регистрация.Телефон. Регистрация юзера с  телефоном") {
            scenario(GoToRegistrationScreenScenario())
            RegistrationSmsCodeScreen {
                checkCodeSendToNumberText()
                checkPhoneNumber()
                checkSmsCodeField()
                checkTimerText()
                checkNewsToggleText()
                checkNewsToggle()
                checkPrivacyPolicyAgreementText()
                checkPrivacyPolicyAgreementToggle()
                checkRegisterButton()
            }
        }
    }
}
