package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_HELP
import ru.letu.ui.screens.HelpScreen

class DeeplinkHelpTest : DefaultTest(
    "Проверка Deeplinks. Помощь"
) {
    @Test
    @AllureId("63749")
    @Step("Проверка Deeplinks. Помощь")
    fun deeplinkHelpTest_63749() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Помощь") {
            featureRouter.open(DEEPLINK_HELP)
            HelpScreen.assertHelpScreenOpen()
        }
    }
}
