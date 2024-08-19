package ru.letu.ui.tests.regression.smoke.servicecases

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen
import ru.letu.ui.screens.dialogscreen.PermissionDialogUiScreen
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.helpers.utils.testdata.TestConst.PRODUCT_ID

class PermissionToAccessCameraPLPScreenTest : DefaultTest(
    "Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран PLP"
) {
    @Test
    @AllureId("63107")
    @Step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран PLP")
    fun permissionToAccessCameraPLPTest_63107() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран PLP") {
            PDPScreen.openPDP(PRODUCT_ID)
            SpecifyAddressDialogScreen.clickNegativeBtn()
            ToolBarElementScreen.clickSearchBtn()
            SuggestionScreen.clickBarcodeBtn()
            PermissionDialogUiScreen.clickDenyPermission()
        }
    }
}
