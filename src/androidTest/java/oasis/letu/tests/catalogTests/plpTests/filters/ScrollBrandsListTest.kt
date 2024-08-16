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

class ScrollBrandsListTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры.Бренды.Скролл списка брендов"
) {
    @Test
    @AllureId("64620")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры.Бренды.Скролл списка брендов"
    )
    fun authTest_64620() {
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
                scrollToDown()
                sleep(1000)
                scrollToUp()
            }
        }
    }
}
