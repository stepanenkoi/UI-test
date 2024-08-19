package ru.letu.ui.tests.regression.smoke.cart

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.PRODUCT_ID
import ru.letu.ui.screens.CartScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.ReviewGalleryScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

class CartRemovingGoodsClickMinusTest : DefaultTest(
    "Корзина.Удаление товара нажатием на минус"
) {
    @Test
    @AllureId("63666")
    @Step("Корзина.Удаление товара нажатием на минус")
    fun removingGoodsClickMinusTest_63666() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Корзина.Удаление товара нажатием на минус") {
            PDPScreen.openPDP(PRODUCT_ID)
            flakySafely { SpecifyAddressDialogScreen.clickNegativeBtn() }
            flakySafely { ReviewGalleryScreen.clickAddToCart() }
            Navigation.openBottomCart()
            flakySafely { CartScreen.clickMinusBtn() }
        }
    }
}
