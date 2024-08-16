package oasis.letu.screens.authScreens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import oasis.letu.bottomSheet.CountrySelectionBottomScreen
import org.hamcrest.Matcher
import ru.letu.login.R
import ru.letu.ui.base.MainActivity

object AuthorizationScreen : KScreen<AuthorizationScreen>() {

    override val layoutId: Int
        get() = R.layout.fragment_login_by_phone

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    val LoginOrRegister = KTextView {
        withId(R.id.tv_title)
        withText(ru.letu.core_resources.R.string.login_title_login_or_registration)
    }
    val PhoneField = KTextInputLayout { withId(R.id.layout_phone) }
    val EnterPhoneField = KEditText { withId(R.id.tvPhone) }
    val SendCodeButton = KButton {
        withId(R.id.button)
        withText(ru.letu.core_resources.R.string.login_action_resume)
    }
    val AgreementText = KTextView {
        withId(R.id.txt_agreement_acceptance)
        withText(ru.letu.core_resources.R.string.login_dsc_agreement)
    }
    val CountryName = KTextView { withId(R.id.country_name) }
    val OpenListImage = KImageView { withId(R.id.click_for_move_list_of_country) }
    val CountryFlag = KImageView { withId(ru.letu.feature.region.common.R.id.countryFlag) }
    val NameOfCountry = KTextView { withId(ru.letu.feature.region.common.R.id.countryName) }
    val CountryCode = KTextView { withId(ru.letu.feature.region.common.R.id.countryCode) }

    val recycler = KRecyclerView(
        {
            withId(R.id.list_of_country)
            withDescendant { withId(ru.letu.feature.region.common.R.id.countryName) }
        },
        {
            itemType(::RecyclerClass)
        }
    )

    class RecyclerClass(parent: Matcher<View>) : KRecyclerItem<RecyclerClass>(parent) {
        val clinicText = KTextView(parent) { withId(ru.letu.R.id.txtItemMenu) }
    }

    fun checkLoginOrRegister() {
        step("Проверить отображение текст Login Or Register") {
            LoginOrRegister.isDisplayed()
        }
    }

    fun checkCountrySelectionField() {
        step("Проверить отображение поля выбора страны") {
            OpenListImage.isDisplayed()
        }
    }

    fun clickOnCountrySelectionField() {
        step("Нажать на поле выбора страны") {
            OpenListImage.click()
            CountrySelectionBottomScreen.assertCountrySelectionBottomOpen()
        }
    }

    fun checkPhoneField() {
        step("Проверить отображение текст Login Or Register") {
            PhoneField.isDisplayed()
        }
    }

    fun enterPhoneField(phone: String) {
        step("Ввести номер телефона $phone") {
            EnterPhoneField {
                isVisible()
                typeText(phone)
            }
            assertPhoneField(phone)
        }
    }

    fun enterPhone(phone: String) { // для тестов на отображение ошибки
        step("Ввести номер телефона $phone") {
            EnterPhoneField {
                isVisible()
                typeText(phone)
            }
        }
    }

    fun checkSendCodeBtn() {
        step("Проверка отображения кнопки Отправить код") {
            SendCodeButton.isDisplayed()
        }
    }

    fun clickSendCodeBtn() {
        step("Нажать на кнопку Отправить код") {
            SendCodeButton.click()
            LoginSmsCodeScreen.assertEnterPhoneScreenOpen()
        }
    }

    fun clickSendCode() { // нужно для теста по отображению ошибок
        step("Нажать на кнопку Отправить код") {
            SendCodeButton.click()
        }
    }

    fun scrollToEnd() {
        recycler.scrollToEnd()
    }

    fun assertAuthorizationScreenOpen() {
        step("Открыт экран авторизации") {
            EnterPhoneField.isDisplayed()
        }
    }

    fun assertCountrySelection(country: Int) {
        step("Выбрана страна $country") {
            CountryName.hasText(country)
        }
    }

    fun assertCountrySelection(country: String) {
        step("Выбрана страна $country") {
            CountryName.hasText(country)
        }
    }

    private fun assertPhoneField(phone: String) {
        step("Номер телефона $phone введен") {
            EnterPhoneField.containsText(phone.substring(5))
        }
    }

    fun checkError() {
        step("Проверка отображения ошибки") {
            PhoneField {
                hasError(ru.letu.core_resources.R.string.app_error_phone_mask)
            }
        }
    }

    fun checkAgreementText() {
        step("Проверка отображения текста политики конфиденциальности") {
            AgreementText.isDisplayed()
        }
    }
}
