package oasis.letu.screens.navigation

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.utilities.getResourceString
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import ru.letu.onboarding.R
import ru.letu.ui.base.MainActivity

// https://testops.letoile.tech/project/2/test-cases/56718?treeId=14&search=W3siaWQiOiJjZi4yNiIsInR5cGUiOiJsb25nQXJyYXkiLCJ2YWx1ZSI6WzcwNDVdfSx7ImlkIjoiY2YuLTIiLCJ0eXBlIjoibG9uZ0FycmF5IiwidmFsdWUiOls3NjIwXX1d

object CookieScreen : KScreen<CookieScreen>() {
    override val layoutId: Int
        get() = ru.letu.onboarding.R.layout.fragment_permissions_policy
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val backgroundImage = KImageView {
        withId(R.id.image_background)
        withIndex(0) {
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
        withIndex(0) { withId(R.id.text_header) }
        withText(ru.letu.core_resources.R.string.onboarding_permission_cookies_title)
    }

    fun checktextHeader() {
        Allure.step("Проверка отображения заголовка") {
            textHeader.isDisplayed()
        }
    }

    val textMain = KTextView {
        withId(R.id.text_main)
        // withIndex(0) { withId(R.id.text_main) }
        withText(ru.letu.core_resources.R.string.onboarding_permission_cookies_text)
    }

    fun checktextMain() {
        Allure.step("Проверка отображения текста") {
            textMain.isDisplayed()
        }
    }

    fun clickLink() {
        Allure.step("Кликнуть на ссылку") {
            textMain.clickSpanWithText(
                getResourceString(ru.letu.core_resources.R.string.onboarding_permission_cookies_text_link)
            )
        }
    }

    val allowButton = KButton {
        withId(R.id.button_next)
        withIndex(0) { withId(R.id.button_next) }
        withText(ru.letu.core_resources.R.string.onboarding_permission_cookies_button)
    }

    fun checkAllowButton() {
        Allure.step("Проверка отображения кнопки Continue") {
            allowButton.isDisplayed()
        }
    }

    fun clickAllowButton() {
        Allure.step("Кликнуть на кнопку Continue") {
            allowButton.click()
        }
    }
}
