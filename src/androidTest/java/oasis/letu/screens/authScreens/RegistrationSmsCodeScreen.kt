package oasis.letu.screens.authScreens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import oasis.letu.screens.authScreens.WelcomeToLetoileWorldScreen.assertWelcomeToLetoileWorldScreenDisplayed
import oasis.letu.screens.authScreens.WelcomeToLetoileWorldWithCardScreen.assertWelcomeToLetoileWorldScreenUAEDisplayed
import ru.letu.ui.base.MainActivity
import ru.letu.login.R

object RegistrationSmsCodeScreen : KScreen<RegistrationSmsCodeScreen>() {

    override val layoutId: Int
        get() = R.layout.fragment_confirmation_v2

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    val CodeSendToNumberText = KTextView { withId(R.id.txt_code_sent_on) }
    val PhoneNumber = KTextView { withId(R.id.txt_code_sent_on_value) }
    val EnterSmsCodeField = KEditText { withId(R.id.vcv) }
    val TimerText = KTextView { withId(R.id.txt_resend_code_timer) }
    val ReciewNewsText =
        KTextView { withText(ru.letu.core_resources.R.string.login_action_subscription) }
    val ReciewNewsToggle = KSwitch { withId(R.id.toggleOffers) }
    val PrivacyPolicyAgreementText =
        KTextView { withText(ru.letu.core_resources.R.string.login_action_acceptance) }
    val PrivacyPolicyAgreementToggle = KSwitch { withId(R.id.toggleAcceptance) }
    val RegisterButton = KButton { withId(R.id.btnLogin) }
    val SendCodeAgainButton = KButton { withId(R.id.btnGetCode) }
    val IncorrectCodeErrorText = KTextView { withId(R.id.tvError) }
    val AcceptErrorText = KTextView { withId(R.id.tvErrorAccept) }
    //  val ExpiredCodeError = KTextView{withId(R.Id) /*айди ошибки протухшего кода*/ }

    fun checkCodeSendToNumberText() {
        Allure.step("Проверка отображения текста код отправлен на номер  ") {
           EnterSmsCodeField.isDisplayed()
        }
    }
    fun checkPhoneNumber() {
        Allure.step("Проверка отображения номера телефона  ") {
            PhoneNumber.isDisplayed()
        }
    }
    fun checkSmsCodeField() {
        Allure.step("Проверка отображения поля ввода смс") {
            EnterSmsCodeField.isDisplayed()
        }
    }
    fun enterPhoneCode(code: String) {
        Allure.step("Ввести смс код $code") {
            EnterSmsCodeField.typeText(code)
            assertPhoneCodeEntered(code)
        }
    }
    fun enterCode(code: String) { // для теста на отображение ошибок
        Allure.step("Ввести смс код $code") {
            EnterSmsCodeField.typeText(code)
        }
    }
    fun checkTimerText() {
        Allure.step("Проверка отображения текста таймера ") {
            TimerText.isDisplayed()
        }
    }
    fun checkRegisterButton() {
        Allure.step("Проверка отображения кнопки регистрации") {
            RegisterButton.isDisplayed()
        }
    }
    fun clickRegisterButton() {
        Allure.step("Нажать на кнопку регистрации") {
            RegisterButton.click()
            assertWelcomeToLetoileWorldScreenDisplayed()
        }
    }
    fun clickRegisterUAEButton() {
        Allure.step("Нажать на кнопку регистрации") {
            RegisterButton.click()
            assertWelcomeToLetoileWorldScreenUAEDisplayed()
        }
    }
    fun clickRegister() { // для тестов на проверку ошибок
        Allure.step("Нажать на кнопку регистрации") {
            RegisterButton.click()
        }
    }
    fun checkFieldError() { // для тестов на проверку ошибок под полем смс кода
        Allure.step("Проверка отображения ошибки под полем ввода") {
            IncorrectCodeErrorText.isDisplayed()
        }
    }
    fun checkNewsToggleText() { // для тестов на проверку ошибок под полем смс кода
        Allure.step("Проверка отображения текста на новости") {
            ReciewNewsText.isDisplayed()
        }
    }
    fun checkNewsToggle() { // для тестов на проверку ошибок под полем смс кода
        Allure.step("Проверка отображения тоггла на новости") {
            ReciewNewsToggle.isDisplayed()
        }
    }
    fun clickNewsToggle() { // для тестов на проверку ошибок под полем смс кода
        Allure.step("Проверка отображения тоггла на новости") {
            ReciewNewsToggle.click()
        }
    }
    fun checkPrivacyPolicyAgreementText() {
        Allure.step("Проверка отображения текста на политику конфиденциальности") {
            PrivacyPolicyAgreementText.isDisplayed()
        }
    }
    fun checkPrivacyPolicyAgreementToggle() {
        Allure.step("Проверка отображения тоггла на политику конфиденциальности") {
            PrivacyPolicyAgreementToggle.isDisplayed()
        }
    }
    fun clickPrivacyPolicyAgreementToggle() {
        Allure.step("Подтвердить политику конфиденциальности") {
            PrivacyPolicyAgreementToggle.click()
        }
    }
    fun checkToggleError() { // для тестов на проверку ошибок под полем смс кода
        Allure.step("Проверка отображения ошибки не включенного тогла политики конфиденциальности") {
            AcceptErrorText.isDisplayed()
        }
    }
    fun checkNoToggleError() { // для тестов на проверку ошибок под полем смс кода
        Allure.step(" Ошибка не включенного тогла политики конфиденциальности не отображается") {
            AcceptErrorText.isNotDisplayed()
        }
    }

    fun assertEnterPhoneScreenOpen() {
        Allure.step("Экран ввода SMS открыт") {
            EnterSmsCodeField.isDisplayed()
        }
    }

    private fun assertPhoneCodeEntered(code: String) {
        Allure.step("Cмс код $code введен") {
            EnterSmsCodeField.hasText(code)
        }
    }
}
