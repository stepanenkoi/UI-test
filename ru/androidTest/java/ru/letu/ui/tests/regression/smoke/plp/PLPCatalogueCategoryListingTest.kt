package ru.letu.ui.tests.regression.smoke.plp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.CatalogScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.PerfumeryCategoryScreen

class PLPCatalogueCategoryListingTest : DefaultTest(
    "Mobile. Android. PLP каталога. Листинг категории. Состав листинга"

) {
    @Test
    @AllureId("26773")
    @Step("Mobile. Android. PLP каталога. Листинг категории. Состав листинга")
    fun plpCatalogueCategoryListingTest_26773() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. PLP каталога. Листинг категории. Состав листинга") {
            Navigation.openCatalog()
            CatalogScreen.clickCatalogPerfumery()
            PerfumeryCategoryScreen.assertPerfumeryCategoryScreenOpen()
        }
    }
}
