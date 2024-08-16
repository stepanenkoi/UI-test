package oasis.letu.tests.personalDataTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.RegistrationScenario
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.menuScreens.PersonalDataScreen
import org.junit.Test

class AddPersonalDataTest :
    DefaultTest(
        "UAE.Mobile.Android.Меню.Профиль.Личные данные. Ввод данных (позитив)"
    ) {
    @Test
    @AllureId("56519")
    @Step("UAE.Mobile.Android.Меню.Профиль.Личные данные. Ввод данных (позитив)")
    fun authTest_56519() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  UAE телефоном") {
            scenario(RegistrationScenario())
            PersonalDataScreen {
                addName()
                checkFirstNameFieldWithName()
                addLastName()
                checkLastNameFieldWithName()
                addDate()
                checkDateFieldWithDate()
                clickFemaleGender()
                clickMaleGender()
                closeSoftKeyboard()
                clickLocalAccount()
                clickResidentAccount()
                clickTouristAccount()
                scrollToEnd()
                addRandomEmail()
                checkEmailFieldWithRandomEmail()
                clickSMSToggle()
                clickEmailToggle()
                closeSoftKeyboard()
                clickSaveButton()
                pressBack()
            }
            MenuScreen {
                openPersonalInformation()
            }
            PersonalDataScreen {
                checkFirstNameFieldWithName()
                checkLastNameFieldWithName()
                checkDateFieldWithDate()
                scrollToEnd()
                checkEmailFieldWithRandomEmail()
            }
        }
    }
}
