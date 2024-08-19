package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.core_resources.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.feature.loyalty.R as RLoyalty

object ClientCardScreen : Screen<ClientCardScreen>() {
    private val clientCard = KView { withId(RLoyalty.id.card_main) }

    fun assertClientCardScreenOpen() {
        step("Экран Карта клиента открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(R.string.app_client_card)
                assertBackBtnToolBar()
            }
            clientCard.isDisplayed()
        }
    }
}
