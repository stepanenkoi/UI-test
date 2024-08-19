package ru.letu.ui.tests.regression.smoke.plp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.base.FeatureUiToggles
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_BRAND_NARS
import ru.letu.ui.screens.PLPScreen
import ru.letu.ui.screens.bottomsheet.SortPlpBottomSheetScreen

class PLPSortByAscendingPriceTest : DefaultTest(
    "Mobile. Android. PLP каталога. Листинг категории. Состав листинга",
    runBeforeBlock = { FeatureUiToggles.enable("plp_mob_cartridges_brand_toggle") }

) {
    @Test
    @AllureId("26773")
    @Step("Mobile. Android. PLP каталога. Листинг категории. Состав листинга")
    fun plpCatalogueCategoryListingTest_26773() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. PLP каталога. Листинг категории. Состав листинга") {
            PLPScreen {
                openPLPByDeeplink(DEEPLINK_BRAND_NARS)
                clickSortButtonPlp()
            }
            SortPlpBottomSheetScreen.clickSortingPriceAsc()
        }
    }
}
