package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_SALES
import ru.letu.ui.screens.AboutSalesScreen

class DeeplinkSalesTest : DefaultTest(
    "Проверка Deeplinks. Условия продажи"
) {
    @Test
    @AllureId("63815")
    @Step("Проверка Deeplinks. Условия продажи")
    fun deeplinkSalesTest_63815() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Условия продажи") {
            featureRouter.open(DEEPLINK_SALES)
            AboutSalesScreen.assertAboutScreenOpen()
        }
    }
}
