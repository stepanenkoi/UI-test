package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_RETURN
import ru.letu.ui.screens.ReturnScreen

class DeeplinkReturnTest : DefaultTest(
    "Проверка Deeplinks. Условия возврата"
) {
    @Test
    @AllureId("63877")
    @Step("Проверка Deeplinks. Условия возврата")
    fun deeplinkReturnTest_63877() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Условия возврата") {
            featureRouter.open(DEEPLINK_RETURN)
            ReturnScreen.assertReturnScreenOpen()
        }
    }
}
