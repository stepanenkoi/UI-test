package ru.letu.ui.screens.elements

import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.toolbar.KToolbar
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.helpers.TestUtils.getString
import ru.letu.ui.screens.SuggestionScreen.assertSuggestionScreenOpen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.ui.R as RUi

object ToolBarElementScreen : Screen<ToolBarElementScreen>() {

    val toolBarWithTitle = KToolbar { withId(R.id.toolbar_with_title) }
    val toolBar = KToolbar { withId(R.id.toolbar_main) }
    private val searchButton = KButton {
        withId(R.id.search)
        withContentDescription(RCoreResources.string.app_search)
    }

    val favoriteButton = KButton {
        withId(R.id.favorite)
        withContentDescription(RCoreResources.string.app_pdp_add_to_favorite)
    }

    val shareButton = KButton {
        withId(R.id.share)
        withContentDescription(RCoreResources.string.app_share_data)
    }

    val toolbarLogo = KImageView { withId(R.id.toolbar_logo) }

    fun clickSearchBtn() {
        step("Нажать на кнопку поиска в тулбаре") {
            searchButton.click()
            assertSuggestionScreenOpen()
        }
    }

    fun assertTitleToolBar(title: Int) {
        step("Проверить текст ${getString(title)} в тулбаре") {
            toolBar.hasDescendant { withText(title) }
        }
    }

    fun assertTitleToolBarIndex(index: Int, title: Int) {
        step("Проверить текст ${getString(title)} в тулбаре") {
            val toolBarIndex = KToolbar {
                withIndex(index) { withId(R.id.toolbar_main) }
            }
            toolBarIndex.hasDescendant { withText(title) }
        }
    }

    fun assertToolBarWithTitle(title: Int) {
        step("Проверить текст ${getString(title)} в тулбаре") {
            toolBarWithTitle.hasDescendant { withText(title) }
        }
    }

    fun assertSearchBtnToolBar() {
        step("Проверить кнопку поиска в тулбаре") {
            searchButton.isDisplayed()
        }
    }

    fun assertSearchBtnToolBarIndex(index: Int) {
        step("Проверить кнопку поиска в тулбаре") {
            KButton {
                withIndex(index) {
                    withId(R.id.search)
                    withContentDescription(RCoreResources.string.app_search)
                }
            }.isDisplayed()
        }
    }

    fun assertBackBtnToolBar() {
        step("Проверить кнопку Назад в тулбаре") {
            toolBar.hasDescendant { withDrawable(RUi.drawable.ic_black_arrow_back) }
        }
    }

    fun assertBackWhiteBtnToolBar() {
        step("Проверить кнопку Назад в тулбаре") {
            toolBar.hasDescendant { withDrawable(RUi.drawable.ic_dk_navigation_arrow_back_white) }
        }
    }

    fun assertFavoriteBtnToolBar() {
        step("Проверить кнопку Назад в тулбаре") {
            toolBar.hasDescendant { withId(R.id.favorite) }
        }
    }

    fun assertShareBtnToolBar() {
        step("Проверить кнопку Назад в тулбаре") {
            toolBar.hasDescendant { withId(R.id.share) }
        }
    }

    fun assertLogoToolBar() {
        step("Проверить Логотип Летуаль в тулбаре") {
            toolbarLogo.isDisplayed()
        }
    }
}
