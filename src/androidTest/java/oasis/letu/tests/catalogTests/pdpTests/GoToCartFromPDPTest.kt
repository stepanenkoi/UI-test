package oasis.letu.tests.catalogTests.pdpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.сartScreens.CartScreen
import oasis.letu.screens.сatalogScreens.PDPScreen
import org.junit.Test

class GoToCartFromPDPTest : DefaultTest(
    "UAE. Mobile. Android. PDP.Переход в корзину из PDP"
) {
    @Test
    @AllureId("63482")
    @Step(
        "UAE. Mobile. Android. PDP.Переход в корзину из PDP"
    )
    fun authTest_63482() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        PDPScreen {
            getPdp()
            Thread.sleep(5000) // нужно для подгрузки PDP без него не скролится
            scrollToBottom()
            clickAddToCartButton()
            clickCounter()
        }
        CartScreen {
            assertCartOpen()
        }
    }
}
