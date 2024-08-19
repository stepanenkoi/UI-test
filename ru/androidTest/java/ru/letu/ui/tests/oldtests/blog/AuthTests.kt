package ru.letu.ui.tests.oldtests.blog

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.runner.RunWith
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.helpers.GenerateRandomString.generatePhone
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchActivity
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.ProfileScreen
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

@RunWith(AndroidJUnit4::class)
class AuthTests : AllureTestCase() {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    fun simplifiedAuthWithEmailTest() { // https://testrail.letoile.tech/index.php?/cases/view/40888
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                agreeQuestionIsThisYourCity()
            }
        }.after {
            mActivityTestRule.finishActivity()
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
                    enterEmail("cord@mail.ru")
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
                    enterPassword("123456789")
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
                        hasText("тест")
                    }
                }
            }
            step("10-Перейти в профиль") {
                MenuScreen {
                    openProfile()
                }
                ProfileScreen {
                    openPersonalDataInfo()
                }
            }
            step("11-Отображается экран личного с данными пользователя.") {
                ProfileScreen {
//                    username {
//                        isVisible()
//                        hasText("тест")
//                    }
//                    email {
//                        isVisible()
//                        hasText("cord@mail.ru")
//                    }
                }
            }
        }
    }

    fun logoutTest() { // https://testrail.letoile.tech/index.php?/cases/view/40889
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                agreeQuestionIsThisYourCity()
            }
        }.after {
            mActivityTestRule.finishActivity()
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
            step("3-Ввести валидный номер телефона зарегистрированного юзера") {
                SimplifiedAuthorizationScreen {
                    enterPhoneNumber("9780266340")
                    closeSoftKeyboard()
                }
            }
            step("4-Нажать на кнопку \"Продолжить\"") {
                SimplifiedAuthorizationScreen {
                    continueAuthClick()
                }
            }
            step("5-Ввести код из СМС") {
                SimplifiedAuthorizationScreen {
                    enterPhoneCode("6666")
                }
            }
            step("6-Пользователю отобразилось меню с именем") {
                MenuScreen {
                    userNameText {
                        isVisible()
                        hasText("тест")
                    }
                }
            }
            step("7-Открыть вкладку \"Личный кабинет\"") {
                MenuScreen {
                    openProfile()
                }
            }
            step("8-Открыть вкладку личные данные") {
                ProfileScreen {
                    openPersonalDataInfo()
                }
            }
            step("9-Нажать на кнопку \"Выйти из личного кабинета\"") {
                ProfileScreen {
                    logoutUser()
                }
            }
            step("10-Пользователь вышел из своего аккаунта") {
                SimplifiedAuthorizationScreen {
                    phoneTitle.isSelected()
                }
            }
        }
    }

    fun simplifiedAuthWithPhoneTest() { // https://testrail.letoile.tech/index.php?/cases/view/40887
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                agreeQuestionIsThisYourCity()
            }
        }.after {
            mActivityTestRule.finishActivity()
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
            step("4-Ввести валидный номер телефона зарегистрированного юзера") {
                SimplifiedAuthorizationScreen {
                    enterPhoneNumber("9780266340")
                    closeSoftKeyboard()
                }
            }
            step("5-Нажать на кнопку \"Продолжить\"") {
                SimplifiedAuthorizationScreen {
                    continueAuthClick()
                }
            }
            step("6-Открывается экран для ввода кода подтверждения") {
                SimplifiedAuthorizationScreen {
                    sendSmsInfo {
                        isVisible()
                        hasText("Мы отправили СМС с кодом на номер +7 (978) 026-63-40")
                    }
                }
            }
            step("7-Ввести код из СМС") {
                SimplifiedAuthorizationScreen {
                    enterPhoneCode("6666")
                }
            }
            step("8-Пользователю отобразилось меню с именем") {
                MenuScreen {
                    userNameText {
                        isVisible()
                        hasText("тест")
                    }
                }
            }
        }
    }

    fun simplifiedRegistrationWithPhoneTest() { // https://testrail.letoile.tech/index.php?/cases/view/40890
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                agreeQuestionIsThisYourCity()
            }
        }.after {
            mActivityTestRule.finishActivity()
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
            step("4-Ввести валидный номер телефона") {
                SimplifiedAuthorizationScreen {
                    enterPhoneNumber(generatePhone(10))
                    closeSoftKeyboard()
                }
            }
            step("5-Нажать на кнопку \"Продолжить\"") {
                SimplifiedAuthorizationScreen {
                    continueAuthClick()
                }
            }
            step("6-Открывается экран для ввода кода подтверждения") {
                SimplifiedAuthorizationScreen {
                    sendSmsInfo {
                        isVisible()
                        startsWithText("Мы отправили СМС с кодом на номер +7 ")
                    }
                }
            }
            step("7-Ввести код из СМС") {
                SimplifiedAuthorizationScreen {
                    enterPhoneCode("6666")
                }
            }
            step("8-Открылось меню пользователя с пустым именем") {
                MenuScreen {
                    userNameText {
                        isVisible()
                        hasText("")
                    }
                }
            }
            step("9-Перейти в профиль") {
                MenuScreen {
                    openProfile()
                }
            }
            step("10-Отобразился профиль с незаполнным именем и фамилией.") {
                ProfileScreen {
//                    username {
//                        isVisible()
//                        hasText("")
//                    }
//                    email {
//                        isVisible()
//                        hasText("")
//                    }
                }
            }
        }
    }
}
