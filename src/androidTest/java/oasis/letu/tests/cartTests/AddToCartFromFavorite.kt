package oasis.letu.tests.cartTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.AddToFavoriteScenario
import oasis.letu.screens.FavoriteScreen
import oasis.letu.screens.navigation.BottomNavigation
import org.junit.Test

class AddToCartFromFavorite : DefaultTest(
    "UAE.Mobile.Android.Избранное. Добавление товара в Корзину с экрана Избранного"
) {
    @Test
    @AllureId("59538")
    @Step(
        "UAE.Mobile.Android.Избранное. Добавление товара в Корзину с экрана Избранного"
    )
    fun authTest_59538() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("UAE.Mobile.Android.Избранное.Добавление.") {
            scenario(AddToFavoriteScenario())
        }
        FavoriteScreen {
            clickAddToCartButton()
        }
        BottomNavigation {
            openCart()
        }
    }
}
