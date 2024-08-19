package ru.letu.ui.screens

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.screens.elements.ToolBarElementScreen.toolBarWithTitle
import ru.letu.ui.screens.HomeScreen.assertHomeScreenOpen
import ru.letu.core_resources.R as RCoreResources

object DelYourAccountHasBeenDeletedScreen : Screen<DelYourAccountHasBeenDeletedScreen>() {

    private val yourAccountHasBeenDelMessage = KTextView { withText(RCoreResources.string.app_profile_deleted) }
    private val yourAccountHasBeenDelBtn = KButton {
        withId(R.id.btn_delete_account)
        withText(RCoreResources.string.app_return_homepage)
    }

    fun clickYourAccountHasBeenDelBtn() {
        step("Экран Акккаунт удален открыт") {
            yourAccountHasBeenDelBtn.click()
            assertHomeScreenOpen()
        }
    }

    fun assertDelYourAccountHasBeenDeletedScreenOpen() {
        step("Экран Акккаунт удален открыт") {
            toolBarWithTitle.isDisplayed()
            yourAccountHasBeenDelMessage.isDisplayed()
            yourAccountHasBeenDelBtn.isDisplayed()
        }
    }
}
