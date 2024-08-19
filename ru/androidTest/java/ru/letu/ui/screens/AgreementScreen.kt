package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.screens.elements.ToolBarElementScreen

object AgreementScreen : Screen<AgreementScreen>() {
    private val aboutContentRecycle = KView { withId(R.id.about_content_recycler) }

    fun assertAgreementScreenOpen() {
        step("Экран Пользовательское соглашение открыт") {
            ToolBarElementScreen {
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
                assertLogoToolBar()
            }
            aboutContentRecycle.isDisplayed()
        }
    }
}
