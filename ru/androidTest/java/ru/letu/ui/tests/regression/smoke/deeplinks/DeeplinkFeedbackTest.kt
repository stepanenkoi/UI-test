package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_FEEDBACK
import ru.letu.ui.screens.MessageScreen

class DeeplinkFeedbackTest : DefaultTest(
    "Проверка Deeplinks. Статьи"
) {
    @Test
    @AllureId("63942")
    @Step("Проверка Deeplinks. Статьи")
    fun deeplinkFeedbackTest_63942() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Статьи") {
            featureRouter.open(DEEPLINK_FEEDBACK)
            MessageScreen.assertMessageScreenOpen()
        }
    }
}
