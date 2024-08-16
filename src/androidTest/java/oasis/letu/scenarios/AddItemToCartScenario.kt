package oasis.letu.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import oasis.letu.helper.TestUtils.sleep
import oasis.letu.screens.сatalogScreens.PDPScreen

class AddItemToCartScenario : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Добавить товар в корзину и перейти в корзину") {

            PDPScreen {
                getPdp()
                sleep(6000)
                scrollToBottom()
                clickAddToCartButton()
                clickCounter()
            }
        }
    }
}
