package ru.letu.ui.tests.regression.smoke.servicecases

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.HomeScreen
import ru.letu.ui.screens.dialogscreen.PermissionDialogUiScreen

class PermissionToAccessCameraHomeScreenTest : DefaultTest(
    "Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Главный экран"
) {
    @Test
    @AllureId("63104")
    @Step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Главный экран")
    fun permissionToAccessCameraHomeTest_63104() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Главный экран") {
            HomeScreen.assertHomeScreenOpen()
            HomeScreen.HomeUiScreen.clickBarcodeBtn()
            PermissionDialogUiScreen.clickDenyPermission()
        }
    }
}
