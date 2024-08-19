package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_STORES
import ru.letu.ui.screens.StoresScreen

class DeeplinkStoresTest : DefaultTest(
    "Проверка Deeplinks. Список магазинов"
) {
    @Test
    @AllureId("63878")
    @Step("Проверка Deeplinks. Список магазинов")
    fun deeplinkStoresTest_63878() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Список магазинов") {
            featureRouter.open(DEEPLINK_STORES)
            StoresScreen.assertStoresScreenOpen()
        }
    }
}
