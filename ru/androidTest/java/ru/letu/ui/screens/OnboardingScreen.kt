package ru.letu.ui.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withContentDescription
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager.KViewPager
import io.github.kakaocup.kakao.text.KButton
import ru.letu.onboarding.R
import ru.letu.onboarding.presentation.fragment.OnboardingFragment

/**
 * Created by Vladislav Kochetov on 26.04.2022.
 */
object OnboardingScreen : KScreen<OnboardingScreen>() {

    private val viewPager = KViewPager { withId(R.id.viewPager) }
    private val button = KButton { withId(R.id.button_next) }
    private val skipOnboardingImageButton = KImageView { withId(R.id.image_close_button) }

    override val layoutId: Int
        get() = R.layout.fragment_onboarding

    override val viewClass: Class<*>
        get() = OnboardingFragment::class.java

    fun checkConsistency() {
        viewPager.isDisplayed()
        button {
            hasAnyText()
            isClickable()
        }
    }

    fun skip() {
        // Skip promo slide
        button.click()
        // Skip product tour
        skipOnboardingImageButton.click()
        // Skip login slide
        val skipOnboardingToolbarButton =
            onView(withContentDescription(androidx.appcompat.R.string.abc_toolbar_collapse_description))
        skipOnboardingToolbarButton.perform(click())
    }
}
