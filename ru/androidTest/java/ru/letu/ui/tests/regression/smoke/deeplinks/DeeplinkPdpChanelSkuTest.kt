package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_PDP_CHANEL_SKU
import ru.letu.ui.screens.PDPScreen

class DeeplinkPdpChanelSkuTest : DefaultTest(
    "Проверка Deeplinks. PDP Chanel SKU"
) {
    @Test
    @AllureId("63805")
    @Step("Проверка Deeplinks. PDP Chanel SKU")
    fun deeplinkPdpChanelSkuTest_63805() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. PDP Chanel SKU") {
            featureRouter.open(DEEPLINK_PDP_CHANEL_SKU)
            flakySafely { PDPScreen.assertPDPChanelOpen() }
        }
    }
}
