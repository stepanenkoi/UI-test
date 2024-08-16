package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.helper.GenerateRandomString
import oasis.letu.screens.authScreens.AuthorizationScreen
import oasis.letu.screens.authScreens.RegistrationSmsCodeScreen
import oasis.letu.screens.authScreens.WelcomeToLetoileWorldWithCardScreen
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.testData.TestDataScreen

class RegistrationScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {

        step("Регестрация") {
            BottomNavigation.openBottomMenu()
            MenuScreen.openAuthorizationScreen()
            AuthorizationScreen {
                enterPhoneField(GenerateRandomString.generatePhone(9))
                closeSoftKeyboard()
                clickSendCodeBtn()
            }
            RegistrationSmsCodeScreen {
                enterPhoneCode(TestDataScreen.LOGIN_SMS_CODE)
                clickPrivacyPolicyAgreementToggle()
                clickRegisterUAEButton()
            }
            WelcomeToLetoileWorldWithCardScreen {
               clickActivateCardButton()
            }
        }
    }
}
//        step("Открыть меню") {
//            BottomNavigation {
//                Thread.sleep(6000)
//                openBottomMenu()
//            }
//
//            step("Открыть экран авторизации") {
//                MenuScreen {
//                    flakySafely(timeoutMs = 3000) {
//                        openAuthorizationScreen()
//                    }
//                }
//            }
//            step("Ввести рандомный номер телефона") {
//                AuthorizationScreen {
//                    EnterPhoneField {
//                        typeText(GenerateRandomString.generatePhone(9))
//                    }
//                    SendCodeButton {
//                        click()
//                    }
//                }
//            }
//            step("Включить тогглы") {
//                RegistrationSmsCodeScreen {
//                    ReciewNewsToggle {
//                        isVisible()
//                        click()
//                    }
//                    closeSoftKeyboard()
//                    PrivacyPolicyAgreementToggle {
//                        isVisible()
//                        click()
//                    }
//                }
//            }
//            step("ввести смс код") {
//                RegistrationSmsCodeScreen {
//                    EnterSmsCodeField {
//                        isVisible()
//                        typeText("1111")
//                    }
//                    RegisterButton {
//                        isVisible()
//                        click()
//                    }
//                }
//            }
//            step("Прокликать велком скрин") {
//                WelcomeToLetoileWorldScreen {
//                    StartShoppingButton {
//                        click()
//                    }
//                }
//            }
//        }
//    }
// }
