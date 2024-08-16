package oasis.letu.tests.favoriteTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.AddToFavoriteScenario
import oasis.letu.screens.FavoriteScreen
import org.junit.Test

class RemoveFromFavoriteTest : DefaultTest(
    "UAE.Mobile.Android.Избранное.Удаление. Удаление единственного товара на экране Избранное и показ пустого" +
        " Избранного. Юзер аноним"
) {
    @Test
    @AllureId("59556")
    @Step(
        "UAE.Mobile.Android.Избранное.Удаление. Удаление единственного товара на экране Избранное и показ пустого" +
            " Избранного. Юзер аноним"
    )
    fun authTest_59556() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("UAE.Mobile.Android.Избранное.Добавление.") {
            scenario(AddToFavoriteScenario())
        }
        FavoriteScreen {
            clickFavorite()
            swipeRefresh.swipeDown()
            assertEmptyFavoriteOpen()
        }
    }
}
