package oasis.letu.tests.cartTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.сartScreens.CartScreen
import oasis.letu.screens.navigation.BottomNavigation
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/58700?treeId=14&search=W3siaWQiOiJtZW1iZXIiLCJ0eXBlIjoic3RyaW5nQXJyYXkiLCJ2YWx1ZSI6WyJhbGlldmEuZSJdfV0%3D

class GoToCatalogFromEmptyCart :
    DefaultTest(
        "UAE.Mobile.Android.Оформление заказа.Корзина.Переход на экран пустой корзины авторизованный клиент"
    ) {
    @Test
    @AllureId("58700")
    @Step("UAE.Mobile.Android.Оформление заказа.Корзина.Переход на экран пустой корзины авторизованный клиент")
    fun authTest_58700() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        BottomNavigation.openEmptyCart()
        CartScreen {
            clickCatalogButton()
        }
    }
}
