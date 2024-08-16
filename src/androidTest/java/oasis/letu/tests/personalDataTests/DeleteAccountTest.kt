package oasis.letu.tests.personalDataTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.RegistrationScenario
import oasis.letu.screens.menuScreens.DeleteAccountScreen
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.menuScreens.PersonalDataScreen
import oasis.letu.screens.navigation.BottomNavigation
import org.junit.Test

class DeleteAccountTest :
    DefaultTest("UAE.Mobile.Android.Меню.Профиль.Личные данные. Удаление аккаунта") {
    @Test
    @AllureId("56526")
    @Step("UAE.Mobile.Android.Меню.Профиль.Личные данные. Удаление аккаунта")
    fun authTest_56526() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  UAE телефоном") {
            scenario(RegistrationScenario())
            PersonalDataScreen {
                scrollToEnd()
                clickDeleteButton()
            }
            DeleteAccountScreen {
                checkTitle()
                checkDelete()
                checkCancel()
                checkDelete()
                clickDelete()
            }
            BottomNavigation.openBottomMenu()
            MenuScreen.checkLogRegButton()
        }
    }
}
