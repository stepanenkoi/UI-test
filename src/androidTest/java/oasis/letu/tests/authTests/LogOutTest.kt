package oasis.letu.tests.authTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.LoginScenario
import oasis.letu.screens.menuScreens.MenuScreen
import org.junit.Test

// #35002 Mobile. Android. Auth. Логаут (упрощённая авторизация)

class LogOutTest :
    DefaultTest("Android. Auth. Логаут (упрощённая авторизация)") {
    @Test
    @AllureId("35002")
    @Step("Android. Auth. Логаут (упрощённая авторизация)")
    fun authTest_35002() {
        test()
    }
    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  UAE телефоном") {
            scenario(LoginScenario())
            MenuScreen {
                clickLogOut()
                checkLogRegButton()
            }
        }
    }
}
