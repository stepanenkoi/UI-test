package ru.letu.ui.tests.regression.smoke.search

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_ONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_RESULT
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.screens.SuggestionScreen.assertSearchResults

class SearchByPhraseTest : DefaultTest(
    "Mobile. Android.Главная.Поиск.Поиск по словосочетанию"
) {
    @Test
    @AllureId("51961")
    @Step("Mobile. Android.Главная.Поиск.Поиск по словосочетанию")
    fun searchByPhraseTest_51961() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android.Главная.Поиск.Поиск по словосочетаниюд") {
            SuggestionScreen {
                openSuggestionScreen()
                replaceTextSearchInput(SEARCH_QUERY_ONE)
                clickTextSearchInput(SEARCH_QUERY_ONE)
            }
            flakySafely(LONG_WAIT_TIME) { assertSearchResults(SEARCH_RESULT) }
        }
    }
}
