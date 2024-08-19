package ru.letu.ui.tests.oldtests.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.feature.addresses.view.AddressesFragment
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.AddressListScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

/**
 * Created by Vladislav Kochetov on 10.03.2022.
 */
@RunWith(AndroidJUnit4::class)
class AddressListTest : AllureTestCase() {

    fun test() {
        init {
            launchFragmentInHiltContainer<SplashFragment>()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
        }.run {
            step("1-Открыть боковое меню") {
                Navigation {
                    openBottomMenu()
                }
            }
            step("2-Нажать на кнопку \"Войти\"") {
                MenuScreen {
                    openAuthorizationScreen()
                }
            }
            step("3-Открывается экран авторизации, по умолчанию выбрана вкладка авторизации по номеру телефона") {
                SimplifiedAuthorizationScreen {
                    phoneTitle.isSelected()
                }
            }
            step("4-Переключить на вкладку \"Email\"") {
                SimplifiedAuthorizationScreen {
                    emailTitle.click()
                    emailTitle.isSelected()
                }
            }
            step("5-Ввести валидный Email зарегистрированного юзера") {
                SimplifiedAuthorizationScreen {
                    enterEmail("pandas_user@autotest.com")
                }
            }
            step("6-Нажать кнопку \"Продолжить\"") {
                SimplifiedAuthorizationScreen {
                    continueAuthClick()
                }
            }
            step("7-Ввести валидный пароль зарегистрированного юзера") {
                SimplifiedAuthorizationScreen {
                    authDescription.isVisible()
                    enterPassword("Q!W@E#")
                    closeSoftKeyboard()
                }
            }
            step("8-Нажать кнопку \"Продолжить\"") {
                SimplifiedAuthorizationScreen {
                    continueAuthClick()
                }
            }
            step("9-Пользователю отобразилось меню с именем") {
                MenuScreen {
                    userNameText {
                        isVisible()
                        hasAnyText()
                    }
                }
            }
            step("10-Открыть адреса") {
                launchFragmentInHiltContainer<AddressesFragment>()
            }
            step("11-Пользователь видит список адресов") {
                AddressListScreen {
                    consistencyCheck()
                }
            }
        }
    }
}
