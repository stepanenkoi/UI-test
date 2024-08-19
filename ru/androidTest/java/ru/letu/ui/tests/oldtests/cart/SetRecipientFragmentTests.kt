package ru.letu.ui.tests.oldtests.cart

import androidx.core.os.bundleOf
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.feature.checkout.ui.fragment.SetRecipientFragment
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.helpers.other.Authorization
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.SetRecipientScreen

@RunWith(AndroidJUnit4::class)
class SetRecipientFragmentTests : AllureTestCase() {

    companion object {
        private const val PHONE_NUMBER = "3214455870"
        private const val FULL_PHONE_NUMBER = "+7 (321) 445-58-70"
    }

    @Suppress("LongMethod")
    fun testSetReceiverScreen() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
            Authorization.authorize(PHONE_NUMBER)
        }.run {
            step("1- Открываем экран уточнения данных получателя") {
                launchFragmentInHiltContainer<SetRecipientFragment>(
                    fragmentArgs = bundleOf(
                        SetRecipientFragment.PAGE_INFO_KEY to ""
                    )
                )
            }
            step("2-Пользователю отобразился экран, все поля отображены") {
                SetRecipientScreen {
                    checkScreenIsVisible()
                }
            }
            step("3-Поле телефона содержит верный номер и заблокировано") {
                SetRecipientScreen {
                    phone.isDisabled()
                    phone.hasText(FULL_PHONE_NUMBER)
                }
            }
        }
    }
}
