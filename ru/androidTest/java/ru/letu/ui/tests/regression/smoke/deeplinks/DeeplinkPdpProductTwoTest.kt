package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_PDP_TWO
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

class DeeplinkPdpProductTwoTest : DefaultTest(
    "Проверка Deeplinks. PDP"
) {
    @Test
    @AllureId("64012")
    @Step("Проверка Deeplinks. PDP")
    fun deeplinkPdpProductTwoTest_64012() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. PDP") {
            featureRouter.open(DEEPLINK_PDP_TWO)
            SpecifyAddressDialogScreen.assertSpecifyAddressDialogDisplayed()
            SpecifyAddressDialogScreen.clickNegativeBtn()
        }
    }
}
