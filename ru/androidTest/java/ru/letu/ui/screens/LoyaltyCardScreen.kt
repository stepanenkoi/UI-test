package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.scroll.KScrollView
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.R
import ru.letu.feature.loyalty.routes.LoyaltyRoute
import ru.letu.ui.base.DefaultTest.Companion.WAIT_TIME
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertTitleToolBarIndex
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.loyalty.R as RLoyalty

object LoyaltyCardScreen : Screen<LoyaltyCardScreen>() {
    private val loyaltyCardRecyclerView = KRecyclerView(
        { withId(R.id.contentRecycler) },
        {
            itemType(::LoyaltyCardItem)
        }
    )

    class LoyaltyCardItem(parent: Matcher<View>) : KRecyclerItem<LoyaltyCardItem>(parent) {
        val loyaltyCardHistoryBonusesAccruals = KTextView(parent) {
            withId(RLoyalty.id.tv_bonuses_polar_in)
        }

        val loyaltyCardHistoryBonusesWriteOffs = KTextView(parent) {
            withId(RLoyalty.id.tv_bonuses_polar_out)
        }
    }

    private val loyaltyCardHistoryScrollView = KScrollView { withId(RLoyalty.id.tl_history) }

    private val loyaltyCardHistoryAllTab = KTextView {
        isDescendantOfA { withContentDescription(RCoreResources.string.app_ndk_history_all) }
        withText(RCoreResources.string.app_ndk_history_all)
    }

    val loyaltyCardHistoryWriteOffs = KTextView {
       withContentDescription(RCoreResources.string.app_ndk_history_writeoffs)
    }

    private val loyaltyCardHistoryAccrualsTab = KTextView {
        isDescendantOfA { withContentDescription(RCoreResources.string.app_ndk_history_accruals) }
        withText(RCoreResources.string.app_ndk_history_accruals)
    }

    private val loyaltyCardHistoryWriteOffsTab = KTextView {
        withIndex(0) { withContentDescription(RCoreResources.string.app_ndk_history_writeoffs) }
    }

    private val loyaltyCardHistoryBonusesAccruals = KTextView {
        withIndex(0) {
            withId(RLoyalty.id.tv_order)
            withText(RCoreResources.string.app_ndk_incoming)
        }
    }

    private val loyaltyCardHistoryBonusesWriteOffs = KTextView {
        withIndex(0) {
            withId(RLoyalty.id.iv_bonuses_out)
            withContentDescription(RCoreResources.string.core_ui_content_description)
        }
    }

    fun loyaltyCardScreenScrollToEnd() {
        step("Проскролить экран карты до конца") {
            waitForDisplayed(RLoyalty.id.iv_card, WAIT_TIME)
            loyaltyCardRecyclerView.scrollToEnd()
            assertLoyaltyCardHistoryIsDisplayed()
        }
    }

    fun openLoyaltyCard() {
        step("Открыть экран Карта клиента") {
            featureRouter forward LoyaltyRoute.LOYALTY_CARD
            assertTitleToolBarIndex(0, RCoreResources.string.app_client_card)
        }
    }

    fun clickHistoryAllTab() {
        step("Нажать на таб Все операции") {
            loyaltyCardHistoryAllTab.click()
            assertHistoryAllTab()
        }
    }

    fun clickHistoryAccrualsTab() {
        step("Нажать на таб Зачисления") {
            loyaltyCardHistoryAccrualsTab.click()
            assertHistoryAccrualsTab()
        }
    }

    fun clickHistoryWriteOffsTab() {
        step("Нажать на таб Списания") {
            loyaltyCardHistoryWriteOffsTab.click()
            assertHistoryWriteOffsTab()
        }
    }

    private fun assertHistoryAllTab() {
        step("Проверка Во Всех операциях -- и списание, и зачисление") {
            loyaltyCardHistoryAllTab.isSelected()
            loyaltyCardHistoryBonusesAccruals.isDisplayed()
            loyaltyCardHistoryBonusesWriteOffs.isDisplayed()
        }
    }

    private fun assertHistoryAccrualsTab() {
        step("Проверка В табу зачислений НЕ попадают списания") {
            Thread.sleep(2000)
            loyaltyCardHistoryAccrualsTab.isSelected()
            loyaltyCardRecyclerView.lastChild<LoyaltyCardItem> {
                loyaltyCardHistoryBonusesAccruals.isDisplayed()
            }
            loyaltyCardHistoryBonusesWriteOffs.isNotDisplayed()
        }
    }

    private fun assertHistoryWriteOffsTab() {
        step("Проверка В табу списаний НЕ попадают зачисления") {
            loyaltyCardHistoryWriteOffsTab.isSelected()
            loyaltyCardRecyclerView.lastChild<LoyaltyCardItem> {
                loyaltyCardHistoryBonusesWriteOffs.isDisplayed()
            }
            loyaltyCardHistoryBonusesAccruals.doesNotExist()
        }
    }

    private fun assertLoyaltyCardHistoryIsDisplayed() {
        step("Проверка истории бонусов отображается") {
            loyaltyCardHistoryScrollView.isDisplayed()
        }
    }
}
