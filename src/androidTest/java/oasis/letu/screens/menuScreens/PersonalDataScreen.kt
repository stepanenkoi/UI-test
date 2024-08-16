package oasis.letu.screens.menuScreens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import oasis.letu.testData.TestDataScreen
import ru.letu.R
import ru.letu.ui.base.MainActivity
import androidx.test.espresso.matcher.ViewMatchers.withHint
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import oasis.letu.helper.GenerateRandomString
import org.hamcrest.Matcher

object PersonalDataScreen : KScreen<PersonalDataScreen>() {
    override val layoutId: Int
        get() = R.layout.cartridge_ui_user_data_personal

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    private val randomEmail = GenerateRandomString.generateEmail(9) + "@test.lt"

    val fillAllFieldsText = KTextView {
        withId(R.id.fill_all_fields_text)
        withText(ru.letu.core_resources.R.string.app_fill_fields)
    }
    val firstNameField = KTextInputLayout {
        withId(R.id.til_first_name)
        withHint(ru.letu.core_resources.R.string.app_message_first_name)
    }
    val addFirstName = KEditText { withId(R.id.tiet_first_name) }
    val lastNameField = KTextInputLayout {
        withId(R.id.til_last_name)
        withHint(ru.letu.core_resources.R.string.app_message_last_name)
    }
    val addLastName = KEditText { withId(R.id.tiet_last_name) }
    val dateOfBirthField = KTextInputLayout {
        withId(R.id.til_birthdate)
        withHint(ru.letu.core_resources.R.string.app_birthdate)
    }
    val addDateOfBirth = KEditText { withId(R.id.tiet_birthdate) }
    val textGender = KTextView {
        withId(R.id.title_gender) // он работает
        withText(ru.letu.core_resources.R.string.app_filter_perfume_sex)
    }
    val maleGender = KCheckBox {
        withId(R.id.chip_gender_male)
        withText(ru.letu.core_resources.R.string.app_gender_male)
    }
    val femaleGender = KCheckBox {
        withId(R.id.chip_gender_female)
        withText(ru.letu.core_resources.R.string.app_gender_female)
    }
    val accountTitle = KTextView {
        withId(R.id.title_account) // он работает
        withText(ru.letu.core_resources.R.string.app_account_type)
    }
    val accountLocal = KCheckBox {
        withId(R.id.chip_account_type_local)
        withText(ru.letu.core_resources.R.string.app_account_type_local)
    }
    val accountResident = KCheckBox {
        withId(R.id.chip_account_type_resident)
        withText(ru.letu.core_resources.R.string.app_account_type_resident)
    }
    val accountTourist = KCheckBox {
        withId(R.id.chip_account_type_tourist)
        withText(ru.letu.core_resources.R.string.app_account_type_tourist)
    }
    val textContacts = KTextView {
        withId(R.id.text_block_title)
        withText(ru.letu.core_resources.R.string.app_user_data_contacts)
    }
    val phoneField = KTextInputLayout {
        withId(R.id.til_phone)
        withHint(ru.letu.core_resources.R.string.login_hint_phone)
    }
    val addPhone = KEditText { withId(R.id.tiet_phone) }
    val emailField = KTextInputLayout {
        withId(R.id.til_email)
        withHint(ru.letu.core_resources.R.string.login_hint_email)
    }
    val addEmail = KEditText { withId(R.id.tiet_email) }

