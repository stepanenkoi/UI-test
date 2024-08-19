package ru.letu.ui.tests.regression.smoke.loyaltycard

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.LoyaltyCardScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS

class CardBonusHistoryTest : DefaultTest(
    "Mobile. Android. Карта клиента. История бонусов",
    loginPhone = PHONE,
    loginSms = SMS
) {
    @Test
    @AllureId("23786")
    @Step("Mobile. Android. Карта клиента. История бонусов")
    fun cardBonusHistoryTest_23786() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Карта клиента. История бонусов") {
            LoyaltyCardScreen {
                openLoyaltyCard()
                loyaltyCardScreenScrollToEnd()
                clickHistoryAllTab()
                clickHistoryAccrualsTab()
                clickHistoryWriteOffsTab()
            }
        }
    }
}
