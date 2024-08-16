package oasis.letu.tests.cartTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.AddItemToCartScenario
import oasis.letu.screens.сartScreens.CartScreen
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/58813?treeId=14&search=W3siaWQiOiJjZi4yNiIsInR5cGUiOiJsb25nQXJyYXkiLCJ2YWx1ZSI6WzcwNDVdfV0%3D
// https://testops.letoile.tech/project/2/test-cases/58702?treeId=14&search=W3siaWQiOiJjZi4yNiIsInR5cGUiOiJsb25nQXJyYXkiLCJ2YWx1ZSI6WzcwNDVdfV0%3D
class CounterCartTest : DefaultTest(
    "UAE.Mobile.Android.Оформление заказа.Корзина.Отработка каунтера в таббаре авторизованного клиента"
) {
    @Test
    @AllureId("58702")
    @Step("UAE.Mobile.Android.Оформление заказа.Корзина.Отработка каунтера в таббаре авторизованного клиента")
    fun authTest_58702() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Оформление заказа.Корзина.") {
            scenario(AddItemToCartScenario())
            CartScreen {
                checkNumberInCounter("1")
                clickPlus()
                checkNumberInCounter("2")
                clickMinus()
                checkNumberInCounter("1")
                clickMinus()
                assertEmptyCartOpen()
            }
        }
    }
}
