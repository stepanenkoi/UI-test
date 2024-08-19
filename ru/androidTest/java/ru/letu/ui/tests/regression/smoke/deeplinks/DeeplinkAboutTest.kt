package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_ABOUT
import ru.letu.ui.screens.AboutScreen

class DeeplinkAboutTest : DefaultTest(
    "Проверка Deeplinks. О нас"
) {
    @Test
    @AllureId("63787")
    @Step("Проверка Deeplinks. О нас")
    fun deeplinkAboutTest_63787() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. О нас") {
            featureRouter.open(DEEPLINK_ABOUT)
            AboutScreen.assertAboutScreenOpen()
        }
    }
}
