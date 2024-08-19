package ru.letu.ui.tests.regression.smoke.authorization

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.helpers.utils.testdata.TestConst.USER_NAME_PHONE_LOGIN
import ru.letu.ui.scenarios.GoToLoginScreenScenario
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.ProfileScreen
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

class AuthSimplifiedTest : DefaultTest(
    "Mobile. Android.Auth.Авторизация.Телефон. Упрощенная авторизация. (у юзера есть имя и фамилия)"
) {
    @Test
    @AllureId("51958")
    @Step("Mobile. Android.Auth.Авторизация.Телефон. Упрощенная авторизация. (у юзера есть имя и фамилия)")
    fun authSimplifiedTest_51958() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android.Auth.Авторизация.Телефон. Упрощенная авторизация. (у юзера есть имя и фамилия)") {
            scenario(GoToLoginScreenScenario())
            SimplifiedAuthorizationScreen {
                enterPhoneNumber(PHONE)
                continueAuthClick()
                enterPhoneCode(SMS)
            }
            MenuScreen {
                assertUserIsAuthorized(USER_NAME_PHONE_LOGIN)
                openProfileScreen()
            }
            ProfileScreen.assertUserName(USER_NAME_PHONE_LOGIN)
        }
    }
}
