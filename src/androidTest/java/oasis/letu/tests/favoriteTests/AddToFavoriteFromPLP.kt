package oasis.letu.tests.favoriteTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class AddToFavoriteFromPLP : DefaultTest(
    "UAE.Mobile.Android.Избранное.Добавление. Добавление товара в Избранное из Каталога с PLP. Юзер аноним"
) {
    @Test
    @AllureId("60081")
    @Step(
        "UAE.Mobile.Android.Избранное.Добавление. Добавление товара в Избранное из Каталога с PLP. Юзер аноним"
    )
    fun authTest_60081() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Открыть экран plp") {
            scenario(GoToPLPScenario())
        }
        PLPScreen {
            clickFavorite()
        }
        BottomNavigation {
            openFavorite()
        }
    }
}
