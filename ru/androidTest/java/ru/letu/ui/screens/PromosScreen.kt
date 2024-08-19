package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.loyalty.R as RLoyalty

object PromosScreen : Screen<PromosScreen>() {
    private val tagListPromos = KView { withId(R.id.tag_list) }

    private val imageCard = KView {
       withIndex(0) {
           withId(RLoyalty.id.image_card)
       }
    }

    private val promoName = KTextView {
        withIndex(1) {
            withId(RLoyalty.id.promo_name)
        }
    }

    fun clickPromos() {
        step("Нажать на карточку Акции") {
            promoName.click()
            ToolBarElementScreen.assertTitleToolBar(RCoreResources.string.promotion)
            ToolBarElementScreen.assertBackBtnToolBar()
        }
    }

    fun assertPromosScreenOpen() {
        step("Экран Промоакции открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_promos_toolbar_title)
                assertBackBtnToolBar()
                assertSearchBtnToolBar()
            }
            tagListPromos.isDisplayed()
            imageCard.isDisplayed()
            promoName.isDisplayed()
        }
    }
}
