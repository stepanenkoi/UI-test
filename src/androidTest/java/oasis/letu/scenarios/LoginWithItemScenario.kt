package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.screens.authScreens.AuthorizationScreen
import oasis.letu.screens.authScreens.LoginSmsCodeScreen
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.navigation.BottomNavigation

class LoginWithItemScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Открыть меню") {

            BottomNavigation {
                Thread.sleep(5000)
                openBottomMenu()
            }
        }
        step("Открыть экран авторизации") {
            MenuScreen {
                openAuthorizationScreen()
            }
        }
        step("Открыть экран логина и ввести номер") {
            AuthorizationScreen {
                EnterPhoneField {
                    isVisible()
                    typeText("777666555")
                }
                SendCodeButton {
                    isVisible()
                    click()
                }
            }
        }
        step("Ввести смс код") {
            LoginSmsCodeScreen {
                enterPhoneCode("2222") // или другой валидный код
            }
        }
        step("Залогиниться") {
            LoginSmsCodeScreen {
                LogInButton {
                    isVisible()
                    click()
                }
            }
        }
    }
}
