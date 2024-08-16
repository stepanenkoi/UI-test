package oasis.letu.tests.catalogTests.plpTests.filters

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.GoToPLPScenario
import oasis.letu.screens.сatalogScreens.FilterScreen
import oasis.letu.screens.сatalogScreens.PLPScreen
import org.junit.Test

class FilterScreenElementTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры. Проверка соответствия макетам экрана с фильтрами"
) {
    @Test
    @AllureId("57912")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP.Фильтры. Проверка соответствия макетам экрана с фильтрами"
    )
    fun authTest_57912() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на экран plp") {
            scenario(GoToPLPScenario())
            PLPScreen {
                clickFilter()
            }
            FilterScreen {
                checkFacetName1()
                checkRadioButton1()
                checkButton1Chosen()
                checkFacetName2()
                checkRadioButton2()
                checkPriceTitel()
                checkMinPrice()
                checkMaxPrice()
                checkSlider()
                checkBrandTitle()
                checkAllButton()
                checkApplyButton()
                clickAllButton()
                checkSearchField()
                checkTagA()
                checkTagB()
                checkBrandCheckbox1()
                checkBrandName1()
                checkBrandCheckbox2()
                checkBrandName2()
            }
        }
    }
}
