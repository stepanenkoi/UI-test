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

class PermissionToAccessCameraFavoriteScreenTest : DefaultTest(
    "Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран Избранное"
) {
    @Test
    @AllureId("63117")
    @Step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран Избранно")
    fun permissionToAccessCameraFavoriteTest_63117() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран Избранно") {
            Navigation.openFavorite()
            ToolBarElementScreen.clickSearchBtn()
            SuggestionScreen.clickBarcodeBtn()
            PermissionDialogUiScreen.clickDenyPermission()
        }
    }
}
