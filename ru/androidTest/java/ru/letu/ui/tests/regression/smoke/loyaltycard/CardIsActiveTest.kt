package ru.letu.ui.tests.regression.smoke.loyaltycard

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.helpers.utils.testdata.TestConst.USER_NAME_PHONE_LOGIN
import ru.letu.ui.screens.ProfileScreen

class CardIsActiveTest : DefaultTest(
    "Mobile. Android. Меню. Профиль. Виджеты. Карта клиента. Отображение активированной карты",
    loginPhone = PHONE,
    loginSms = SMS
) {
    @Test
    @AllureId("44604")
    @Step("Mobile. Android. Меню. Профиль. Виджеты. Карта клиента. Отображение активированной карты")
    fun cardIsActiveTest_44604() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Меню. Профиль. Виджеты. Карта клиента. Отображение активированной карты") {
            ProfileScreen.assertUserName(USER_NAME_PHONE_LOGIN)
            flakySafely { ProfileScreen.assertCardActivated() }
        }
    }
}
