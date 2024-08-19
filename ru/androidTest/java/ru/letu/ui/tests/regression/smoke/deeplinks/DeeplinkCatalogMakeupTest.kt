package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.core_resources.R
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.TestUtils
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_CATALOG_MAKEUP
import ru.letu.ui.screens.CatalogScreen.assertCatalogCategoryOpen

class DeeplinkCatalogMakeupTest : DefaultTest(
    "Проверка Deeplinks. Каталог. Макияж"
) {
    @Test
    @AllureId("63725")
    @Step("Проверка Deeplinks. Каталог. Макияж")
    fun deeplinkCatalogMakeupTest_63725() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Каталог. Макияж") {
            featureRouter.open(DEEPLINK_CATALOG_MAKEUP)
            flakySafely(WAIT_TIME) {
                assertCatalogCategoryOpen(TestUtils.getString(R.string.makeup_category_title))
            }
        }
    }
}
