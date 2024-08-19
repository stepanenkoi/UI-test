package ru.letu.ui.screens

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object PaymentTypesScreen : Screen<PaymentTypesScreen>() {

    private val paymentTypeTitle = KTextView {
        withId(R.id.payment_type_cash_title)
        withText(RCoreResources.string.app_checkout_payment_cash)
    }

    private val paymentTypeCash = KTextView {
        withId(R.id.payment_type_cash_text)
        withText(RCoreResources.string.app_payment_type_cash_info)
    }

    private val paymentCashless = KTextView {
        withText(RCoreResources.string.app_checkout_payment_cashless)
    }

    private val paymentTypeCashInfoBegin = KTextView {
        withId(R.id.payment_type_cashless_info_begin)
        withText(RCoreResources.string.app_payment_type_cashless_info_begin)
    }

    val paymentTypeCashInfoEnd = KTextView {
        withId(R.id.payment_type_cashless_info_end)
        withText(RCoreResources.string.app_payment_type_cashless_info_end)
    }

    fun assertPaymentTypesScreenOpen() {
        step("Экран Способы оплаты открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_payment_types)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            paymentTypeTitle.isDisplayed()
            paymentTypeCash.isDisplayed()
            paymentCashless.isDisplayed()
            paymentTypeCashInfoBegin.isDisplayed()
        }
    }
}
