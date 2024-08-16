package oasis.letu.screens.authScreens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import oasis.letu.screens.menuScreens.PersonalDataScreen
import ru.letu.login.R
import ru.letu.ui.base.MainActivity

object WelcomeToLetoileWorldWithCardScreen : KScreen<WelcomeToLetoileWorldWithCardScreen>() {

    override val layoutId: Int
        get() = R.layout.fragment_welcome_loyalty_card

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    val CardBonusesNumber = KTextView { withId(ru.letu.feature.npl.common.R.id.bonuses_value) }
    val CardBonusesText = KTextView {
        withId(ru.letu.feature.npl.common.R.id.bonuses_hint)
        withText(ru.letu.core_resources.R.string.app_npl_card_balance)
    }
    val CardActivationText = KTextView {
        withId(ru.letu.feature.npl.common.R.id.not_activated_hint)
        withText(ru.letu.core_resources.R.string.app_npl_card_not_activated_hint)
    }
    val Welcome = KTextView {
        withId(R.id.welcome_tv)
        withText(R.string.app_welcome_text)
    }
    val WelcomeText = KTextView {
        withId(R.id.bonus_tv)
        withText(R.string.app_welcome_loyalty_text)
    }
    val CardBalanceText = KTextView {
        withId(R.id.card_bonus_tv)
        withText(R.string.app_card_bonus_text)
    }
    val CardBalanceValue = KTextView { withId(R.id.card_bonus_value) }
    val WelcomeBonusesText = KTextView {
        withId(R.id.welcome_bonus_tv)
        withText(R.string.app_welcome_bonus_text)
    }
    val WelcomeBonusValue = KTextView { withId(R.id.welcome_bonus_value) }
    val ActivateCardButton = KButton {
        withId(R.id.btnActivate)
        withText(R.string.app_activate_card)
    }

    fun assertWelcomeToLetoileWorldScreenUAEDisplayed() {
        Allure.step("Проверка отображения  welcome screen UAE и его элементов") {
            CardBonusesNumber.isDisplayed()
            CardBonusesText.isDisplayed()
            CardActivationText.isDisplayed()
            Welcome.isDisplayed()
            WelcomeText.isDisplayed()
            CardBalanceText.isDisplayed()
            CardBalanceValue.isDisplayed()
            WelcomeBonusesText.isDisplayed()
            WelcomeBonusValue.isDisplayed()
            ActivateCardButton.isDisplayed()
        }
    }

    fun clickActivateCardButton() {
        Allure.step("Нажать на activate card ") {
            ActivateCardButton.click()
            PersonalDataScreen.assertPersonalDataScreenDisplayed()
        }
    }
}
