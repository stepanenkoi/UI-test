package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_PROMO
import ru.letu.ui.screens.PromotionScreen

class DeeplinkPromoTest : DefaultTest(
    "Проверка Deeplinks. Акция"
) {
    @Test
    @AllureId("63949")
    @Step("Проверка Deeplinks. Акция")
    fun deeplinkPromoTest_63949() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Акция") {
            featureRouter.open(DEEPLINK_PROMO)
            PromotionScreen.assertPromotionScreen()
        }
    }
}
