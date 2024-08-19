package ru.letu.ui.screens

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.core_resources.R as RCoreResources

object PerfumeryCategoryScreen : Screen<PerfumeryCategoryScreen>() {
    private val goToSectionText = KTextView { withText(RCoreResources.string.app_first_catalog_item_label) }
    private val womenPerfumesText = KTextView { withText(RCoreResources.string.women_perfumes_text) }
    private val menPerfumesText = KTextView { withText(RCoreResources.string.men_perfumes_text) }

    fun assertPerfumeryCategoryScreenOpen() {
        step("Категория Парфюмерия открыта") {
            goToSectionText.isDisplayed()
            womenPerfumesText.isDisplayed()
            menPerfumesText.isDisplayed()
        }
    }
}
