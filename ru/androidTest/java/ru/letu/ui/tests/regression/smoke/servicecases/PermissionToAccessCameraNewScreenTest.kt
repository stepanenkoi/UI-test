package ru.letu.ui.tests.regression.smoke.servicecases

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.HomeScreen
import ru.letu.ui.screens.dialogscreen.PermissionDialogUiScreen
import ru.letu.ui.screens.elements.SearchUiScreen
import ru.letu.core_resources.R as RCoreResources

class PermissionToAccessCameraNewScreenTest : DefaultTest(
    "Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран Новинки"
) {
    @Test
    @AllureId("63103")
    @Step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран Новинки")
    fun permissionToAccessCameraNewTest_631031() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Служебные кейсы. Разрешение на доступ к камере. Экран Новинки") {
            HomeScreen.assertHomeScreenOpen()
            HomeScreen.HomeUiScreen.scrollToRecyclerSections()
            HomeScreen.HomeUiScreen.clickEndeca()
            HomeScreen.clickShowAllBtn(RCoreResources.string.new_items)
            SearchUiScreen.clickBarcodeBtn()
            PermissionDialogUiScreen.clickDenyPermission()
        }
    }
}
