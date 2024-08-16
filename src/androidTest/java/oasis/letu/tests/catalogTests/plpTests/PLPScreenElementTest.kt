package oasis.letu.tests.catalogTests.plpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class PLPScreenElementTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP. Проверка соответствия макетам экрана PLP"
) {
    @Test
    @AllureId("57911")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP. Проверка соответствия макетам экрана PLP"
    )
    fun authTest_57911() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на экран plp") {
            scenario(GoToPLPScenario())
            PLPScreen {
                checkTag1()
                checkSort()
                checkFilter()
                checkImage1()
                checkFavorite()
                checkName1()
                checkBrandName1()
              //  checkUnvaible1()
                checkPrice1()
                checkAddToCart1()
            }
        }
    }
}
