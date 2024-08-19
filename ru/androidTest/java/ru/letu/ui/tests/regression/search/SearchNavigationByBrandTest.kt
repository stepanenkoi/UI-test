package ru.letu.ui.tests.regression.search

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.BRAND_MAC
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_BRAND

class SearchNavigationByBrandTest : DefaultTest(
    "Mobile.Android.Главная.Поиск.Поисковые подсказки.Переход по бренду"
) {
    @Test
    @AllureId("46367")
    @Step("Mobile.Android.Главная.Поиск.Поисковые подсказки.Переход по бренду")
    fun searchNavigationByBrandTest_46367() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Главная.Поиск.Поисковые подсказки.Переход по бренду") {
            SuggestionScreen {
                openSuggestionScreen()
                replaceTextSearchInput(SEARCH_QUERY_BRAND)
                assertSearchBrandIsDisplayed(BRAND_MAC)
                clickSearchSuggestionBrand(BRAND_MAC)
            }
        }
    }
}
