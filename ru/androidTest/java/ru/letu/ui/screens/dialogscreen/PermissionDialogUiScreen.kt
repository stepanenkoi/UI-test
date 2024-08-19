package ru.letu.ui.screens.dialogscreen

import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.qameta.allure.kotlin.Allure.step

object PermissionDialogUiScreen : UiScreen<PermissionDialogUiScreen>() {
    override val packageName: String = "com.google.android.permissioncontroller"

    private val permissionMessage = UiTextView {
        withId(this@PermissionDialogUiScreen.packageName, "permission_message")
        withClassName("android.widget.TextView")
    }

    private val denyBtn = UiButton {
        withText("Deny")
        withClassName("android.widget.Button")
    }

    private val allowBtn = UiButton {
        withText("Allow")
        withClassName("android.widget.Button")
    }

    fun assertPermissionDialogOpen() {
        step("Диалог разрешения открыт") {
            denyBtn.isDisplayed()
        }
    }

    fun assertPermissionMessage(text: String) {
        step("Диалог разрешения с текстом $text открыт") {
            permissionMessage.hasText(text)
        }
    }

    fun clickDenyPermission() {
        step("Нажать Deny") {
            denyBtn.click()
        }
    }

    fun clickAllowPermission() {
        step("Нажать Allow") {
            allowBtn.click()
        }
    }
}
