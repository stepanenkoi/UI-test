package oasis.letu.tests.cartTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.AddItemToCartScenario
import oasis.letu.screens.сartScreens.CartScreen
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/58812?treeId=14&search=W3siaWQiOiJtZW1iZXIiLCJ0eXBlIjoic3RyaW5nQXJyYXkiLCJ2YWx1ZSI6WyJhbGlldmEuZSJdfV0%3D

class CartElementTest : DefaultTest(
    "UAE.Mobile.Android.Оформление заказа.Корзина.Отображение миникарточек в корзине неавторизованного клиента"
) {
    @Test
    @AllureId("58723")
    @Step(
        "UAE.Mobile.Android.Оформление заказа.Корзина.Отображение миникарточек в корзине неавторизованного клиента"
    )
    fun authTest_58723() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Оформление заказа.Корзина") {
            scenario(AddItemToCartScenario())
            CartScreen {
                checkImage()
                checkBrandName()
                checkProductName()
                checkFavorite()
                checkPrice()
                checkMinus()
                checkPlus()
                checkTrashButton()
                checkContinueButton()
            }
        }
    }
}
