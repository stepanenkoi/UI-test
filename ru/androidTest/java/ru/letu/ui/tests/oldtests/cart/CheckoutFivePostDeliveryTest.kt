package ru.letu.ui.tests.oldtests.cart

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.TestUtils
import ru.letu.ui.helpers.TestUtils.waitAnimation
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.clickOnRecyclerViewByItemPositionAndViewId
import ru.letu.ui.helpers.isVisible
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.helpers.other.Authorization
import ru.letu.ui.helpers.utils.testdata.TestConst.LOGIN
import ru.letu.ui.helpers.utils.testdata.TestConst.PASSWORD
import ru.letu.ui.screens.CartScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.OptimalPickupScreen
import ru.letu.feature.checkout.R as R1
import ru.letu.feature.checkout.R as RCheckout

@RunWith(AndroidJUnit4::class)
class CheckoutFivePostDeliveryTest : AllureTestCase() {

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
                        .perform(clickOnRecyclerViewByItemPositionAndViewId(6, RCheckout.id.checkout_button))
                }
            }
            step("3-Открыть экран выбора ПВЗ") {
                waitForResponses()
                Espresso.onView(ViewMatchers.withId(ru.letu.core.endeca.R.id.endecaRecycler))
                    .perform(clickOnRecyclerViewByItemPositionAndViewId(1, R1.id.pointOfIssueChangePoint))
            }
            step("4-Закрыть диалог с информацией о ПВЗ") {
                waitForResponses()
                Espresso.onView(ViewMatchers.withId(R1.id.points_close)).perform(click())
            }
            step("5-Открыть список фильтров") {
                waitAnimation()
                OptimalPickupScreen {
                    filterButton {
                        isVisible()
                        click()
                    }
                }
            }
            step("6-В списке фильтров содержится новый фильтр 5Post") {
                Espresso.onView(TestUtils.first(withText("5Post"))).isVisible()
            }
        }
    }
}
