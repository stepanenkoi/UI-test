package ru.letu.ui.tests.regression.smoke.srt

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.PRODUCT_ID
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.helpers.utils.testdata.TestConst.USER_PAY_CARD
import ru.letu.ui.screens.CartScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.ReviewGalleryScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

class CartScreenTest : DefaultTest(
    "Mobile. Android. Оформление заказа. Корзина. Общий вид экрана",
    loginPhone = USER_PAY_CARD,
    loginSms = SMS
) {
    @Test
    @AllureId("53303")
    @Step("Mobile. Android. Оформление заказа. Корзина. Общий вид экран")
    fun cartScreenTest_53303() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Оформление заказа. Корзина. Общий вид экран") {
            PDPScreen.openPDP(PRODUCT_ID)
            SpecifyAddressDialogScreen.clickNegativeBtn()
            ReviewGalleryScreen.clickAddToCart()
            Navigation.openBottomCart()
            CartScreen {
                assertCartScreen()
                assertProductItem(0)
            }
        }
    }
}
