package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object StoresScreen : Screen<StoresScreen>() {

    private val storesOnMap = KView {
        withContentDescription(RCoreResources.string.checkout_optimal_pickup_map_tab_txt)
    }
    private val storesList = KView {
        withContentDescription(RCoreResources.string.checkout_optimal_pickup_list_tab_txt)
    }

    fun assertStoresScreenOpen() {
        step("Экран Списка магазинов открыт") {
            ToolBarElementScreen.assertBackBtnToolBar()
            storesOnMap.isDisplayed()
            storesList.isDisplayed()
        }
    }
}
