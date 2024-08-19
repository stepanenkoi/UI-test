package ru.letu.ui.screens.elements

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R

object ProgressScreen : Screen<ProgressScreen>() {

    private val globalProgressBar = KView {
       withId(R.id.global_progress_bar)
    }

    private val globalProgress = KView {
        withId(R.id.progress)
    }

    private val globalLoading = KView {
        withId(R.id.global_loading)
    }

    fun assertProgressBarDisplayed() {
        step("Отображается прогресс загрузки") {
            globalProgressBar.isDisplayed()
        }
    }

    fun assertProgressDisplayed() {
        step("Отображается прогресс загрузки") {
            globalProgress.isDisplayed()
        }
    }

    fun assertLoadingDisplayed() {
        step("Отображается прогресс загрузки") {
            globalLoading.isDisplayed()
        }
    }
}
