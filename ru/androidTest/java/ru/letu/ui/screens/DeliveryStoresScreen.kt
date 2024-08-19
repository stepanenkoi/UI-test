package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import ru.letu.core_resources.R as RCoreResources

object DeliveryStoresScreen : Screen<DeliveryStoresScreen>() {
    val deliveryStoresMapButton = KButton { withContentDescription("НА КАРТЕ") }
    val deliveryStoresListButton = KButton { withContentDescription("СПИСОК") }
    val deliveryStoresTitle = KView { withText(RCoreResources.string.app_delivery_stores_availability_title) }
}
