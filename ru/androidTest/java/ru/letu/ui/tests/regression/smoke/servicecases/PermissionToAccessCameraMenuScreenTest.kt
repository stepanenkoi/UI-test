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

class PermissionToAccessCameraMenuScreenTest : DefaultTest(
    "Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Меню"
) {
    @Test
    @AllureId("63118")
    @Step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Меню")
    fun permissionToAccessCameraMenuTest_63118() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Меню") {
            Navigation.openBottomMenu()
            ToolBarElementScreen.clickSearchBtn()
            SuggestionScreen.clickBarcodeBtn()
            PermissionDialogUiScreen.clickDenyPermission()
        }
    }
}
