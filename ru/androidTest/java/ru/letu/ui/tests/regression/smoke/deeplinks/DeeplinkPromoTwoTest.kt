package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_PROMO_TWO
import ru.letu.ui.screens.PromotionScreen

class DeeplinkPromoTwoTest : DefaultTest(
    "Проверка Deeplinks. Акция. Подарки по любви. Скидки до 50"
) {
    @Test
    @AllureId("64007")
    @Step("Проверка Deeplinks. Акция. Подарки по любви. Скидки до 50%")
    fun deeplinkPromoTwoTest_64007() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Акция. Подарки по любви. Скидки до 50") {
            featureRouter.open(DEEPLINK_PROMO_TWO)
            PromotionScreen.assertPromotionScreen()
        }
    }
}
