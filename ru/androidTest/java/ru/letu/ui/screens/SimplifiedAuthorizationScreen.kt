package ru.letu.ui.screens

import androidx.test.espresso.matcher.ViewMatchers
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.helpers.TestUtils.childAtPosition
import ru.letu.ui.helpers.TestUtils.phoneNumberRu
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.profile.R as RProfile

object SimplifiedAuthorizationScreen : Screen<SimplifiedAuthorizationScreen>() {
    val phoneTitle = KTextView { withText(RCoreResources.string.login_action_phone) }
    val emailTitle = KTextView { withText(RCoreResources.string.login_action_email) }
    val enterPhoneField = KEditText { withId(RProfile.id.tvPhone) }
    private val enterEmailField = KEditText { withId(RProfile.id.tvEmail) }
    val continueButton = KButton { withId(R.id.button) }
    val authDescription = KTextView { withId(RProfile.id.tvDsc) }
    private val passwordField = KEditText { withId(RProfile.id.tietPass) }
    val sendSmsInfo = KTextView { withId(RProfile.id.txt_code_sent_on) }
    val phoneCodeField = KEditText {
        childAtPosition(
            ViewMatchers.withId(RProfile.id.flContainer),
            3
        )
        isDescendantOfA { withId(RProfile.id.flContainer) }
        withId(RProfile.id.vcv)
    }

    fun enterPhoneNumber(phone: String) {
        step("Ввести номер $phone") {
            enterPhoneField.typeText(phone)
            assertEnterPhoneNumber(phoneNumberRu(phone))
        }
    }

    fun enterPassword(password: String) {
        step("Ввести пароль $password") {
            passwordField.typeText(password)
            assertEnterPassword(password)
        }
    }

    fun continueAuthClick() {
        step("Нажать кнопку Продолжить") {
            closeSoftKeyboard()
            continueButton {
                isEnabled()
                click()
            }
            assertEnterPhoneCodeOpen()
        }
    }

    fun enterEmail(email: String) {
        step("Ввести Email $email") {
            enterEmailField.replaceText(email)
            assertEnterEmail(email)
        }
    }

    fun enterPhoneCode(code: String) {
        step("Ввести код из $code SMS") {
            phoneCodeField.replaceText(code)
            assertEnterPhoneCode(code)
        }
    }

    fun switchToEmailTab() {
        step("Переключиться на вкладку Email") {
            SimplifiedAuthorizationScreen {
                emailTitle.click()
                assertEmailTabOpen()
            }
        }
    }

    fun assertLoginScreenOpen() {
        step("Открыта форма для ввода телефона") {
            ToolBarElementScreen.assertTitleToolBar(RCoreResources.string.login_title_login)
            ToolBarElementScreen.assertBackBtnToolBar()
        }
    }

    private fun assertEmailTabOpen() {
        step("Открыта форма для ввода email") {
            emailTitle.isSelected()
        }
    }

    private fun assertEnterEmail(email: String) {
        step("Email $email введен") {
            enterEmailField.hasText(email)
        }
    }

    private fun assertEnterPhoneNumber(phone: String) {
        step("Телефон $phone введен") {
            enterPhoneField.hasText(phone)
        }
    }

    private fun assertEnterPassword(password: String) {
        step("Пароль $password введен") {
            passwordField.hasText(password)
        }
    }

    private fun assertEnterPhoneCode(code: String) {
        step("Код $code из SMS введен") {
            closeSoftKeyboard()
            phoneCodeField.hasText(code)
        }
    }

    private fun assertEnterPhoneCodeOpen() {
        step("Экран ввода из SMS открыт") {
            phoneCodeField.isDisplayed()
        }
    }
}
