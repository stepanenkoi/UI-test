package oasis.letu.tests.cartTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.AddItemToCartScenario
import oasis.letu.screens.сartScreens.CartScreen
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/58870?treeId=14&search=W3siaWQiOiJjZi4yNiIsInR5cGUiOiJsb25nQXJyYXkiLCJ2YWx1ZSI6WzcwNDVdfV0%3D

class GoToAuthFromCart : DefaultTest(
    "UAE.Mobile.Android.Оформление заказа.Корзина.Переход к страницы чекаут неавторизованным клиентом " +
        "в новый аккаунт"
) {
    @Test
    @AllureId("58870")
    @Step(
        "UAE.Mobile.Android.Оформление заказа.Корзина.Переход к страницы чекаут неавторизованным клиентом" +
        " в новый аккаунт"
    )
    fun authTest_58870() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Оформление заказа.Корзина.") {
            scenario(AddItemToCartScenario())
            CartScreen {
                clickContinueButton()
            }
        }
    }
}
