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

class PermissionToAccessCameraCatalogScreenTest : DefaultTest(
    "Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Каталог"
) {
    @Test
    @AllureId("63105")
    @Step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Каталог")
    fun permissionToAccessCameraCatalogTest_63105() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Каталог") {
            Navigation.openCatalog()
            ToolBarElementScreen.clickSearchBtn()
            SuggestionScreen.clickBarcodeBtn()
            PermissionDialogUiScreen.clickDenyPermission()
        }
    }
}
