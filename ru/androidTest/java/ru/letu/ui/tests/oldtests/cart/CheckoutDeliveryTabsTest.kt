package ru.letu.ui.tests.oldtests.cart

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.feature.checkout.R
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.TestUtils.waitAnimation
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.clickOnRecyclerViewByItemPositionAndViewId
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.helpers.other.Authorization
import ru.letu.ui.helpers.utils.testdata.TestConst.LOGIN
import ru.letu.ui.helpers.utils.testdata.TestConst.PASSWORD
import ru.letu.ui.screens.CartScreen
import ru.letu.ui.screens.CheckoutTabsScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.feature.checkout.R as R1

@RunWith(AndroidJUnit4::class)
class CheckoutDeliveryTabsTest : AllureTestCase() {

    fun test() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
            Authorization.authorize(LOGIN, PASSWORD)
        }.run {
            step("1-Открыть корзину") {
                MenuScreen {
                    openCart()
                }
            }
            step("2-Перейти на чекаут") {
                CartScreen {
                    recyclerView.scrollTo(4)
                    waitAnimation()
                    Espresso.onView(ViewMatchers.withId(ru.letu.core.endeca.R.id.endecaRecycler))
                        .perform(
                            clickOnRecyclerViewByItemPositionAndViewId(
                                6,
                                R.id.checkout_button
                            )
                        )
                }
            }
            step("3-На экране скрыт раздел выбора региона (есть доступные группы доставки)") {
                CheckoutTabsScreen {
                    recyclerView {
                        childAt<CheckoutTabsScreen.CheckoutTabsHolder>(1) {
                            isVisible()
                            selectCity.isGone()
                            changeCity.isGone()
                        }
                    }
                }
            }
            step("4-На экране отображаются табы выбора группы доставки") {
                CheckoutTabsScreen {
                    recyclerView {
                        childAt<CheckoutTabsScreen.CheckoutTabsHolder>(1) {
                            pickupTab.isVisible()
                            courierTab.isVisible()
                            pickupTabTitle.hasTextColor(ru.letu.ui.R.color.white)
                            courierTabTitle.hasTextColor(ru.letu.ui.R.color.black)
                        }
                    }
                }
            }
            step("5-На экране отображаются группы доставки самовывоза") {
                CheckoutTabsScreen {
                    recyclerView {
                        childAt<CheckoutTabsScreen.CheckoutTabsHolder>(1) {
                            pickup.isVisible()
                            point.isVisible()
                        }
                    }
                }
            }
            step("6-Выбрать курьерскую доставку") {
                Espresso.onView(ViewMatchers.withId(R1.id.courierTab)).perform(click())
                waitForResponses()
            }
            step("7-На экране отображается курьерская группа доставки") {
                CheckoutTabsScreen {
                    recyclerView {
                        childAt<CheckoutTabsScreen.CheckoutTabsHolder>(1) {
                            pickupTabTitle.hasTextColor(ru.letu.ui.R.color.black)
                            courierTabTitle.hasTextColor(ru.letu.ui.R.color.white)
                            courier.isVisible()
                        }
                    }
                }
            }
        }
    }
}
