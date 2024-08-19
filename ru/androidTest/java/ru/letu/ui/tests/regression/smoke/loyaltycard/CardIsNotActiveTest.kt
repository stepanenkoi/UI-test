package ru.letu.ui.tests.regression.smoke.loyaltycard

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE_REG
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.ProfileScreen

class CardIsNotActiveTest : DefaultTest(
    "Mobile. Android. Меню. Профиль. Виджеты. Карта клиента. Отображение неактивированной карты",
    loginPhone = PHONE_REG,
    loginSms = SMS
) {
    @Test
    @AllureId("44605")
    @Step("Mobile. Android. Меню. Профиль. Виджеты. Карта клиента. Отображение неактивированной карты")
    fun cardIsNotActiveTest_44605() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Меню. Профиль. Виджеты. Карта клиента. Отображение неактивированной карты") {
            ProfileScreen {
                assertUserName(TestUtils.phoneNumberRu(PHONE_REG))
                assertCardNotActivated()
            }
        }
    }
}
