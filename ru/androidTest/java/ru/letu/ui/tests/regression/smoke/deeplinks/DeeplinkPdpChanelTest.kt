package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_PDP_CHANEL
import ru.letu.ui.screens.PDPScreen

class DeeplinkPdpChanelTest : DefaultTest(
    "Проверка Deeplinks. PDP Chanel"
) {
    @Test
    @AllureId("63803")
    @Step("Проверка Deeplinks. PDP Chanel")
    fun deeplinkPdpChanelTest_63803() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. PDP Chanel") {
            featureRouter.open(DEEPLINK_PDP_CHANEL)
            flakySafely(WAIT_TIME) {
                PDPScreen.assertPDPChanelOpen()
            }
        }
    }
}
