package ru.letu.ui.tests.regression.smoke.pdp

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen
import ru.letu.ui.screens.dialogscreen.AdultsDialogUiScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.PRODUCT_ID_18

class CompositionOfProductCardPDP18Test : DefaultTest(
    "Mobile. Android. PDP 18+. Состав карточки товара"
) {
    @Test
    @AllureId("50425")
    @Step("Mobile. Android. PDP 18+. Состав карточки товара")
    fun productCardPDP18Test_50425() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. PDP 18+. Состав карточки товара") {
            PDPScreen.openPDP(PRODUCT_ID_18)
            AdultsDialogUiScreen {
                assertAdultsDialogOpen()
                clickAgreeAdultsPDP()
            }
            SpecifyAddressDialogScreen.clickNegativeBtn()
            PDPScreen.assertPDPOpen()
        }
    }
}
