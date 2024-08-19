package ru.letu.ui.tests.regression.smoke.authorization

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils.phoneNumberRu
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE_REG
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.scenarios.GoToLoginScreenScenario
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.ProfileScreen
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

class AuthRegPhoneTest : DefaultTest(
    "Mobile. Android. Auth. Регистрация. Телефон. Регистрация по номеру телефона"
) {
    @Test
    @AllureId("46666")
    @Step("Mobile. Android. Auth. Регистрация. Телефон. Регистрация по номеру телефона")
    fun authRegPhoneTest_46666() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Auth. Регистрация. Телефон. Регистрация по номеру телефона") {
            scenario(GoToLoginScreenScenario())
            SimplifiedAuthorizationScreen {
                enterPhoneNumber(PHONE_REG)
                continueAuthClick()
                enterPhoneCode(SMS)
            }
            MenuScreen {
                assertUserIsAuthorized(phoneNumberRu(PHONE_REG))
                openProfileScreen()
            }
            ProfileScreen.assertUserName(phoneNumberRu(PHONE_REG))
        }
    }
}