    val emailToggle = KCheckBox {
        withId(R.id.checkbox_receive_new_by_email)
        withText(ru.letu.core_resources.R.string.app_user_data_email_agreement)
    }
    val smsToggle = KCheckBox {
        withId(R.id.checkbox_receive_new_by_sms)
        withText(ru.letu.core_resources.R.string.app_user_data_sms_agreement)
    }
    val saveChangesButton = KButton {
        withId(R.id.button)
        withText(ru.letu.core_resources.R.string.app_save)
    }
    val policyText = KTextView {
        withId(R.id.text_terms_of_agreement_content)
        withText(ru.letu.core_resources.R.string.app_user_data_privacy)
    }
    val deleteButton = KButton {
        withId(R.id.button_delete_user)
    }
    val deleteText = KTextView { withId(R.id.txtItemMenu) }
    val deleteImage = KImageView { withId(R.id.imgItemMenu) }
    val changeLanguage = KTextView {
        withId(R.id.btnChangeLanguage)
        withText(ru.letu.core_resources.R.string.app_change_language)
    }
    val chooseLanguageTitle = KTextView {
        withId(ru.letu.core.endeca.R.id.title)
        withIndex(0) { withId(ru.letu.core.endeca.R.id.title) }
    }
    val arab = KTextView {
        withId(ru.letu.core.endeca.R.id.title)
        withIndex(1) { withId(ru.letu.core.endeca.R.id.title) }
    }
    val english = KTextView {
        withId(ru.letu.core.endeca.R.id.title)
        withIndex(2) { withId(ru.letu.core.endeca.R.id.title) }
    }
    val dataSaved = KTextView {
        // withId(com.google.android.material.R.id.snackbar_text)
    withText(ru.letu.core_resources.R.string.app_saving_success)
   }
    val recycler = KRecyclerView(
        {
            withId(R.id.contentRecycler)
        },
        {
            itemType(::RecyclerClass)
        }
    )

    class RecyclerClass(parent: Matcher<View>) : KRecyclerItem<RecyclerClass>(parent)

    fun scrollToEnd() {
        recycler.scrollToEnd()
    }

    fun scrollToUp() {
        recycler.scrollToStart()
    }

    fun checkFillAllFieldsText() {
        Allure.step("Проверка отображения текста описания экрана") {
            fillAllFieldsText.isDisplayed()
        }
    }

    fun checkFirstNameField() {
        Allure.step("Проверка отображения  поля имени") {
            firstNameField.isDisplayed()
        }
    }

    fun checkFirstNameError() {
        Allure.step("Проверка отображения ошибки в поле имени") {
            firstNameField.hasError(ru.letu.core_resources.R.string.login_text_pass_empty_error)
        }
    }
    fun checkFirstNameNoError() {
        Allure.step("Проверка, что   ошибка неотображается в поле имени") {
            firstNameField.hasNoError()
        }
    }

    fun checkEmptyFirstNameField() {
        Allure.step("Проверка, что поле ввода имени пустое") {
            addFirstName.isDisplayed()
            addFirstName.hasText("")
        }
    }

    fun checkFirstNameFieldWithName() {
        Allure.step("Проверка отображения текста в поле имени ") {
            addFirstName.isDisplayed()
            addFirstName.hasText(TestDataScreen.NAME)
        }
    }

    fun addName() {
        Allure.step("ввести имя ") {
            addFirstName.typeText(TestDataScreen.NAME)
        }
    }

    fun checkLastNameField() {
        Allure.step("Проверка отображения  поля имени") {
            lastNameField.isDisplayed()
        }
    }

    fun checkLastNameError() {
        Allure.step("Проверка отображения ошибки в поле фамилии") {
            lastNameField.hasError(ru.letu.core_resources.R.string.login_text_pass_empty_error)
        }
    }
    fun checkLastNameNoError() {
        Allure.step("Проверка, что  ошибка не отображается в поле фамилии") {
            lastNameField.hasNoError()
        }
    }

    fun checkEmptyLastNameField() {
        Allure.step("Проверка, что поле ввода фамилии пустое") {
            addLastName.isDisplayed()
            addLastName.hasText("")
        }
    }

    fun checkLastNameFieldWithName() {
        Allure.step("Проверка отображения текста в поле фамилии ") {
            addLastName.isDisplayed()
            addLastName.hasText(TestDataScreen.SECOND_NAME)
        }
    }
    fun addLastName() {
        Allure.step("ввести фамилию") {
            addLastName.typeText(TestDataScreen.SECOND_NAME)
        }
    }

    fun checkDateField() {
        Allure.step("Проверка отображения  поля даты рождения") {
            dateOfBirthField.isDisplayed()
        }
    }

    fun checkDateError() {
        Allure.step("Проверка отображения ошибки в даты рождения") {
            dateOfBirthField.hasError(ru.letu.core_resources.R.string.login_text_pass_empty_error)
        }
    }
    fun checkDateNoError() {
        Allure.step("Проверка, что не отображается ошибка в поле даты рождения") {
            dateOfBirthField.hasNoError()
        }
    }

