package oasis.letu.tests.catalogTests.plpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.helper.TestUtils.sleep
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class PLPSortTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.PLP.Сортировка. Отображение страницы при выборе сортировки"
) {
    @Test
    @AllureId("57062")
    @Step(
        "UAE.Mobile.Android.Каталог.PLP.Сортировка. Отображение страницы при выборе сортировки"
    )
    fun authTest_57062() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на экран plp") {
            scenario(GoToPLPScenario())
            PLPScreen {
                openSortMenu()
                checkSort1()
                checkSort2()
                checkSort3()
                clickSort1()
                sleep(3000)
                sortByLowerPrice()
                openSortMenu()
                clickSort2()
                sleep(3000)
                sortByHigherPrice()
                openSortMenu()
                clickSort3()
                sleep(3000)
                sortByAlphabetical()
            }
        }
    }
}
