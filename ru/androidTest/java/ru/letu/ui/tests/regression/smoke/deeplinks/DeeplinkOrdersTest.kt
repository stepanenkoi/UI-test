package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_ORDERS
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.OrdersScreen

class DeeplinkOrdersTest : DefaultTest(
    "Проверка Deeplinks. Заказы",
    loginPhone = PHONE,
    loginSms = SMS
) {
    @Test
    @AllureId("63800")
    @Step("Проверка Deeplinks. Заказы")
    fun deeplinkOrdersTest_63800() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Заказы") {
            featureRouter.open(DEEPLINK_ORDERS)
            OrdersScreen.assertOrdersScreenOpen()
        }
    }
}
