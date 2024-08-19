package ru.letu.ui.tests.oldtests.profile.order.history

import androidx.core.os.bundleOf
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.helpers.other.Authorization
import ru.letu.ui.profile.orders.history.online.OrderHistoryDetailsFragment
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.OrderDetailsHistoryScreen

@RunWith(AndroidJUnit4::class)
class OrderDetailsHistoryTests : AllureTestCase() {

    // включен тоггл order_details_history_change_address_toggle и order_history_change_date_toggle
    @Suppress("LongMethod")
    fun testChangeAddressBlock() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
            Authorization.authorize(LOGIN, PASSWORD)
        }.run {
            step("1-Открыть детальную информацию по заказу") {
                launchFragmentInHiltContainer<OrderHistoryDetailsFragment>(
                    fragmentArgs = bundleOf(
                        OrderHistoryDetailsFragment.ORDER_ID_ARG to ORDER_ID
                    )
                )
            }
            step("2-Пользователю виден экран с детальной информацией по заказу") {
                OrderDetailsHistoryScreen {
                    checkOrderDetailsScreenIsVisible()
                }
            }
            step("3-Пользователю видна информация о доставке, в первом отправлении можно изменить адрес") {
                OrderDetailsHistoryScreen {
                    recycler {
                        childAt<OrderDetailsHistoryScreen.ChildOrder>(0) {
                            addressInfoText1.isVisible()
                            visibleChangeAddress.isVisible()
                        }
                    }
                }
            }
            step("4-Пользователю видна информация о доставке, во втором отправлении нельзя изменить адрес") {
                OrderDetailsHistoryScreen {
                    recycler {
                        childAt<OrderDetailsHistoryScreen.ChildOrder>(9) {
                            addressInfoText2.isVisible()
                            invisibleChangeAddress.isGone()
                        }
                    }
                }
            }
        }
    }

    // включен тоггл order_details_history_change_date_and_time_toggle и order_history_change_date_toggle

    @Suppress("LongMethod")
    fun testChangeDateTimeBlock() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
            Authorization.authorize(LOGIN, PASSWORD)
        }.run {
            step("1-Открыть детальную информацию по заказу") {
                launchFragmentInHiltContainer<OrderHistoryDetailsFragment>(
                    fragmentArgs = bundleOf(
                        OrderHistoryDetailsFragment.ORDER_ID_ARG to ORDER_ID
                    )
                )
            }
            step("2-Пользователю виден экран с детальной информацией по заказу") {
                OrderDetailsHistoryScreen {
                    checkOrderDetailsScreenIsVisible()
                }
            }
            step("3-Пользователю видна информация о доставке, в первом отправлении можно изменить дату") {
                OrderDetailsHistoryScreen {
                    recycler {
                        childAt<OrderDetailsHistoryScreen.ChildOrder>(0) {
                            dateInfoText1.isVisible()
                            visibleChangeDateTime.isVisible()
                        }
                    }
                }
            }
            step("4-Пользователю видна информация о доставке, во втором отправлении нельзя изменить адрес") {
                OrderDetailsHistoryScreen {
                    recycler {
                        childAt<OrderDetailsHistoryScreen.ChildOrder>(9) {
                            dateInfoText2.isVisible()
                            invisibleChangeDateTime.isGone()
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val ORDER_ID = "7300004553"
        const val LOGIN = "uitestandroid@mail.ru"
        const val PASSWORD = "1"
    }
}
