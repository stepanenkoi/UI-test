package ru.letu.ui.screens.dialogscreen

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.ui.helpers.utils.getQuantityString
import ru.letu.ui.screens.CartScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.checkout.R as RCheckout
import ru.letu.ui.R as RCoreUi

object DelCartDialogScreen : Screen<DelCartDialogScreen>() {

    private val removeGoodsTitle = KTextView {
        withId(RCoreUi.id.dialog_title)
        withIndex(0) { withText(getQuantityString(RCheckout.plurals.remove_goods, 1)) }
    }.also { it.inRoot { isDialog() } }

    private val removeGoodsDesc = KTextView {
        withId(RCoreUi.id.dialog_message)
        withText(getQuantityString(RCheckout.plurals.remove_goods_description, 1))
    }.also { it.inRoot { isDialog() } }

    private val leftButton = KTextView {
        withId(RCoreUi.id.leftButton)
        withText(RCoreResources.string.checkout_cancel_remove)
    }.also { it.inRoot { isDialog() } }

    private val rightButton = KTextView {
        withId(RCoreUi.id.rightButton)
    }.also { it.inRoot { isDialog() } }

    fun clickRemoveGoods() {
        step("Нажать удалить товар") {
            rightButton.click()
            CartScreen.assertCartIsEmpty()
        }
    }

    fun assertDelCartDialogOpen() {
        step("Диалог удалениея товара открыт") {
            removeGoodsTitle.isDisplayed()
            removeGoodsDesc.isDisplayed()
            leftButton.isDisplayed()
            rightButton.isDisplayed()
        }
    }
}
