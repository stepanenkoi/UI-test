package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.bottomSheet.CountrySelectionBottomScreen
import oasis.letu.screens.authScreens.AuthorizationScreen
import oasis.letu.screens.authScreens.CountryData.ALBANIA
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.testData.TestDataScreen

class GoToLoginScreenScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {

        step("Открыть экран логина ") {
            BottomNavigation.openBottomMenu()
            MenuScreen.openAuthorizationScreen()
            AuthorizationScreen.clickOnCountrySelectionField()
            CountrySelectionBottomScreen {
                clickCountryByText(ALBANIA)
            }
            AuthorizationScreen {
                enterPhoneField(TestDataScreen.AlbaniaPHONE)
                closeSoftKeyboard()
                clickSendCodeBtn()
            }
        }
    }
}
