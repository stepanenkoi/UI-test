package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.bottomSheet.CountrySelectionBottomScreen
import oasis.letu.screens.authScreens.AuthorizationScreen
import oasis.letu.screens.authScreens.LoginSmsCodeScreen
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.testData.TestDataScreen

class LoginScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Залогиниться ") {
            BottomNavigation.openBottomMenu()
            MenuScreen.openAuthorizationScreen()
            AuthorizationScreen.clickOnCountrySelectionField()
            CountrySelectionBottomScreen {
                scrollToEnd()
                clickCountryByText(SELECTED_COUNTRY_NAME)
            }
            AuthorizationScreen {
                enterPhoneField(TestDataScreen.PHONE)
                closeSoftKeyboard()
                clickSendCodeBtn()
            }
            LoginSmsCodeScreen {
                enterPhoneCode(TestDataScreen.LOGIN_SMS_CODE)
                clickLogInButton()
            }
        }
    }
    companion object {
        private const val SELECTED_COUNTRY_NAME = "United Arab Emirates"
    }
}
