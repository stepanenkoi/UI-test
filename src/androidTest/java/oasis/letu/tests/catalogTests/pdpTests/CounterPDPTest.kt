package oasis.letu.tests.catalogTests.pdpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.сatalogScreens.PDPScreen
import org.junit.Test

class CounterPDPTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP. PDP. Работа каунтера колличества добавленного товара в корзину"
) {
    @Test
    @AllureId("58823")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP. PDP.Работа каунтера колличества добавленного товара в корзину"
    )
    fun authTest_58823() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        PDPScreen {
            getPdp()
            Thread.sleep(5000) // нужно для подгрузки PDP без него не скролится
            scrollToBottom()
            clickAddToCartButton()
            checkCounter()
            check1InCounter()
            clickPlus()
            check2InCounter()
            clickMinus()
            check1InCounter()
            clickMinus()
            checkAddToCartButton()
        }
    }
}
