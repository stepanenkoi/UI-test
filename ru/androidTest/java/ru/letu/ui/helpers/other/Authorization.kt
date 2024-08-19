package ru.letu.ui.helpers.other

import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

object Authorization {

    fun authorize(login: String, password: String) {
        openAuthorizationScreen()
        SimplifiedAuthorizationScreen {
            emailTitle.click()
            emailTitle.isSelected()
        }
        SimplifiedAuthorizationScreen {
            enterEmail(login)
        }
        SimplifiedAuthorizationScreen {
            continueAuthClick()
        }
        SimplifiedAuthorizationScreen {
            authDescription.isVisible()
            enterPassword(password)
            closeSoftKeyboard()
        }
        SimplifiedAuthorizationScreen {
            continueAuthClick()
        }
        MenuScreen {
            userNameText {
                isVisible()
                hasAnyText()
            }
        }
    }

    fun authorize(phoneNumber: String) {
        openAuthorizationScreen()
        SimplifiedAuthorizationScreen {
            enterPhoneNumber(phoneNumber)
            closeSoftKeyboard()
        }
        SimplifiedAuthorizationScreen {
            continueAuthClick()
        }
        SimplifiedAuthorizationScreen {
            sendSmsInfo {
                isVisible()
            }
        }
        SimplifiedAuthorizationScreen {
            // developer mode для смс-ок включен
            enterPhoneCode(SMS_CODE)
        }
        MenuScreen {
            userNameText {
                isVisible()
            }
        }
    }

    private fun openAuthorizationScreen() {
        Navigation {
            openBottomMenu()
        }
        MenuScreen {
            openAuthorizationScreen()
        }
        SimplifiedAuthorizationScreen {
            phoneTitle.isSelected()
        }
    }

    private const val SMS_CODE = "6666"
}
