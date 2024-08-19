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

class CartRemovingGoodsPictogramWithTrashTest : DefaultTest(
    "Корзина.Удаление товара нажимаем пиктограмму с мусорной корзиной в карточке товара"
) {
    @Test
    @AllureId("63587")
    @Step("Корзина.Удаление товара нажимаем пиктограмму с мусорной корзиной в карточке товара")
    fun removingGoodsPictogramWithTrashTest_63587() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Корзина.Удаление товара нажимаем пиктограмму с мусорной корзиной в карточке товара") {
            PDPScreen.openPDP(PRODUCT_ID)
            flakySafely { SpecifyAddressDialogScreen.clickNegativeBtn() }
            flakySafely { ReviewGalleryScreen.clickAddToCart() }
            Navigation.openBottomCart()
            flakySafely { CartScreen.clickTrashBtn() }
            DelCartDialogScreen.clickRemoveGoods()
        }
    }
}
