package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_MERCHANTS
import ru.letu.ui.screens.MerchantListingScreen

class DeeplinkMerchantsTest : DefaultTest(
    "Проверка Deeplinks. Продавцы"
) {
    @Test
    @AllureId("64000")
    @Step("Проверка Deeplinks. Продавцы")
    fun deeplinkAgreementTest_64000() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Продавцы") {
            featureRouter.open(DEEPLINK_MERCHANTS)
            MerchantListingScreen.assertMerchantScreenOpen()
        }
    }
}
