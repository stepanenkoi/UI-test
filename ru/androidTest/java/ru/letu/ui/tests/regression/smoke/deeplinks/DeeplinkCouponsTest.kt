package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_COUPONS
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.LoyaltyScreen

class DeeplinkCouponsTest : DefaultTest(
    "Проверка Deeplinks. Купоны",
    loginPhone = PHONE,
    loginSms = SMS
) {
    @Test
    @AllureId("63986")
    @Step("Проверка Deeplinks. Купоны")
    fun deeplinkBrandsTest_63986() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Купоны") {
            featureRouter.open(DEEPLINK_COUPONS)
            LoyaltyScreen.assertLoyaltyScreenOpen()
        }
    }
}
