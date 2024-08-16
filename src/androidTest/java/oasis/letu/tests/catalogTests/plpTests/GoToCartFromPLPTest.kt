package oasis.letu.tests.catalogTests.plpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.сartScreens.CartScreen
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class GoToCartFromPLPTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP. Нажатие на кнопку Add to Cart в карточке товара" +
        " (1 sku) и переход в Корзину через кнопку In the Cart"
) {
    @Test
    @AllureId("59898")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP. Нажатие на кнопку Add to Cart в карточке товара" +
            " (1 sku) и переход в Корзину через кнопку In the Cart"
    )
    fun authTest_59898() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на экран plp") {
            scenario(GoToPLPScenario())
            Thread.sleep(3000)
            PLPScreen {
                GoToCart()
            }
            CartScreen {
                assertCartOpen()
            }
        }
    }
}
