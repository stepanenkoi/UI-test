package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.core_resources.R as RCoreResources

object OrdersScreen : Screen<OrdersScreen>() {

    private val orderOnlineText = KView {
        withIndex(0) { withContentDescription(RCoreResources.string.app_order_history_online_title) }
    }
    private val orderOfflineText = KView {
        withIndex(0) { withContentDescription(RCoreResources.string.app_order_history_offline_title) }
    }

    fun assertOrdersScreenOpen() {
        step("Экран Заказы открыт") {
            orderOnlineText.isDisplayed()
            orderOfflineText.isDisplayed()
        }
    }
}
