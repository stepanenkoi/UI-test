package oasis.letu.tests.catalogTests.plpTests.filters

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.сatalogScreens.FilterScreen
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class MinMaxPriceTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры. Фильтры. Валидация ввода в фильтрах о цене"
) {
    @Test
    @AllureId("56978")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры. Фильтры. Валидация ввода в фильтрах о цене"
    )
    fun authTest_56978() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на экран plp") {
            scenario(GoToPLPScenario())
            PLPScreen {
                clickFilter()
            }
            FilterScreen {
                enterMinPrice()
                enterMaxPrice()
            }
        }
    }
}
