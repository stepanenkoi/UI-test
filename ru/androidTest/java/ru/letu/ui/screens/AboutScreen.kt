package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object AboutScreen : Screen<AboutScreen>() {
    private val aboutContentRecycle = KView { withId(R.id.about_content_recycler) }

    fun assertAboutScreenOpen() {
        step("Экран О нас открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_about)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            aboutContentRecycle.isDisplayed()
        }
    }
}
