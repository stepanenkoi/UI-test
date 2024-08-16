package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.bottomSheet.CountrySelectionBottomScreen
import oasis.letu.helper.GenerateRandomString
import oasis.letu.screens.authScreens.AuthorizationScreen
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation

class GoToRegistrationUAEScreenScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {

        step("Открыть экран логина ") {
            BottomNavigation.openBottomMenu()
            MenuScreen.openAuthorizationScreen()
            AuthorizationScreen.clickOnCountrySelectionField()
            CountrySelectionBottomScreen {
                scrollToEnd()
                clickCountryByText(SELECTED_COUNTRY_NAME)
            }
            AuthorizationScreen {
                enterPhoneField(GenerateRandomString.generatePhone(9))
                closeSoftKeyboard()
                clickSendCodeBtn()
            }
        }
    }
    companion object {
        private const val SELECTED_COUNTRY_NAME = "United Arab Emirates"
    }
}

// step("Открыть меню") {
//            BottomNavigation {
//                openBottomMenu()
//            }
//
//            step("Открыть экран авторизации") {
//                MenuScreen {
//                    flakySafely(timeoutMs = 4000) {
//                        openAuthorizationScreen()
//                    }
//                }
//            }
//            step("Зарегаться UAE рандомным номером") {
//                AuthorizationScreen {
//                    OpenListImage {
//                        click()
//                    }
//                    scrollToEnd()
//                    TestUtils.clickText("United Arab Emirates")
//                    EnterPhoneField {
//                        typeText(GenerateRandomString.generatePhone(9))
//                    }
//                    SendCodeButton {
//                        click()
//                    }
//                }
//            }
//        }
//    }
// }
