package ru.letu.ui.screens

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.helpers.TestUtils.getString
import ru.letu.ui.helpers.TestUtils.phoneNumberRu
import ru.letu.ui.screens.DelYourAccountHasBeenDeletedScreen.assertDelYourAccountHasBeenDeletedScreenOpen
import ru.letu.core_resources.R as RCoreResources

object DelAccountScreen : Screen<DelAccountScreen>() {

    private val delAccountMessage = KTextView { withId(R.id.txt_deletion_confirm_message) }
    private val delAccountHint = KTextView {
        withId(R.id.txt_account_deletion_hint)
        withText(RCoreResources.string.app_profile_deletion_confirm_hint)
    }
    private val delAccountEdtCode = KEditText { withId(R.id.edt_code) }
    private val delAccountBtn = KButton {
        withId(R.id.btn_delete_account)
        withText(RCoreResources.string.app_txt_delete)
    }
    private val delAccountResendCodeBtn = KButton { withId(R.id.btn_resend_code) }
    private val delAccountCancelBtn = KButton {
        withId(R.id.btn_cancel)
        withText(RCoreResources.string.app_cancel)
    }

    fun assertDelAccountScreenOpen(tel: String) {
        step("Экран Удаление аккаунта открыт") {
            closeSoftKeyboard()
            delAccountMessage.containsText(
                getString(RCoreResources.string.core_data_profile_deletion_confirm_email_message).dropLast(
                    80
                )
            )
            delAccountMessage.containsText(phoneNumberRu(tel))
            delAccountHint.isDisplayed()
            delAccountEdtCode.hasHint(RCoreResources.string.core_data_profile_deletion_code_from_sms)

            delAccountBtn.isDisabled()
            delAccountResendCodeBtn.containsText(
                getString(RCoreResources.string.app_profile_deletion_receive_new_code_mask).dropLast(
                    8
                )
            )
            delAccountCancelBtn.isEnabled()
        }
    }

    fun typeCodeDelAccount(code: String) {
        step("Ввести код $code") {
            delAccountEdtCode.typeText(code)
            assertCodeEntered(code)
        }
    }

    fun clickDelAccountBtn() {
        step("Нажать кнопку удалить") {
            delAccountBtn.click()
            assertDelYourAccountHasBeenDeletedScreenOpen()
        }
    }

    private fun assertCodeEntered(code: String) {
        step("Проверка что код $code введен") {
            closeSoftKeyboard()
            delAccountEdtCode.hasText(code)
            delAccountBtn.isEnabled()
        }
    }
}
