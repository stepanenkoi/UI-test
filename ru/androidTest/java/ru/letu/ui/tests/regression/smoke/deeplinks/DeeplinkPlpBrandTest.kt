package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils.getString
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_BRAND_NARS
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.core_resources.R as RCoreResources

class DeeplinkPlpBrandTest : DefaultTest(
    "Проверка Deeplinks. PLP бренда NARS"
) {
    @Test
    @AllureId("63719")
    @Step("Проверка Deeplinks. PLP бренда NARS")
    fun deeplinkPlpBrandTest_63719() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. PLP бренда NARS") {
            featureRouter.open(DEEPLINK_BRAND_NARS)
            SuggestionScreen.assertBrandScreenOpen(getString(RCoreResources.string.nars_brand_text))
        }
    }
}
