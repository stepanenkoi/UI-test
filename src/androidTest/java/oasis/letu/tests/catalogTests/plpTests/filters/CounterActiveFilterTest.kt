package oasis.letu.tests.catalogTests.plpTests.filters

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.helper.TestUtils.clickText
import oasis.letu.helper.TestUtils.sleep
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.сatalogScreens.FilterScreen
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class CounterActiveFilterTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры.Проверка изменения счетчиков фильтра"
) {
    @Test
    @AllureId("64618")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры.Проверка изменения счетчиков фильтра"
    )
    fun authTest_64618() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на экран plp") {
            scenario(GoToPLPScenario())
            PLPScreen {
                checkNumberOfFilters1()
                clickFilter()
            }
            FilterScreen {
                clickAllButton()
                clickBrandName1()
                clickApplyBrandButton()
                clickText("Apply") // костыль из за того что не находит по id
            }
            PLPScreen {
                checkNumberOfFilters2()
                clickFilter()
            }
            FilterScreen {
                clickClear()
                clickApplyBrandButton()
            }
            PLPScreen{
                checkNumberOfFilters1()
            }
        }
    }
}