    fun checkEmptyDateField() {
        Allure.step("Проверка, что поле ввода фамилии пустое") {
            addDateOfBirth.isDisplayed()
            addDateOfBirth.hasText("")
        }
    }

    fun checkDateFieldWithDate() {
        Allure.step("Проверка отображения даты в поле даты ") {
            addDateOfBirth.isDisplayed()
            addDateOfBirth.hasText(TestDataScreen.DATE)
        }
    }
    fun addDate() {
        Allure.step("добавить дату") {
            addDateOfBirth.replaceText(TestDataScreen.DATE)
        }
    }

    fun checkGenderTitle() {
        Allure.step("Проверка отображения заголовка Gender") {
            textGender.isDisplayed()
        }
    }

    fun checkMaleGender() {
        Allure.step("Проверка отображения мужского пола") {
            maleGender.isDisplayed()
        }
    }

    fun clickMaleGender() {
        Allure.step("Выбрать  мужской пол") {
            maleGender.click()
            maleGender.isChecked()
        }
    }
    fun checkMaletIsActive() {
        Allure.step("выбран male gender") {
            maleGender.isChecked()
        }
    }

    fun checkFemaleGender() {
        Allure.step("Проверка отображения женского пола") {
            femaleGender.isDisplayed()
        }
    }

    fun clickFemaleGender() {
        Allure.step("Выбрать женский пол") {
            femaleGender.click()
            femaleGender.isChecked()
        }
    }

    fun checkAccountTitle() {
        Allure.step("Проверка отображения заголовка Account") {
            accountTitle.isDisplayed()
        }
    }

    fun checkLocalAccount() {
        Allure.step("Проверка отображения local") {
            accountLocal.isDisplayed()
        }
    }

    fun clickLocalAccount() {
        Allure.step("Выбрать local") {
            accountLocal.click()
            accountLocal.isChecked()
        }
    }

    fun checkResidentAccount() {
        Allure.step("Проверка отображения resident") {
            accountResident.isDisplayed()
        }
    }

    fun clickResidentAccount() {
        Allure.step("Выбрать resident") {
            accountResident.click()
            accountResident.isChecked()
        }
    }
    fun checkResidentIsActive() {
        Allure.step("выбран Резидент") {
            accountResident.isChecked()
        }
    }

    fun checkTouristAccount() {
        Allure.step("Проверка отображения Tourist") {
            accountTourist.isDisplayed()
        }
    }

    fun clickTouristAccount() {
        Allure.step("Выбрать Tourist") {
            accountTourist.click()
            accountTourist.isChecked()
        }
    }

    fun checkContactsTitle() {
        Allure.step("Проверка отображения  заголовка Contacts") {
            textContacts.isDisplayed()
        }
    }

    fun checkPhoneField() {
        Allure.step("Проверка отображения  поля телефона") {
            phoneField.isDisplayed()
        }
    }

    fun checkPhoneFieldWithPhone() {
        Allure.step("Проверка отображения телефона в поле телефона ") {
            addPhone.isDisplayed()
            addPhone.hasText(TestDataScreen.PROFILE_PHONE)
        }
    }

    fun checkEmailField() {
        Allure.step("Проверка отображения  поля email") {
            emailField.isDisplayed()
        }
    }

    fun checkEmailError() {
        Allure.step("Проверка отображения ошибки в  поле email") {
            emailField.hasError(ru.letu.core_resources.R.string.login_text_pass_empty_error)
        }
    }
    fun checkWrongEmailError() {
        Allure.step("Проверка отображения ошибки некорректного email в  поле email") {
            emailField.hasError(ru.letu.core_resources.R.string.app_email_validation_error)
        }
    }
    fun checkEmailNoError() {
        Allure.step("Проверка, что  ошибка не отображается  в  поле email") {
            emailField.hasNoError()
        }
    }

    fun checkEmptyEmailField() {
        Allure.step("Проверка, что поле ввода email пустое") {
            addEmail.isDisplayed()
            addEmail.hasText("")
        }
    }

