package oasis.letu.tests.personalDataTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.LoginScenario
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.menuScreens.PersonalDataScreen
import org.junit.Test

class CheckPersonalDataTest :
    DefaultTest("UAE.Mobile.Android.Меню.Профиль. Личные данные. Отображение окна (данные уже были добавлены)") {
    @Test
    @AllureId("56529")
    @Step("UAE.Mobile.Android.Меню.Профиль. Личные данные. Отображение окна (данные уже были добавлены)")
    fun authTest_56529() {
        test()
    }
    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  UAE телефоном") {
            scenario(LoginScenario())
            MenuScreen {
                openPersonalInformation()
            }
            PersonalDataScreen {
                checkFirstNameFieldWithName()
                checkLastNameFieldWithName()
                checkDateFieldWithDate()
                checkMaletIsActive()
                checkResidentIsActive()
                checkPhoneFieldWithPhone()
                scrollToEnd()
                checkEmailFieldWithEmail()
                checkTogglesOn()
            }
        }
    }
}
