package ru.letu.ui.tests.oldtests.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.OnboardingScreen

/**
 * Created by Vladislav Kochetov on 26.04.2022.
 */
@RunWith(AndroidJUnit4::class)
class OnboardingTest : AllureTestCase() {

    fun test() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
        }.run {
            step("1-Пользователь видит онбординг") {
                OnboardingScreen {
                    checkConsistency()
                }
            }
            step("2-Пользователь пропускает онбординг") {
                OnboardingScreen {
                    skip()
                }
            }
            step("3-Пользователь больше не видит онбординг") {
                Navigation {
                    bottomMenu.isDisplayed()
                }
            }
        }
    }
}
