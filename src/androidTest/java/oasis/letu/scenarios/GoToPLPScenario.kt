package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.screens.сatalogScreens.CatalogScreen
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.screens.сatalogScreens.GroupScreen

class GoToPLPScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Перейти на экран PLP") {
            BottomNavigation {
                Thread.sleep(3000)
                openCatalog()
            }
            Thread.sleep(2000)
            CatalogScreen.clickName1()
            Thread.sleep(2000)
            GroupScreen.clickGroup()
        }
    }
}
