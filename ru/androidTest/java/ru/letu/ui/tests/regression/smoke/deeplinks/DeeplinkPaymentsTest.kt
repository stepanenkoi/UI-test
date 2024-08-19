package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_PAYMENTS
import ru.letu.ui.screens.PaymentTypesScreen

class DeeplinkPaymentsTest : DefaultTest(
    "Проверка Deeplinks. Способы оплаты"
) {
    @Test
    @AllureId("63765")
    @Step("Проверка Deeplinks. Способы оплаты")
    fun deeplinkPaymentsTest_63765() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Способы оплаты") {
            featureRouter.open(DEEPLINK_PAYMENTS)
            PaymentTypesScreen.assertPaymentTypesScreenOpen()
        }
    }
}
