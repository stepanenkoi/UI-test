package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object AboutSalesScreen : Screen<AboutSalesScreen>() {
    private val aboutSalesRecycle = KView { withId(R.id.recycler) }

    fun assertAboutScreenOpen() {
        step("Экран Условия продажи открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.login_dsc__register_agreement_sales)
                assertSearchBtnToolBar()
            }
            aboutSalesRecycle.isDisplayed()
        }
    }
}
