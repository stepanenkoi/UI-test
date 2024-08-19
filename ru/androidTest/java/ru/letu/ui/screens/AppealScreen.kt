package ru.letu.ui.screens

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.core_resources.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.appeals.R as RAppeals

object AppealScreen : Screen<AppealScreen>() {

    private val appealText = KTextView {
        withId(RAppeals.id.title_chat)
        withText(RCoreResources.string.app_chat_title)
    }

    fun assertAppealScreenOpen() {
        step("Экран Обращения открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(R.string.app_appeal)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            appealText.isDisplayed()
        }
    }
}
