package ru.letu.ui.tests.regression.search

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_BRAND

class SearchNavigationByHintTest : DefaultTest(
    "Mobile.Android.Главная.Поиск.Поисковые подсказки.Переход по подсказке"
) {
    @Test
    @AllureId("46369")
    @Step("Mobile.Android.Главная.Поиск.Поисковые подсказки.Переход по подсказке")
    fun searchNavigationByHintTest_46369() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Главная.Поиск.Поисковые подсказки.Переход по подсказке") {
            SuggestionScreen {
                openSuggestionScreen()
                replaceTextSearchInput(SEARCH_QUERY_BRAND)
                clickSearchSuggestionByIndex(0)
            }
        }
    }
}
