package oasis.letu.tests.personalDataTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.RegistrationScenario
import oasis.letu.screens.menuScreens.PersonalDataScreen
import org.junit.Test

class PersonalDataErrorTest :
    DefaultTest(
        "UAE.Mobile.Android.Меню.Профиль.Личные данные. Отправка пустой формы"
    ) {
    @Test
    @AllureId("56524")
    @Step("UAE.Mobile.Android.Меню.Профиль.Личные данные. Отправка пустой формы")
    fun authTest_56524() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  UAE телефоном") {
            scenario(RegistrationScenario())
            PersonalDataScreen {
                scrollToEnd()
                clickSaveButton()
                checkFirstNameError()
                checkLastNameError()
                checkDateError()
                checkEmailError()
                scrollToUp()
                addName()
                scrollToEnd()
                clickSaveButton()
                checkFirstNameNoError()
                checkLastNameError()
                checkDateError()
                checkEmailError()
                scrollToUp()
                addLastName()
                scrollToEnd()
                clickSaveButton()
                checkFirstNameNoError()
                checkLastNameNoError()
                checkDateError()
                checkEmailError()
                scrollToUp()
                addDate()
                scrollToEnd()
                addWrongEmail()
                scrollToEnd()
                clickSaveButton()
                checkFirstNameNoError()
                checkLastNameNoError()
                checkDateNoError()
                checkWrongEmailError()
                addEmail()
                scrollToEnd()
                clickSaveButton()
                checkFirstNameNoError()
                checkLastNameNoError()
                checkDateNoError()
                checkEmailNoError()
            }
        }
    }
}
