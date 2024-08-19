package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_PROMOS
import ru.letu.ui.screens.PromosScreen

class DeeplinkPromosTest : DefaultTest(
    "Проверка Deeplinks. Все акции"
) {
    @Test
    @AllureId("63944")
    @Step("Проверка Deeplinks. Все акции")
    fun deeplinkPromosTest_63944() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Все акции") {
            featureRouter.open(DEEPLINK_PROMOS)
            PromosScreen.assertPromosScreenOpen()
        }
    }
}
