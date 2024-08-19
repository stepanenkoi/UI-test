package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.base.DefaultTest.Companion.LONG_WAIT_TIME
import ru.letu.ui.base.DefaultTest.Companion.WAIT_TIME
import ru.letu.ui.helpers.TestUtils.sendToBackgroundAppForWhile
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertBackBtnToolBar
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertSearchBtnToolBar
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertTitleToolBar
import ru.letu.core.endeca.R as REndeca
import ru.letu.core_resources.R as RCoreResources

object MenuScreen : Screen<MenuScreen>() {
    val profileContent = KTextView { withId(R.id.profileContent) }
    val userNameText = KTextView { withId(R.id.userName) }
    private val loginOrRegisterButton = KButton { withId(R.id.menuButton) }
    private val logoutBtn = KTextView {
        withId(R.id.txtItemMenu)
        withText(RCoreResources.string.app_quiz_exit_button)
    }
    private val appPromoBtn = KTextView { withText(RCoreResources.string.app_promo) }

    val mainPageButton = KButton { withId(R.id.menuItemContent) }

    private val menuRecyclerView = KRecyclerView(
        builder = { withId(REndeca.id.endecaRecycler) },
        itemTypeBuilder = {
            itemType(::MenuItem)
        }
    )

    val imgItemMenu = KImageView { withIndex(0) { withId(R.id.imgItemMenu) } }
    val txtItemMenu = KTextView { withIndex(0) { withId(R.id.txtItemMenu) } }
    val icArrow = KImageView { withIndex(0) { withId(R.id.icArrow) } }

    class MenuItem(parent: Matcher<View>) : KRecyclerItem<MenuItem>(parent) {
        val imgItemMenu = KImageView(parent) { withId(R.id.imgItemMenu) }
        val txtItemMenu = KTextView(parent) { withId(R.id.txtItemMenu) }
        val icArrow = KImageView(parent) { withId(R.id.icArrow) }
    }

    fun clickPromoBtn() {
        step("Нажать на Акции") {
            appPromoBtn.click()
            assertTitleToolBar(RCoreResources.string.app_promos_toolbar_title)
            assertSearchBtnToolBar()
            assertBackBtnToolBar()
        }
    }

    fun openAuthorizationScreen() {
        step("Нажать на кнопку Войти или зарегистрироваться") {
            waitForDisplayed(R.id.menuButton, WAIT_TIME)
            loginOrRegisterButton.click()
            SimplifiedAuthorizationScreen.assertLoginScreenOpen()
        }
    }

    fun openProfileScreen() {
        step("Нажать на имя профиля") {
            userNameText.click()
            ToolBarElementScreen.assertTitleToolBarIndex(0, RCoreResources.string.app_profile)
        }
    }

    fun openCitySelectionScreen() {
        step("Перейти на экран выбора города") {
            imgItemMenu.isDisplayed()
            txtItemMenu.isDisplayed()
            icArrow.isDisplayed()
            txtItemMenu.click()
            ChooseRegionScreen.assertCitySelectionScreenOpen()
        }
    }

    fun sendToBackground(time: Int, city: String) {
        step("Свернуть/Развернуть приложение") {
            sendToBackgroundAppForWhile(time)
            assertCitySelection(city)
        }
    }

    fun clickLogoutBtn() {
        step("Нажать на Выход на экране Меню") {
            logoutBtn.click()
            HomeScreen.assertHomeScreenOpen()
        }
    }

    fun openProfile() {
        profileContent {
            isVisible()
            click()
        }
    }

    fun openMainPage() {
        mainPageButton {
            isVisible()
            click()
        }
    }

    fun openCart() {
        menuRecyclerView.childAt<MenuItem>(4) {
            click()
        }
    }

    fun assertUserIsAuthorized(userName: String) {
        step("Пользователь с именем $userName авторизован") {
            waitForDisplayed(R.id.userName, WAIT_TIME)
            userNameText.isDisplayed()
            userNameText.hasText(userName)
        }
    }

    fun assertUserIsNotAuthorized() {
        step("Пользователь не авторизован") {
            waitForDisplayed(R.id.menuButton, LONG_WAIT_TIME)
            loginOrRegisterButton.isDisplayed()
            userNameText.doesNotExist()
        }
    }

    fun assertCitySelection(cityName: String) {
        step("Выбран город $cityName") {
            menuRecyclerView.firstChild<MenuItem> {
                txtItemMenu.hasText(cityName)
            }
        }
    }
}
