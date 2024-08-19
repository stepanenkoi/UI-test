package ru.letu.ui.tests.regression.smoke.servicecases

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.dialogscreen.PermissionDialogUiScreen
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.core_resources.R as RCoreResources

class PermissionToAccessCameraPositiveTest : DefaultTest(
    "Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Открытие камеры"
) {
    @Test
    @AllureId("63119")
    @Step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Открытие камеры")
    fun searchAddToCartTest_63119() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Открытие камеры") {
            Navigation.openBottomMenu()
            ToolBarElementScreen.clickSearchBtn()
            SuggestionScreen.clickBarcodeBtn()
            PermissionDialogUiScreen.clickAllowPermission()
            ToolBarElementScreen.assertTitleToolBar(RCoreResources.string.app_scan_code)
        }
    }
}
