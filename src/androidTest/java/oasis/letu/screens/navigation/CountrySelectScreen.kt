package oasis.letu.screens.navigation

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import ru.letu.onboarding.R
import ru.letu.ui.base.MainActivity

object CountrySelectScreen : KScreen<CountrySelectScreen>() {
    override val layoutId: Int
        get() = ru.letu.feature.region.R.layout.fragment_shop_region
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val countryName = KTextView {
        withId(ru.letu.feature.region.common.R.id.countryName)
        withIndex(0) { withId(ru.letu.feature.region.common.R.id.countryName) }
    }

    fun checkName() {
        Allure.step("Проверка отображения наименования страны") {
            countryName.isDisplayed()
        }
    }

    fun clickName() {
        Allure.step("Кликнуть на  наименования страны") {
            countryName.click()
        }
    }

    val countryFlag = KImageView {
        withId(ru.letu.feature.region.common.R.id.countryFlag)
        withIndex(0) {
            withId(ru.letu.feature.region.common.R.id.countryFlag)
        }
    }

    fun checkFlag() {
        Allure.step("Проверка отображения флага") {
            countryFlag.isDisplayed()
        }
    }

    val checkmark = KImageView {
        withId(ru.letu.feature.region.common.R.id.countryCheck)
        withIndex(0) {
            withId(ru.letu.feature.region.common.R.id.countryCheck)
        }
    }

    fun checkCheckMark() {
        Allure.step("Проверка отображения галки") {
            checkmark.isDisplayed()
        }
    }

    val allowButton = KButton {
        withId(ru.letu.feature.region.R.id.button_next)
        withText(ru.letu.core_resources.R.string.onboarding_permission_cookies_button)
    }

    fun checkButton() {
        Allure.step("Проверка отображения кнопки Continue") {
            allowButton.isDisplayed()
        }
    }

    fun clickButton() {
        Allure.step("Кликнуть на кнопку Continue") {
            allowButton.click()
        }
    }
}
