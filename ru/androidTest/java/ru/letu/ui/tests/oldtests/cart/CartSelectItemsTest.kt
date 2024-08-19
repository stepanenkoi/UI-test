package ru.letu.ui.tests.oldtests.cart

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.splash.SplashFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

@RunWith(AndroidJUnit4::class)
class CartSelectItemsTest : AllureTestCase() {

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
                    enterEmail("ej_user@autotest.com")
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
            step("10-Открыть корзину") {
                MenuScreen {
                    openCart()
                }
            }
//            step("11-Корзина содержит выбранный товар в доступном отправлении") {
//                CartScreen {
//                    recyclerView {
//                        childAt<CartScreen.CommerceItemCartridge>(4) {
//                            isVisible()
//                            selectContent.isVisible()
//                            selectedCheckBox.isVisible()
//                            selectedCheckBox.isChecked()
//                        }
//                    }
//                }
//            }
//            step("12-Корзина содержит невыбранный товар в недоступном отправлении") {
//                CartScreen {
//                    recyclerView {
//                        childAt<CartScreen.CommerceItemCartridge>(6) {
//                            isVisible()
//                            selectContent.isVisible()
//                            selectedCheckBox.isVisible()
//                            selectedCheckBox.isNotChecked()
//                        }
//                    }
//                }
//            }
//            step("13-В заголовке доступного отправления есть элемент \"Выбрать все\" и элемент \"Удалить все\"") {
//                CartScreen {
//                    recyclerView {
//                        childAt<CartScreen.AvailableItemsCartridge>(3) {
//                            isVisible()
//                            selectAll.isVisible()
//                            removeAll.isVisible()
//                            selectAll.isNotChecked()
//                        }
//                    }
//                }
//            }
//            step("14-В заголовке недоступного отправления нет элемента \"Выбрать все\" и элемента \"Удалить все\"") {
//                CartScreen {
//                    recyclerView {
//                        childAt<CartScreen.AvailableItemsCartridge>(5) {
//                            isVisible()
//                            selectAll.isGone()
//                            removeAll.isGone()
//                        }
//                    }
//                }
//            }
        }
    }
}
