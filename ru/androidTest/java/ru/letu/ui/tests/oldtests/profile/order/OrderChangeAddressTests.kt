package ru.letu.ui.tests.oldtests.profile.order

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.feature.addresses.choose.v2.OrderChangeAddressFragment
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.helpers.other.Authorization
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.OrderChangeAddressScreen

@RunWith(AndroidJUnit4::class)
class OrderChangeAddressTests : AllureTestCase() {

    @Suppress("LongMethod")
    fun testChangeAddressScreen() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
            Authorization.authorize(LOGIN, PASSWORD)
        }.run {
            step("1- Открываем экран со списком адресов") {
                launchFragmentInHiltContainer<OrderChangeAddressFragment>(
                    fragmentArgs = OrderChangeAddressFragment.args(SELECTED_ADDRESS_ID, CITY_NAME)
                )
            }
            step("2-Пользователю отобразился экран со списком адресов") {
                OrderChangeAddressScreen {
                    testChangeAddressScreen()
                }
            }
            step("3-Пользователю видны наименование адреса, кнопка редактирования и галочка") {
                OrderChangeAddressScreen {
                    recycler {
                        childAt<OrderChangeAddressScreen.Address>(0) {
                            editIcon.isVisible()
                            addressText.isVisible()
                            selectedIcon.isVisible()
                        }
                    }
                }
            }
        }
    }

    companion object {
        const val CITY_NAME = "Москва(в пределах МКАД)"
        const val SELECTED_ADDRESS_ID = "ci9798860597"
        const val LOGIN = "uitestandroid@mail.ru"
        const val PASSWORD = "1"
    }
}
