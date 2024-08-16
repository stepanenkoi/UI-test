package oasis.letu.tests.catalogTests.plpTests.filters

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.helper.TestUtils.sleep
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.сatalogScreens.FilterScreen
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class NumberOfActiveFilterTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры. Сохранение фильтров при изменении уровня категории"
) {
    @Test
    @AllureId("56972")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры. Сохранение фильтров при изменении уровня категории"
    )
    fun authTest_56972() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на экран plp") {
            scenario(GoToPLPScenario())
            PLPScreen {
                clickFilter()
            }
            FilterScreen {
                clickAllButton()
                enterKenzo()
                sleep(2000)
                clickBrandName1()
                clickApplyBrandButton()
                clickApplyButton()
            }
            PLPScreen {
                checkNumberOfFilters2()
                clickTag2()
                checkNumberOfFilters2()
            }
        }
    }
}
