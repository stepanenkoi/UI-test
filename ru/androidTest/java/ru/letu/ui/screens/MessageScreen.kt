package ru.letu.ui.screens

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.appeals.R as RAppeals

object MessageScreen : Screen<MessageScreen>() {

    private val messageTitle = KTextView { withText(RCoreResources.string.app_create_message_title) }
    private val messageInf = KTextView { withText(RCoreResources.string.app_message_information_short) }
    private val messageAdd = KTextView {
        withIndex(0) {
        withText(RCoreResources.string.app_message_add_new)
        }
    }
    private val messageEmail = KTextView { withText(RCoreResources.string.app_message_email) }
    private val messageInsert = KEditText { withId(RAppeals.id.insert_email) }
    private val messageBtn = KButton {
        withId(RAppeals.id.btn_next)
        withText(RCoreResources.string.app_message_button_next)
    }

    fun assertMessageScreenOpen() {
        step("Экран Создать обращение открыт") {
            ToolBarElementScreen {
                assertLogoToolBar()
                assertSearchBtnToolBar()
            }
            messageTitle.isDisplayed()
            messageInf.isDisplayed()
            messageAdd.isDisplayed()
            messageEmail.isDisplayed()
            messageInsert.isDisplayed()
            messageBtn.isDisplayed()
        }
    }
}
