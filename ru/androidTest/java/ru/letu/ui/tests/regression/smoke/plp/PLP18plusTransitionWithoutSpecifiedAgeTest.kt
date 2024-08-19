package ru.letu.ui.tests.regression.smoke.plp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils.closeApp
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_18
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.screens.dialogscreen.AdultsDialogUiScreen

class PLP18plusTransitionWithoutSpecifiedAgeTest : DefaultTest(
    "PLP 18+. Листинг категории. Переход пользователя без указанного возраста или анонима"

) {
    @Test
    @AllureId("51038")
    @Step("PLP 18+. Листинг категории. Переход пользователя без указанного возраста или анонима")
    fun plp18plusTransWithoutSpecAgeTest_51038() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("PLP 18+. Листинг категории. Переход пользователя без указанного возраста или анонима") {
            SuggestionScreen.openSearchResults(SEARCH_QUERY_18)
            AdultsDialogUiScreen {
                assertAdultsDialogOpen()
                closeAdultsDialogTouchOutside()
            }
            closeApp()
        }
    }
}
