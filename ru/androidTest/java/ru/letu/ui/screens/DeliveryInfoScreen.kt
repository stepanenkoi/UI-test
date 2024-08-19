package ru.letu.ui.screens

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.core_resources.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object DeliveryInfoScreen : Screen<DeliveryInfoScreen>() {

    private val deliveryStoreTitle = KTextView {
        withContentDescription(RCoreResources.string.pdp_delivery_store_title)
    }
    private val deliveryCourierTitle = KTextView {
        withContentDescription(RCoreResources.string.courier_delivery_text)
    }

    fun assertDeliveryInfoScreenOpen() {
        step("Экран Доставка открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(R.string.app_delivery)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            deliveryStoreTitle.isDisplayed()
            deliveryCourierTitle.isDisplayed()
        }
    }
}
