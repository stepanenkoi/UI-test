package ru.letu.ui.screens

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object ReturnScreen : Screen<ReturnScreen>() {

    private val returnHeader = KTextView { withText(RCoreResources.string.app_refund_header_first) }
    private val returnText = KTextView { withText(RCoreResources.string.app_refund_text_first) }
    private val returnHeaderSecond = KTextView { withText(RCoreResources.string.app_refund_header_second) }
    private val returnLink = KTextView { withId(R.id.refund_link) }

    fun assertReturnScreenOpen() {
        step("Экран Пользовательское соглашение открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_help_refund)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            returnHeader.isDisplayed()
            returnText.isDisplayed()
            returnHeaderSecond.isDisplayed()
            returnLink.isDisplayed()
        }
    }
}
