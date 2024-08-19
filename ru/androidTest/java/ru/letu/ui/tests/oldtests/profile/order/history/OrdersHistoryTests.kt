package ru.letu.ui.tests.oldtests.profile.order.history

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.helpers.other.Authorization
import ru.letu.ui.profile.orders.history.online.OrdersHistoryListFragment
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.OrdersHistoryListScreen

@RunWith(AndroidJUnit4::class)
class OrdersHistoryTests : AllureTestCase() {

    @Suppress("LongMethod")
    fun testChangedDateNotification() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
            Authorization.authorize(LOGIN, PASSWORD)
        }.run {
            step("1-Открыть мои заказы") {
                launchFragmentInHiltContainer<OrdersHistoryListFragment>()
            }
            step("2. На экране отображается тулбар и список") {
                OrdersHistoryListScreen {
                    toolbar.isVisible()
                    endecaRecycler.isVisible()
                }
            }
            step("3. Первый в списке картридж - header") {
                OrdersHistoryListScreen {
                    endecaRecycler {
                        childAt<OrdersHistoryListScreen.Header>(0) {
                            title.isVisible()
                        }
                    }
                }
            }
            step("4. Первый заказ с мульти доставкой отображается, нотификация не отображается") {
                OrdersHistoryListScreen {
                    endecaRecycler {
                        childAt<OrdersHistoryListScreen.MultiShipmentOrder>(1) {
                            self.isVisible()
                            changedDateNotificationGone.isGone()
                        }
                    }
                }
            }
            step("5. Второй заказ с мульти доставкой отображается, нотификация отображается") {
                OrdersHistoryListScreen {
                    endecaRecycler {
                        childAt<OrdersHistoryListScreen.MultiShipmentOrder>(2) {
                            self.isVisible()
                            changedDateNotificationVisible.isVisible()
                        }
                    }
                }
            }
            step("6. Первый заказ с одиночной доставкой отображается, нотификация не отображается") {
                OrdersHistoryListScreen {
                    endecaRecycler {
                        childAt<OrdersHistoryListScreen.SingleShipmentOrder>(3) {
                            departureInfo.isVisible()
                            changedDateNotificationGone.isGone()
                        }
                    }
                }
            }
            step("7. Второй заказ с одиночной доставкой отображается, нотификация отображается") {
                OrdersHistoryListScreen {
                    endecaRecycler {
                        scrollTo(4)
                        childAt<OrdersHistoryListScreen.SingleShipmentOrder>(4) {
                            departureInfo.isVisible()
                            changedDateNotificationVisible.isVisible()
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val LOGIN = "alllll@mail.ru"
        const val PASSWORD = "1"
    }
}
