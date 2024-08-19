package ru.letu.ui.tests.oldtests.profile.order

import androidx.core.os.bundleOf
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.helpers.other.Authorization
import ru.letu.ui.profile.orders.history.online.date.OrderChangeDateFragment
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.OrderChangeDateScreen

@RunWith(AndroidJUnit4::class)
class OrderChangeDateTests : AllureTestCase() {

    @Suppress("LongMethod")
    fun testChangeDateScreen() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
            Authorization.authorize(LOGIN, PASSWORD)
        }.run {
            step("1- Открываем экран со списком даты и времени") {
                launchFragmentInHiltContainer<OrderChangeDateFragment>(
                    fragmentArgs = bundleOf(
                        OrderChangeDateFragment.ORDER_ID to ORDER_ID,
                        OrderChangeDateFragment.DELIVERY_TYPE to DELIVERY_TYPE,
                        OrderChangeDateFragment.DELIVERY_ADDRESS to ADDRESS
                    )
                )
            }
            step("2-Пользователю отобразился экран со списком доступных дат и времени доставки") {
                OrderChangeDateScreen {
                    testChangeDateScreenVisibility()
                }
            }
            step("3-Пользователь видит верный текст") {
                OrderChangeDateScreen {
                    deliveryType.hasText(DELIVERY_TYPE)
                    address.hasText(ADDRESS)
                }
            }
        }
    }

    companion object {
        const val ADDRESS = "некий адрес"
        const val LOGIN = "uitestandroid@mail.ru"
        const val PASSWORD = "1"
        const val ORDER_ID = "7300103620"
        const val DELIVERY_TYPE = "Курьерская доставка"
    }
}
