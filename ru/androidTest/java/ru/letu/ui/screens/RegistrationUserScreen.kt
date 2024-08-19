package ru.letu.ui.screens

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import ru.letu.R
import ru.letu.core_resources.R as RCoreResources

object RegistrationUserScreen : Screen<RegistrationUserScreen>() {
    val registrationInfoTitle = KTextView { withText("Заполните поля, чтобы завершить регистрацию") }
    val nameField = KEditText { withId(ru.letu.feature.profile.R.id.tietName) }
    val surnameField = KEditText { withId(ru.letu.feature.profile.R.id.tietFname) }
    val emailField = KEditText { withId(ru.letu.feature.profile.R.id.tietEmail) }
    val continueRegistrationButton = KButton { withId(ru.letu.feature.profile.R.id.btnUpdUserData) }
    val errorMessage = KTextView { withId(com.google.android.material.R.id.textinput_error) }
    val errorMessageEmptyName = KTextView { withId(RCoreResources.string.core_ui_error_required_empty) }

    fun enterName(name: String) {
        nameField {
            isVisible()
            replaceText(name)
        }
    }

    fun checkErrorInvalidEmail(error: String) {
        errorMessage {
            isVisible()
            hasText(error)
        }
    }

    fun checkErrorEmptyName(error: String) {
        errorMessageEmptyName {
            isVisible()
            hasText(error)
        }
    }

    fun enterSurname(surname: String) {
        surnameField {
            isVisible()
            replaceText(surname)
        }
    }

    fun enterEmail(email: String) {
        emailField {
            isVisible()
            replaceText(email)
        }
    }

    fun continueRegistrationClick() {
        continueRegistrationButton {
            isEnabled()
            click()
        }
    }
}
