package oasis.letu.screens.navigation

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import ru.letu.onboarding.R
import ru.letu.ui.base.MainActivity

object LocationScreen : KScreen<LocationScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_permissions_location
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val skipButton = KButton {
        withId(R.id.button_skip)
        withIndex(1) { withId(R.id.button_skip) }
    }
    fun checkSkipButton() {
        Allure.step("Проверка отображения кнопки Skip") {
            skipButton.isDisplayed()
        }
    }
    val backgroundImage = KImageView {
        withId(R.id.image_background)
        withIndex(2) {
            withId(R.id.image_background)
        }
    }
    fun checkBackgroundImage() {
        Allure.step("Проверка отображения картинки") {
            backgroundImage.isDisplayed()
        }
    }
    val textHeader = KTextView {
        withId(R.id.text_header)
        withIndex(2) { withId(R.id.text_header) }
    }
    fun checkTextHeader() {
        Allure.step("Проверка отображения заголовка") {
            textHeader.isDisplayed()
        }
    }
    val textMain = KTextView {
        withId(R.id.text_main)
        withIndex(2) { withId(R.id.text_main) }
    }
    fun checkTextMain() {
        Allure.step("Проверка отображения текста") {
            textMain.isDisplayed()
        }
    }
    val allowButton = KButton {
        withId(R.id.button_next)
        withIndex(2) { withId(R.id.button_next) }
        withText(ru.letu.core_resources.R.string.onboarding_permission_cookies_button)
    }
    fun checkAllowButton() {
        Allure.step("Проверка отображения кнопки Continue") {
            allowButton.isDisplayed()
        }
    }
    fun clickAllowButton() {
        Allure.step("Нажать на кнопку Continue") {
            allowButton.click()
        }
    }

    val textDescription = KTextView {
        withId(R.id.text_description)
        withIndex(1) { withId(R.id.text_description) }
    }
    fun checkTextDescription() {
        Allure.step("Проверка отображения текста под кнопкой") {
            textDescription.isDisplayed()
        }
    }
}
