package oasis.letu.tests.cartTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.BottomNavigation.openEmptyCart
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/60321?treeId=14&search=W3siaWQiOiJtZW1iZXIiLCJ0eXBlIjoic3RyaW5nQXJyYXkiLCJ2YWx1ZSI6WyJhbGlldmEuZSJdfV0%3D
class EmptyCartElementTest :
    DefaultTest(
        "UAE.Mobile.Android.Оформление заказа.Корзина. Проверка на соответствие с макетом пустая корзина"
    ) {
    @Test
    @AllureId("60321")
    @Step("UAE.Mobile.Android.Оформление заказа.Корзина. Проверка на соответствие с макетом пустая корзина")
    fun authTest_60321() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        Thread.sleep(5000)
        openEmptyCart()
    }
}
