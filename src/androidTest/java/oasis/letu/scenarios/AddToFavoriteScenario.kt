package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.screens.сatalogScreens.PDPScreen

class AddToFavoriteScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Добвать товар в избранное и перейти на экран Favorite") {
            PDPScreen {
                getPdp()
                clickFavoriteButton()
            }
            BottomNavigation {
                openFavorite()
            }
        }
    }
}
