package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.screens.menuScreens.DeleteAccountScreen
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.menuScreens.PersonalDataScreen
import oasis.letu.screens.navigation.BottomNavigation

class DeleteAccountScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Удаление аккаунта") {
            BottomNavigation {
                Thread.sleep(6000)
                openBottomMenu()
            }
            MenuScreen {
                UserName {
                    click()
                }
            }
            PersonalDataScreen {
                deleteButton {
                    click()
                }
                DeleteAccountScreen {
                    buttonDelete {
                        click()
                    }
                }
            }
        }
    }
}
