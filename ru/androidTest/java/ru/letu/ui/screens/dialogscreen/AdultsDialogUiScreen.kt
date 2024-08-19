package ru.letu.ui.screens.dialogscreen

import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.ui.helpers.TestUtils.clickTouchOutside
import ru.letu.ui.helpers.TestUtils.getString
import ru.letu.ui.screens.SuggestionScreen.SuggestionUiScreen.assertProductIsBlur
import ru.letu.ui.screens.SuggestionScreen.SuggestionUiScreen.assertProductIsNotBlur
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen
import ru.letu.core_resources.R as RCoreResources

object AdultsDialogUiScreen : UiScreen<AdultsDialogUiScreen>() {
    override val packageName: String = "ru.letu.preprod"

    private val adultsTitle = UiTextView {
        withText(getString(RCoreResources.string.plp_adults_title))
        withClassName("android.widget.TextView")
    }

    private val adultsInfo = UiTextView {
        withText(getString(RCoreResources.string.plp_adult_info))
        withClassName("android.widget.TextView")
    }

    private val adultsAgree = UiTextView {
        withId(this@AdultsDialogUiScreen.packageName, "btnOk")
        withText(getString(RCoreResources.string.plp_agree_adults))
        withClassName("android.widget.TextView")
    }

    private val adultsDisagree = UiTextView {
        withId(this@AdultsDialogUiScreen.packageName, "btnCancel")
        withText(getString(RCoreResources.string.plp_disagree_adults))
        withClassName("android.widget.TextView")
    }

    fun closeAdultsDialogTouchOutside() {
        step("Закрыть диалог кликом в пустое пространство") {
            clickTouchOutside(10, 2)
            assertProductIsBlur()
        }
    }

    fun clickDisagreeAdults() {
        step("НЕТ, Я МОЛОЖЕ 18 ЛЕТ") {
            adultsDisagree.click()
            assertProductIsBlur()
        }
    }

    fun clickAgreeAdults() {
        step("Нажать ДА, Я СТАРШЕ 18 ЛЕТ") {
            adultsAgree.click()
            assertProductIsNotBlur()
        }
    }

    fun clickAgreeAdultsPDP() {
        step("Нажать ДА, Я СТАРШЕ 18 ЛЕТ") {
            adultsAgree.click()
            SpecifyAddressDialogScreen.assertSpecifyAddressDialogDisplayed()
        }
    }

    fun assertAdultsDialogOpen() {
        step("Диалог подтверждения возраста открыт") {
            Thread.sleep(5000)
            adultsTitle.isDisplayed()
            adultsInfo.isDisplayed()
            adultsAgree.isDisplayed()
            adultsDisagree.isDisplayed()
        }
    }
}
