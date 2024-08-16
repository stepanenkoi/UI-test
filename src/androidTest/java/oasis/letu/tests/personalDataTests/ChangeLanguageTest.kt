package oasis.letu.tests.personalDataTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.RegistrationScenario
import oasis.letu.screens.menuScreens.PersonalDataScreen
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/58587?treeId=14

class ChangeLanguageTest :
    DefaultTest("UAE.Mobile.Android.Меню.Профиль.Личные данные.Смена языка") {
    @Test
    @AllureId("58587")
    @Step("UAE.Mobile.Android.Меню.Профиль.Личные данные.Смена языка")
    fun authTest_58587() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  UAE телефоном") {
            scenario(RegistrationScenario())
            PersonalDataScreen {
                scrollToEnd()
                clickChangeLanguage()
                checkLanguage()
                checkArab()
                checkEnglish()
                clickArabic()
                checkChangeToArab()
                clickEnglish()
                checkChangeToEnglish()
            }
        }
    }
}
