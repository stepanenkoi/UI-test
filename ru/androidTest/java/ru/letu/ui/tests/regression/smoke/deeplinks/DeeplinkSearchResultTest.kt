package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils.getString
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_SEARCH_RESULT_MASCARA
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.core_resources.R as RCoreResources

class DeeplinkSearchResultTest : DefaultTest(
    "Проверка Deeplinks. Результаты поиска - тушь"
) {
    @Test
    @AllureId("63747")
    @Step("Проверка Deeplinks. Результаты поиска - тушь")
    fun deeplinkSearchResultTest_63719() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Результаты поиска - тушь") {
            featureRouter.open(DEEPLINK_SEARCH_RESULT_MASCARA)
            SuggestionScreen {
                assertSearchResults(getString(RCoreResources.string.mascara_text))
                assertSearchResultDisplayed()
            }
        }
    }
}
