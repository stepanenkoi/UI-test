package ru.letu.ui.screens.elements

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.qameta.allure.kotlin.Allure.step

object ProgressUiScreen : UiScreen<ProgressUiScreen>() {
    override val packageName: String = "ru.letu.preprod"

    val progress = UiView {
        withId(this@ProgressUiScreen.packageName, "progress")
        withClassName("android.widget.ImageView")
    }

    private val globalProgressBar = UiView {
        withId(this@ProgressUiScreen.packageName, "global_progress_bar")
        withClassName("android.widget.ImageView")
    }

    fun assertProgressDisplayed() {
        step("Отображается прогресс загрузки") {
            globalProgressBar.isDisplayed()
        }
    }
}
