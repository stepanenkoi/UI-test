package oasis.letu.screens.navigation

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.onboarding.R
import ru.letu.ui.base.MainActivity

object OnboardingScreen : KScreen<OnboardingScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_onboarding_slide
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val linearToolbar = KView {
        withId(R.id.linear_toolbar)
        withIndex(3) { withId(R.id.linear_toolbar) }
    }

    fun checkToolbar() {
        step("Проверка отображения тулбара") {
            linearToolbar.isDisplayed()
        }
    }

    val closeButton = KImageView {
        withId(R.id.image_close_button)
        withIndex(3) { withId(R.id.image_close_button) }
    }

    fun checkCloseButton() {
        step("Проверка отображения кнопки закрыть") {
            closeButton.isDisplayed()
        }
    }
    fun clickCloseButton() {
        step("Закрыть экран онбординга") {
            closeButton.click()
        }
    }

    val recyclerTimer = KView {
        withId(R.id.recycler_progress_timer)
        withIndex(3) { withId(R.id.recycler_progress_timer) }
    }

    fun checkTimer() {
        step("Проверка отображения таймера") {
            recyclerTimer.isDisplayed()
        }
    }

    val textTitle = KTextView {
        withId(R.id.text_title)
        withIndex(3) { withId(R.id.text_title) }
    }

    fun checkTextTitle() {
        step("Проверка отображения заголовка") {
            textTitle.isDisplayed()
        }
    }

    val textSubtitle = KTextView {
        withId(R.id.text_subtitle)
        withIndex(3) { withId(R.id.text_subtitle) }
    }

    fun checkTextSubtitle() {
        step("Проверка отображения текста") {
            textSubtitle.isDisplayed()
        }
    }

    val videoView = KView {
        withId(R.id.video_view)
        withIndex(3) { withId(R.id.video_view) }
    }

    fun checkVideo() {
        step("Проверка отображения анимации") {
            videoView.isDisplayed()
        }
    }

    val startShoppingButton = KButton {
        withId(R.id.button_next)
        withIndex(3) { withId(R.id.button_next) }
    }

    fun checkButton() {
        step("Проверка отображения кнопки START SHOPPING") {
            startShoppingButton.isDisplayed()
        }
    }
    fun clickButton() {
        step("Нажать на кнопку START SHOPPING") {
            startShoppingButton.click()
        }
    }
}
