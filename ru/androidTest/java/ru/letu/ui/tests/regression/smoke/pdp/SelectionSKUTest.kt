package ru.letu.ui.tests.regression.smoke.pdp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.base.FeatureUiToggles
import ru.letu.ui.helpers.utils.testdata.TestConst.PRODUCT_SKU_ID
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.ReviewGalleryScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

class SelectionSKUTest : DefaultTest(
    "Выбор SKU.Модалка списка с новым отображением sku. Свотчи в виде кружков)",
    runBeforeBlock = { FeatureUiToggles.enable("new_sku_design_toggle") }
) {
    @Test
    @AllureId("54533")
    @Step("Выбор SKU.Модалка списка с новым отображением sku. Свотчи в виде кружков")
    fun selectionSKUTest_54533() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Выбор SKU.Модалка списка с новым отображением sku. Свотчи в виде кружков") {
            PDPScreen.openPDP(PRODUCT_SKU_ID)
            SpecifyAddressDialogScreen.clickNegativeBtn()
            ReviewGalleryScreen.clickOpenMoreBtn()
        }
    }
}
