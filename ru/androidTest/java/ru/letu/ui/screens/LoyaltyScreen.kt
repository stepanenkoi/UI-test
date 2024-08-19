package ru.letu.ui.screens

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object LoyaltyScreen : Screen<LoyaltyScreen>() {

    private val promoCodesTitle = KTextView {
        withIndex(1) {
            withText(RCoreResources.string.app_promo_codes_title)
        }
    }

    fun assertLoyaltyScreenOpen() {
        step("Экран Купоны открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_promo_codes_toolbar)
                assertBackBtnToolBar()
            }
            promoCodesTitle.isDisplayed()
        }
    }
}
