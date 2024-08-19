package ru.letu.ui.tests.regression.search

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_PART_OF_REQUEST

class SearchAllResultsTest : DefaultTest(
    "Переход по результату Все результаты поиска"
) {
    @Test
    @AllureId("46371")
    @Step("Переход по результату Все результаты поиска")
    fun searchAllResultsTest_46371() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход по результату Все результаты поиска") {
            SuggestionScreen {
                openSuggestionScreen()
                replaceTextSearchInput(SEARCH_PART_OF_REQUEST)
                assertSearchAllResultsIsDisplayed()
                clickSearchSuggestionAll()
            }
        }
    }
}
