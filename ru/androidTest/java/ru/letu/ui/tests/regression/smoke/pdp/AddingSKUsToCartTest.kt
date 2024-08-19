package ru.letu.ui.tests.regression.smoke.pdp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.ReviewGalleryScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.PRODUCT_ID

class AddingSKUsToCartTest : DefaultTest(
    "Mobile. Android. PDP. Добавление SKU в корзину"
) {
    @Test
    @AllureId("26770")
    @Step("Mobile. Android. PDP. Добавление SKU в корзинун")
    fun addingSKUsToCartTest_26770() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. PDP. Добавление SKU в корзину") {
            PDPScreen.openPDP(PRODUCT_ID)
            SpecifyAddressDialogScreen.clickNegativeBtn()
            ReviewGalleryScreen.clickAddToCart()
        }
    }
}
