package ru.letu.ui.tests.regression.smoke.search

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_ERROR

class SearchErrorTest : DefaultTest(
    "Mobile.Android. Поиск по запросу с грамматической ошибкой нулевой поиск изменить слово"
) {
    @Test
    @AllureId("51962")
    @Step("Mobile.Android. Поиск по запросу с грамматической ошибкой нулевой поиск изменить слово")
    fun searchErrorTest_51962() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android. Поиск по запросу с грамматической ошибкой нулевой поиск изменить слово") {
            SuggestionScreen {
                openSearchResults(SEARCH_QUERY_ERROR)
                assertSearchQueryFound(SEARCH_QUERY_ERROR)
            }
        }
    }
}
