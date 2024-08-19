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
import ru.letu.ui.screens.dialogscreen.DelCartDialogScreen

class CartRemovingGoodsClickDelAllTest : DefaultTest(
    "Корзина.Товары в наличии.Удаление товара нажимаем Удалить выбранные"
) {
    @Test
    @AllureId("63667")
    @Step("Корзина.Товары в наличии.Удаление товара нажимаем Удалить выбранные")
    fun removingGoodsClickDelAllTest_63667() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Корзина.Товары в наличии.Удаление товара нажимаем Удалить выбранные") {
            PDPScreen.openPDP(PRODUCT_ID)
            flakySafely { SpecifyAddressDialogScreen.clickNegativeBtn() }
            flakySafely { ReviewGalleryScreen.clickAddToCart() }
            Navigation.openBottomCart()
            flakySafely { CartScreen.clickRemoveSelected() }
            DelCartDialogScreen.clickRemoveGoods()
        }
    }
}
