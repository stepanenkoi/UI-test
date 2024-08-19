package ru.letu.ui.tests.regression.notrelevant

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.scenarios.GoToLoginScreenScenario
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.SimplifiedAuthorizationScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.LOGIN
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.helpers.utils.testdata.TestConst.USER_NAME

class AuthEmailTest : DefaultTest(
    "Mobile. Android. Auth. Авторизация. Email. Логин по еmail и СМС - позитивный"
) {

    @AllureId("48242")
    @Step("Mobile. Android. Auth. Авторизация. Email. Логин по еmail и СМС - позитивный")
    fun authEmailTest_48242() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Auth. Авторизация. Email. Логин по еmail и СМС - позитивный") {
            scenario(GoToLoginScreenScenario())
            SimplifiedAuthorizationScreen {
                switchToEmailTab()
                enterEmail(LOGIN)
                continueAuthClick()
                enterPhoneCode(SMS)
            }
            MenuScreen.assertUserIsAuthorized(USER_NAME)
        }
    }
}
