package ru.letu.ui.screens.elements

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.ui.screens.dialogscreen.PermissionDialogUiScreen

object SearchUiScreen : UiScreen<SearchUiScreen>() {
    override val packageName: String = "ru.letu.preprod"

    private val barcodeBtn = UiView {
        withId(this@SearchUiScreen.packageName, "barcode")
        withClassName("android.widget.ImageView")
    }

    fun clickBarcodeBtn() {
        step("Нажать на кнопку сканирования штрихкода. Разрешения нет") {
            barcodeBtn.click()
            PermissionDialogUiScreen.assertPermissionDialogOpen()
            assertBarcodeBtnDisplayed()
        }
    }

    private fun assertBarcodeBtnDisplayed() {
        step("Кнопка сканирования штрихкода отображается") {
            barcodeBtn.isDisplayed()
        }
    }
}
