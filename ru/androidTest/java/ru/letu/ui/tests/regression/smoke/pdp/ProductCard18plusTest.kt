package ru.letu.ui.tests.regression.smoke.pdp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils.closeApp
import ru.letu.ui.screens.dialogscreen.AdultsDialogUiScreen
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_18

class ProductCard18plusTest : DefaultTest(
    "Mobile.Android.PDP. 18+. Переход, отображение карточки товара"
) {
    @Test
    @AllureId("26772")
    @Step("Mobile.Android.PDP. 18+. Переход, отображение карточки товара")
    fun productCard18plusTest_26772() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.PDP. 18+. Переход, отображение карточки товара") {
            SuggestionScreen {
                openSuggestionScreen()
                replaceTextSearchInput(SEARCH_QUERY_18)
            }
            flakySafely {
                SuggestionScreen.clickTextSearchInput(SEARCH_QUERY_18)
            }
            AdultsDialogUiScreen {
                assertAdultsDialogOpen()
                closeAdultsDialogTouchOutside()
            }
            SuggestionScreen.clickAdultsBlurProduct()
            AdultsDialogUiScreen.clickAgreeAdults()
            closeApp()
        }
    }
}
