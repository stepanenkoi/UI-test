package ru.letu.ui.screens

import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.feature.checkout.R
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.helpers.utils.testdata.TestConst.PAY_HINT_INSTALLMENT_PLAN
import ru.letu.ui.helpers.utils.testdata.TestConst.PAY_HINT_NEW_CARD
import ru.letu.ui.helpers.utils.testdata.TestConst.PAY_INSTALLMENT_PLAN_TXT
import ru.letu.ui.helpers.utils.testdata.TestConst.PAY_NEW_CARD
import ru.letu.core.endeca.R as REndeca
import ru.letu.core_resources.R as RCoreResources

object PlacingAnOrderScreen : Screen<PlacingAnOrderScreen>() {

    val recyclerView = KRecyclerView(
        builder = {
            isDescendantOfA { withId(R.id.endecaView) }
            withId(REndeca.id.endecaRecycler)
        },
        itemTypeBuilder = {
            itemType(CartScreen::HeaderCartridge)
            itemType(CartScreen::CommerceItemCartridge)
        }
    )

    private val newCard = KTextView { withText(PAY_NEW_CARD) }

    private val payBtnHint = KTextView { withId(R.id.pay_button_hint) }
    private val installmentPlanPay = KTextView { withText(PAY_INSTALLMENT_PLAN_TXT) }

    private val payBtn = KButton {
        withText(RCoreResources.string.checkout_cart_order_pay)
        withId(ru.letu.R.id.button)
    }

    private val payBottomBtn = KButton { withId(R.id.payButton) }
    fun scrollToEnd() {
        step("Проскролить экран до конца") {
            waitForDisplayed(R.id.endecaView, DefaultTest.WAIT_TIME)
            recyclerView.scrollToEnd()
            assertScrollToEnd()
        }
    }

    fun clickNewCard() {
        step("Выбрать способ оплаты Новая карта")
        newCard {
            isDisplayed()
            click()
        }
        assertPayMethod(PAY_HINT_NEW_CARD)
    }

    fun clickInstallmentPlan() {
        step("Выбрать способ оплаты Подели — частями")
        installmentPlanPay {
            isDisplayed()
            click()
        }
        assertPayMethod(PAY_HINT_INSTALLMENT_PLAN)
    }

    fun clickPayBtn() {
        waitForDisplayed(R.id.payButton, DefaultTest.WAIT_TIME)
        payBottomBtn.click()
    }

    private fun assertScrollToEnd() {
        step("Экран проскроллен до конца") {
            payBtn.isDisplayed()
        }
    }

    private fun assertPayMethod(payHint: String) {
        step("Выбран способ оплаты $payHint") {
            payBtnHint.hasText(payHint)
        }
    }
}
