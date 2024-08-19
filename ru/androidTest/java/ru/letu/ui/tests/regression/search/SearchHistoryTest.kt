package ru.letu.ui.tests.regression.search

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_THREE

class SearchHistoryTest : DefaultTest(
    "История не подменяется подсказками при повторном переходе"
) {
    @Test
    @AllureId("42565")
    @Step("История не подменяется подсказками при повторном переходе")
    fun searchHistoryTest_42565() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("История не подменяется подсказками при повторном переходе") {
            SuggestionScreen {
                openSuggestionScreen()
                replaceTextSearchInput(SEARCH_QUERY_THREE)
                clickTextSearchInput(SEARCH_QUERY_THREE)
                openSuggestionHistoryScreen(SEARCH_QUERY_THREE)
            }
        }
    }
}
