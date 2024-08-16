package oasis.letu.tests.favoriteTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.AddToFavoriteScenario
import oasis.letu.screens.FavoriteScreen
import oasis.letu.screens.сatalogScreens.PDPScreen
import org.junit.Test

class GoToPDPFromFavorite : DefaultTest(
    "UAE.Mobile.Android.Избранное.Переход на PDP. Переход на PDP из карточки товара на Избранном"
) {
    @Test
    @AllureId("59559")
    @Step(
        "UAE.Mobile.Android.Избранное.Переход на PDP. Переход на PDP из карточки товара на Избранном"
    )
    fun authTest_59559() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("UAE.Mobile.Android.Избранное.Добавление.") {
            scenario(AddToFavoriteScenario())
        }
        FavoriteScreen {
            clickProdName()
        }
        PDPScreen {
            checkName()
            checkPrice()
            // потом поменяю на ассерт PDP
        }
    }
}
