package ru.letu.ui.tests.regression.search

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils.closeApp
import ru.letu.ui.screens.dialogscreen.AdultsDialogUiScreen
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_18

class SearchGoToProductsAgeNotConfirmedTest : DefaultTest(
    "Переход на товары 18+ возраст не подтверждён"
) {
    @Test
    @AllureId("46365")
    @Step("Переход на товары 18+ возраст не подтверждён")
    fun searchGoToProductsAgeNotConfirmedTest_46365() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Переход на товары 18+ возраст не подтверждён") {
            SuggestionScreen {
                openSuggestionScreen()
                replaceTextSearchInput(SEARCH_QUERY_18)
                clickTextSearchInput(SEARCH_QUERY_18)
            }
            AdultsDialogUiScreen {
                assertAdultsDialogOpen()
                closeAdultsDialogTouchOutside()
            }
            SuggestionScreen.clickAdultsBlurProduct()
            closeApp()
        }
    }
}
