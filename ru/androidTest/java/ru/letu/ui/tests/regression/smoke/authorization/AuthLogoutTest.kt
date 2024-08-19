package ru.letu.ui.tests.regression.smoke.authorization

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class AuthLogoutTest : DefaultTest(
    "Mobile. Android. Auth. Логаут (упрощённая авторизация)",
    PHONE,
    SMS
) {
    @Test
    @AllureId("35002")
    @Step("Mobile. Android. Auth. Логаут (упрощённая авторизация)")
    fun authLogoutTest_35002() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Auth. Логаут (упрощённая авторизация)") {
            Navigation.openBottomMenuIndex(1)
            MenuScreen.clickLogoutBtn()
            Navigation.openBottomMenuIndex(1)
            MenuScreen.assertUserIsNotAuthorized()
        }
    }
}
