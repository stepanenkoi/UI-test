package oasis.letu.tests.catalogTests.plpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.helper.TestUtils.sleep
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class CheckAddToCartFromPLP : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP. Нажатие на кнопку Add to Cart в карточке товара " +
        "(1 sku) и переход в Корзину таббар"
) {
    @Test
    @AllureId("59899")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP. Нажатие на кнопку Add to Cart в карточке товара " +
            "(1 sku) и переход в Корзину таббар"
    )
    fun authTest_59899() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на экран plp") {
            scenario(GoToPLPScenario())
            Thread.sleep(3000)
            PLPScreen {
                sleep(3000)
                AddToCart1()
            }
            BottomNavigation.openCart()
        }
    }
}
