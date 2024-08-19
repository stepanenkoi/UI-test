package ru.letu.ui.tests.regression.smoke.pdp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.core_resources.R
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.PRODUCT_SKU_SWITCH_ID
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

class SwitchingSKUsTest : DefaultTest(
    "Mobile.Android.PDP.Выбор SKU"
) {
    @Test
    @AllureId("54533")
    @Step("Mobile.Android.PDP.Выбор SKU")
    fun switchingSKUTest_46565() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.PDP.Выбор SKU") {
            PDPScreen.openPDP(PRODUCT_SKU_SWITCH_ID)
            SpecifyAddressDialogScreen.clickNegativeBtn()
            PDPScreen.assertPriceSKUSelected(R.string.sku_one_hundred_ml)
            PDPScreen.assertPriceSKUSelected(R.string.sku_thirty_ml)
            PDPScreen.assertPriceSKUSelected(R.string.sku_fifty_ml)
        }
    }
}
