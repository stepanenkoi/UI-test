package ru.letu.ui.screens.bottomsheet

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.feature.product.dialog.addaddress.AddressDeliverySpecifyDialogFragment
import ru.letu.ui.screens.ReviewGalleryScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.product.R as RProduct

object SpecifyAddressDialogScreen : KScreen<SpecifyAddressDialogScreen>() {
    override val layoutId: Int = ru.letu.feature.product.R.layout.sheet_address_delivery_specify
    override val viewClass: Class<*> = AddressDeliverySpecifyDialogFragment::class.java

    val addressSpecifySheetTitle = KTextView {
        withId(RProduct.id.address_specify_sheet_title)
        withText(RCoreResources.string.app_address_specify_sheet_title)
    }

    val addressSpecifySheetDesc = KTextView {
        withText(RCoreResources.string.app_address_specify_sheet_description)
    }

    val negativeButton = KButton {
        isDescendantOfA { withId(RProduct.id.bottom_sheet) }
        withId(RProduct.id.negative_btn)
        withText(RCoreResources.string.app_address_specify_sheet_negative_button)
    }

    private val negativeUiButton: UiObject = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        .findObject(
            UiSelector()
                .resourceId("ru.letu.preprod:id/negative_btn")
                .text("НЕТ, СПАСИБО")
                .className("android.widget.Button")
        )

    val positiveButton = KButton {
        withId(RProduct.id.positive_btn)
        withText(RCoreResources.string.app_address_specify_sheet_positive_button)
    }

    fun clickNegativeBtn() {
        step("Нажать на НЕТ, СПАСИБО") {
            Thread.sleep(5000)
            negativeUiButton.click()
            ReviewGalleryScreen.assertProductOpen()
        }
    }

    fun assertSpecifyAddressDialogDisplayed() {
        step("Боттом шит Укажите адрес доставки открыт") {
            Thread.sleep(5000)
            negativeUiButton.exists()
        }
    }
}
