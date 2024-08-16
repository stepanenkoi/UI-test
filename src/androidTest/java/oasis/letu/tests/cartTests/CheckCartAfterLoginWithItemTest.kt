package oasis.letu.tests.cartTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.LoginScenario
import oasis.letu.screens.navigation.BottomNavigation
import org.junit.Test

// https://testops.letoile.tech/project/2/test-cases/60322?treeId=14&search=W3siaWQiOiJtZW1iZXIiLCJ0eXBlIjoic3RyaW5nQXJyYXkiLCJ2YWx1ZSI6WyJhbGlldmEuZSJdfV0%3D

class CheckCartAfterLoginWithItemTest : DefaultTest(
    "UAE.Mobile.Android.Оформление заказа.Корзина.Авторизация в аккаунт с наполненной корзиной"
) {
    @Test
    @AllureId("60322")
    @Step(
        "UAE.Mobile.Android.Оформление заказа.Корзина.Авторизация в аккаунт с наполненной корзиной"
    )
    fun authTest_60322() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
            BottomNavigation.openEmptyCart()
        scenario(LoginScenario())
        BottomNavigation.openCart()
        }
    }
