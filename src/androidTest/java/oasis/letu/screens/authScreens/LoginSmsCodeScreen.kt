package oasis.letu.screens.authScreens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import oasis.letu.screens.menuScreens.MenuScreen
import ru.letu.login.R
import ru.letu.ui.base.MainActivity

object LoginSmsCodeScreen : KScreen<LoginSmsCodeScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_confirmation_v2
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val CodeSendToNumberText = KTextView { withId(R.id.txt_code_sent_on) }
    val PhoneNumber = KTextView { withId(R.id.txt_code_sent_on_value) }
    val EnterSmsCodeField = KEditText { withId(R.id.vcv) }
    val TimerText = KTextView { withId(R.id.txt_resend_code_timer) }
    val SendCodeAgainButton = KButton { withId(R.id.btnGetCode) }
    val IncorrectCodeErrorText = KTextView { withId(R.id.tvError) }
    val LogInButton = KButton { withId(R.id.btnLogin) }

    fun checkCodeSendToNumberText() {
        step("Проверка отображения текста код отправлен на номер  ") {
            EnterSmsCodeField.isDisplayed()
        }
    }
    fun checkPhoneNumber() {
        step("Проверка отображения номера телефона  ") {
            PhoneNumber.isDisplayed()
        }
    }
    fun checkSmsCodeField() {
        step("Проверка отображения поля ввода смс") {
            EnterSmsCodeField.isDisplayed()
        }
    }
    fun enterPhoneCode(code: String) {
        step("Ввести смс код $code") {
            EnterSmsCodeField.typeText(code)
            assertPhoneCodeEntered(code)
        }
    }
    fun enterCode(code: String) { // для теста на отображение ошибок
        step("Ввести смс код $code") {
            EnterSmsCodeField.typeText(code)
        }
    }
    fun checkTimerText() {
        step("Проверка отображения текста таймера ") {
            TimerText.isDisplayed()
        }
    }
    fun checkLogInButton() {
        step("Проверка отображения кнопки входа в систему") {
            LogInButton.isDisplayed()
        }
    }
    fun clickLogInButton() {
        step("Нажать на кнопку входа в систему") {
            LogInButton.click()
            MenuScreen.assertProfileInMenuDisplayed()
        }
    }
    fun clickLogIn() { // для тестов на проверку ошибок
        step("Нажать на кнопку входа в систему") {
            LogInButton.click()
        }
    }
    fun checkError() { // для тестов на проверку ошибок
        step("Проверка отображения ошибки") {
            IncorrectCodeErrorText.isDisplayed()
        }
    }

    fun assertEnterPhoneScreenOpen() {
        step("Экран ввода SMS открыт") {
            EnterSmsCodeField.isDisplayed()
        }
    }

    private fun assertPhoneCodeEntered(code: String) {
        step("Cмс код $code введен") {
            EnterSmsCodeField.hasText(code)
        }
    }
}
