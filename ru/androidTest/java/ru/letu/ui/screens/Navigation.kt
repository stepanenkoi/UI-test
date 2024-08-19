package ru.letu.ui.screens

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import io.github.kakaocup.kakao.bottomnav.KBottomNavigationView
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matchers
import ru.letu.R
import ru.letu.ui.helpers.TestUtils.childAtPosition
import ru.letu.ui.helpers.TestUtils.waitAnimation
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.ui.helpers.ViewInfo
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.product.R as RProduct
import ru.letu.ui.R as RCoreUi

object Navigation : Screen<Navigation>() {
    val openMenu = KView { withBackgroundColor("primaryColor") }
    val searchInfo = KView { withId(R.id.search) }
    val searchField = KEditText { withId(R.id.search_input) }
    val closeMenuInfo = KButton { withText("Главная") }
    val notToLeaveAddress = KButton { withId(RProduct.id.negative_btn) }
    val leaveAddressForDelivery = KButton { withId(RProduct.id.positive_btn) }
    val agreeYourCity = KButton { withId(R.id.bt_city_agree) }
    val searchEditTextInfo = ViewInfo("Search edit text", R.id.search_input)
    val catalogButton = KButton { withContentDescription(RCoreResources.string.app_catalog) }
    val favoriteButton = KButton { withContentDescription(RCoreResources.string.app_favorite) }
    val bottomMenu = KBottomNavigationView { withId(R.id.bottom_navigation_view) }
    val menuBtnNonAuth = KButton { withContentDescription(RCoreResources.string.login_action_enter) }
    val menuBtn = KView { withId(R.id.menu) }

    private val badgeTextView = KTextView {
        isDescendantOfA { withContentDescription(RCoreResources.string.app_cart_new) }
        withId(RCoreUi.id.badgeTextView)
    }

    private val defaultCityText: ViewInteraction = onView(
        Matchers.allOf(
            withId(R.id.contentRecycler),
            childAtPosition(
                withId(R.id.layout_content),
                0
            )
        )
    )

    fun openBottomMenu() {
        step("Нажать на Меню") {
            bottomMenu.setSelectedItem(4)
            ToolBarElementScreen.assertTitleToolBar(RCoreResources.string.app_menu)
        }
    }

    fun openBottomMenuIndex() {
        step("Нажать на Меню") {
            bottomMenu.setSelectedItem(4)
            ToolBarElementScreen.assertTitleToolBarIndex(0, RCoreResources.string.app_menu)
        }
    }

    fun openBottomMenuIndex(index: Int) {
        step("Нажать на Меню") {
            bottomMenu.setSelectedItem(4)
            ToolBarElementScreen.assertTitleToolBarIndex(index, RCoreResources.string.app_menu)
        }
    }

    fun openMenu() {
        step("Нажать на Меню") {
            menuBtn.click()
            ToolBarElementScreen.assertTitleToolBar(RCoreResources.string.app_menu)
        }
    }

    fun openBottomCart() {
        step("Нажать на Корзину") {
            bottomMenu.setSelectedItem(2)
            CartScreen.assertCartScreenOpen()
        }
    }

    fun openCatalog() {
        step("Нажать на Каталог") {
            catalogButton.click()
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_catalog)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
        }
    }

    fun openFavorite() {
        step("Нажать на Избранное") {
            favoriteButton.click()
            ToolBarElementScreen.assertTitleToolBar(RCoreResources.string.app_favorite)
        }
    }

    fun changeCityClick() {
        waitForResponses()
        defaultCityText.perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                1,
                click()
            )
        )
    }

    fun hideMenu() {
        openMenu {
            isVisible()
        }

        closeMenuInfo {
            click()
            isDisabled()
        }
    }

    fun enterSearch(textToSearch: String) {
        waitAnimation()
        searchInfo {
            isFocusable()
            click()
        }
        searchField {
            typeText(textToSearch)
            pressImeAction()
        }
        waitForResponses()
    }

    fun findProductBySearch(textToSearch: String) {
        searchInfo {
            click()
        }
        searchField {
            typeText(textToSearch)
            pressImeAction()
        }
        waitForResponses()
    }

    fun dontAgreeToLeaveAddress() {
        notToLeaveAddress {
            isClickable()
            click()
        }
    }

    fun agreeToLeaveAddress() {
        leaveAddressForDelivery {
            isClickable()
            click()
        }
    }

    fun searchSku(textToSearch: String) {
        searchInfo {
            click()
        }
        searchField {
            typeText(textToSearch)
            pressImeAction()
        }
        waitForResponses()
    }

    fun agreeQuestionIsThisYourCity() {
        agreeYourCity {
            isVisible()
            click()
        }
    }

    fun skipOnboarding() {
        OnboardingScreen {
            skip()
        }
    }

    fun menuSearch(): ViewInteraction {
        return onView(withId(R.id.search))
    }

    fun openSearch() {
        searchInfo {
            isVisible()
        }
        menuSearch().perform(click())
    }

    fun searchActionViewEditText(): ViewInteraction {
        return onView(withId(R.id.search_input))
    }

    fun back() {
        pressBackUnconditionally()
        waitForResponses()
    }

    fun assertBadgeCart(goodsInCart: String) {
        step("В корзину добавлено $goodsInCart товар") {
            badgeTextView.hasText(goodsInCart)
        }
    }
}
