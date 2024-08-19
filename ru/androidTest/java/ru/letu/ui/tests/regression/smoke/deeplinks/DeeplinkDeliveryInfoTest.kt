package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_DELIVERY_INFO
import ru.letu.ui.screens.DeliveryInfoScreen

class DeeplinkDeliveryInfoTest : DefaultTest(
    "Проверка Deeplinks. Условия доставки"
) {
    @Test
    @AllureId("63748")
    @Step("Проверка Deeplinks. Условия доставки")
    fun deeplinkDeliveryInfoTest_63748() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Условия доставки") {
            featureRouter.open(DEEPLINK_DELIVERY_INFO)
            DeliveryInfoScreen.assertDeliveryInfoScreenOpen()
        }
    }
}
