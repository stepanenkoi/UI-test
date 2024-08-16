package oasis.letu.tests.favoriteTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.AddItemToCartScenario
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.screens.сartScreens.CartScreen
import org.junit.Test

class AddToFavoriteFromCart : DefaultTest(
    "UAE.Mobile.Android.Оформление заказа.Корзина. Добавление товара в избранное через иконку " +
        "сердце неавторизованным клиентом"
) {
    @Test
    @AllureId("58812")
    @Step(
        "UAE.Mobile.Android.Оформление заказа.Корзина. Добавление товара в избранное через иконку " +
            "сердце неавторизованным клиентом"
    )
    fun authTest_58812() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Оформление заказа .Корзина") {
            scenario(AddItemToCartScenario())
            CartScreen {
                addToFavorite()
            }
            BottomNavigation {
                openFavorite()
            }
        }
    }
}
