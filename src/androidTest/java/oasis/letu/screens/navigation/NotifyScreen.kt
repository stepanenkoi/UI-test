package oasis.letu.screens.navigation

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import ru.letu.onboarding.R
import ru.letu.ui.base.MainActivity

object NotifyScreen : KScreen<NotifyScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_permissions_notifications
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val skipButton = KButton {
        withId(R.id.button_skip)
        withIndex(0) { withId(R.id.button_skip) }
    }

    fun checkSkipButton() {
        Allure.step("Проверка отображения кнопки Skip") {
            skipButton.isDisplayed()
        }
    }
    fun clickSkipButton() {
        Allure.step("Нажать на кнопку Skip") {
            skipButton.click()
        }
    }

    val backgroundImage = KImageView {
        withId(R.id.image_background)
        withIndex(1) {
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
        withIndex(1) { withId(R.id.text_header) }
    }

    fun checkTextHeader() {
        Allure.step("Проверка отображения заголовка") {
            textHeader.isDisplayed()
        }
    }

    val textMain = KTextView {
        withId(R.id.text_main)
        withIndex(1) { withId(R.id.text_main) }
    }

    fun checkTextMain() {
        Allure.step("Проверка отображения текста") {
            textMain.isDisplayed()
        }
    }

    val allowButton = KButton {
        withId(R.id.button_next)
        withIndex(1) { withId(R.id.button_next) }
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
        withIndex(0) { withId(R.id.text_description) }
    }

    fun checkTextDescription() {
        Allure.step("Проверка отображения текста под кнопкой") {
            textDescription.isDisplayed()
        }
    }
}
