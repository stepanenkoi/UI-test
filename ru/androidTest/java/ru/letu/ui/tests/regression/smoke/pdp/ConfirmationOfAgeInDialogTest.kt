package ru.letu.ui.tests.regression.smoke.pdp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils
import ru.letu.ui.screens.dialogscreen.AdultsDialogUiScreen
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.SEARCH_QUERY_18

class ConfirmationOfAgeInDialogTest : DefaultTest(
    "Mobile. Android. PDP 18+. Подтверждение возраста в диалоге"
) {
    @Test
    @AllureId("50426")
    @Step("Mobile. Android. PDP 18+. Подтверждение возраста в диалоге")
    fun confirmationOfAgeInDialogTest_50426() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. PDP 18+. Подтверждение возраста в диалоге") {
            SuggestionScreen.openSearchResults(SEARCH_QUERY_18)
            AdultsDialogUiScreen {
                assertAdultsDialogOpen()
                clickAgreeAdults()
            }
            TestUtils.closeApp()
        }
    }
}
