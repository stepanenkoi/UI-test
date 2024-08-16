package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.bottomSheet.CountrySelectionBottomScreen
import oasis.letu.screens.authScreens.AuthorizationScreen
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.testData.TestDataScreen.PHONE

class GoToLoginUAEScreenScenario : Scenario() {
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
                enterPhoneField(PHONE)
                closeSoftKeyboard()
                clickSendCodeBtn()
            }
        }
    }
    companion object {
        private const val SELECTED_COUNTRY_NAME = "United Arab Emirates"
    }
}
