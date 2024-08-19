package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_BRANDS
import ru.letu.ui.screens.BrandScreen

class DeeplinkBrandsTest : DefaultTest(
    "Проверка Deeplinks. Бренды"
) {
    @Test
    @AllureId("63943")
    @Step("Проверка Deeplinks. Бренды")
    fun deeplinkBrandsTest_63943() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Бренды") {
            featureRouter.open(DEEPLINK_BRANDS)
            BrandScreen.assertBrandListOpen()
        }
    }
}
