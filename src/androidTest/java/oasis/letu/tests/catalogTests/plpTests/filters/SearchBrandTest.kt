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

class SearchBrandTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры. Фильтры. Работа поля поиска по бренду"
) {
    @Test
    @AllureId("56981")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры. Фильтры. Работа поля поиска по бренду"
    )
    fun authTest_56981() {
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
                checkKenzoBrandName1()
                sleep(2000)
                clearField()
                scrollToUp()
                enterDolce()
                checkDGBrandName1()
                checkDMBrandName2()
            }
        }
    }
}
