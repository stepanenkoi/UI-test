package ru.letu.ui.tests.regression.search

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_TWO

class SearchAddToCartTest : DefaultTest(
    "Mobile.Android.Поиск. Добавление товара в корзину"
) {
    @Test
    @AllureId("50131")
    @Step("Mobile.Android.Поиск. Добавление товара в корзину")
    fun searchAddToCartTest_50131() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Поиск. Добавление товара в корзину") {
            SuggestionScreen {
                openSearchResults(SEARCH_QUERY_TWO)
                clickAddToCart("1")
            }
        }
    }
}
