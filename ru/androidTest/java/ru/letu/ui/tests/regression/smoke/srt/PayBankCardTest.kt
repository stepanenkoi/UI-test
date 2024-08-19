package ru.letu.ui.tests.regression.smoke.srt

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.CARD_CVC
import ru.letu.ui.helpers.utils.testdata.TestConst.CARD_PASSWORD
import ru.letu.ui.helpers.utils.testdata.TestConst.PRODUCT_ID
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.helpers.utils.testdata.TestConst.USER_PAY_CARD
import ru.letu.ui.screens.CartScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.OrderStatusSuccessScreen
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.PayCardUiScreen
import ru.letu.ui.screens.PlacingAnOrderScreen
import ru.letu.ui.screens.ReviewGalleryScreen
import ru.letu.ui.screens.bottomsheet.AppReviewQuestionBottomSheetScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

class PayBankCardTest : DefaultTest(
    "Mobile. Android. Оформление заказа.Чекаут.Способы оплаты. Банковская карта",
    loginPhone = USER_PAY_CARD,
    loginSms = SMS
) {
    @Test
    @AllureId("26808")
    @Step("Mobile. Android. Оформление заказа.Чекаут.Способы оплаты. Банковская карта")
    fun payBankCardTest_26808() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Оформление заказа.Чекаут.Способы оплаты. Банковская карта") {
            PDPScreen.openPDP(PRODUCT_ID)
            SpecifyAddressDialogScreen.clickNegativeBtn()
            ReviewGalleryScreen.clickAddToCart()
            flakySafely(LONG_WAIT_TIME) { Navigation.openBottomCart() }
            CartScreen.clickCheckoutBtn()
            PlacingAnOrderScreen {
                flakySafely { scrollToEnd() }
                clickNewCard()
                clickPayBtn()
            }
            Thread.sleep(15000)
            PayCardUiScreen {
                cardCvcBindingSetText(CARD_CVC)
                Thread.sleep(3000)
                clickCardPaymentBtn()
                Thread.sleep(3000)
                cardPasswordSetText(CARD_PASSWORD)
            }
            AppReviewQuestionBottomSheetScreen.closeAppReviewQuestionBottomSheet()
            OrderStatusSuccessScreen.assertOrderStatusSuccess()
        }
    }
}
