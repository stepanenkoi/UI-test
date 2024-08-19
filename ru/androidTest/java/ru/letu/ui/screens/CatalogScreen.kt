package ru.letu.ui.screens

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.base.DefaultTest.Companion.LONG_WAIT_TIME
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object CatalogScreen : Screen<CatalogScreen>() {

    private val catalogPerfumery = KTextView { withText(RCoreResources.string.perfumery) }
    private val catalogCategoryTitle = KTextView { withId(R.id.category_title) }

    fun clickCatalogPerfumery() {
        step("Нажать категорию Парфюмерия") {
            waitForDisplayed(R.id.categoryName, LONG_WAIT_TIME)
            catalogPerfumery.click()
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.perfumery)
                assertBackBtnToolBar()
            }
        }
    }

    fun assertCatalogCategoryOpen(category: String) {
        step("Категория $category открыта") {
            catalogCategoryTitle.hasText(category)
        }
    }
}