    fun checkEmailFieldWithEmail() {
        Allure.step("Проверка отображения почты в поле email ") {
            addEmail.isDisplayed()
            addEmail.hasText(TestDataScreen.EMAIL)
        }
    }
    fun checkEmailFieldWithRandomEmail() {
        Allure.step("Проверка отображения почты в поле email ") {
            addEmail.isDisplayed()
            addEmail.hasText(randomEmail)
        }
    }
    fun addWrongEmail() {
        Allure.step("ввести некорректный email ") {
            addEmail.typeText(TestDataScreen.NAME)
        }
    }
    fun addEmail() {
        Allure.step("ввести корректный email ") {
            addEmail.clearText()
            addEmail.typeText(TestDataScreen.EMAIL)
        }
    }
    fun addRandomEmail() {
        Allure.step("ввести  email ") {
            addEmail.clearText()
            addEmail.typeText(randomEmail)
        }
    }

    fun checkSMSToggle() {
        Allure.step("Проверка отображения тоггла смс ") {
            smsToggle.isDisplayed()
        }
    }

    fun clickSMSToggle() {
        Allure.step("Кликнуть тоггл смс ") {
            smsToggle.click()
            smsToggle.isChecked()
        }
    }

    fun checkEmailToggle() {
        Allure.step("Проверка отображения тоггла email ") {
            emailToggle.isDisplayed()
        }
    }

    fun clickEmailToggle() {
        Allure.step("Кликнуть тоггл email ") {
            emailToggle.click()
        }
    }
    fun checkTogglesOn() {
        Allure.step("Проверка что тогглы включены ") {
            emailToggle.isChecked()
            smsToggle.isChecked()
        }
    }

    fun checkSaveButton() {
        Allure.step("Проверка отображения кнопки save changes ") {
            saveChangesButton.isDisplayed()
        }
    }

    fun clickSaveButton() {
        Allure.step("Кликнуть кнопку save changes ") {
            saveChangesButton.click()
        }
    }

    fun checkPolicyText() {
        Allure.step("Проверка отображения текста policity ") {
            policyText.isDisplayed()
        }
    }

    fun checkDeleteButton() {
        Allure.step("Проверка отображения кнопки Delete account ") {
            deleteButton.isDisplayed()
        }
    }

    fun clickDeleteButton() {
        Allure.step("Кликнуть кнопку Delete account ") {
            deleteButton.click()
        }
    }

    fun checkChangeLanguage() {
        Allure.step("Проверка отображения кнопки Change Language") {
            changeLanguage.isDisplayed()
        }
    }

    fun clickChangeLanguage() {
        Allure.step("Кликнуть кнопку Change Language") {
            changeLanguage.click()
        }
    }

    fun checkLanguage() {
        Allure.step("Проверка отображения заголовка выбора языка") {
            chooseLanguageTitle.isDisplayed()
        }
    }

    fun checkArab() {
        Allure.step("Проверка отображения выбора арабского языка") {
            arab.isDisplayed()
        }
    }

    fun clickArabic() {
        Allure.step("Выбрать арабский язык") {
            arab.click()
        }
    }

    fun checkEnglish() {
        Allure.step("Проверка отображения выбора английского языка") {
            english.isDisplayed()
        }
    }

    fun clickEnglish() {
        Allure.step("Выбрать английский язык") {
            english.click()
        }
    }

    fun checkChangeToArab() {
        Allure.step("Проверка смены  на арабский язык") {
            chooseLanguageTitle.hasText(TestDataScreen.ARAB)
        }
    }

    fun checkChangeToEnglish() {
        Allure.step("Проверка смены  на английский язык") {
            chooseLanguageTitle.hasText(TestDataScreen.ENGLISH)
        }
    }
    fun checkDataSaved() {
        Allure.step("Проверка отображения сплеша Data saved") {
            dataSaved.isDisplayed()
        }
    }

    fun assertPersonalDataScreenDisplayed() {
        Allure.step("Проверка отображения профиля в меню") {
            fillAllFieldsText.isDisplayed()
            lastNameField.isDisplayed()
        }
    }
}
