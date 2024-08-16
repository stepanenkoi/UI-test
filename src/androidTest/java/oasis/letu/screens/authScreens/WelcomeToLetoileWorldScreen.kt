package oasis.letu.screens.authScreens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import oasis.letu.screens.menuScreens.MenuScreen.assertProfileInMenuDisplayed
import ru.letu.ui.base.MainActivity
import ru.letu.login.R

object WelcomeToLetoileWorldScreen : KScreen<WelcomeToLetoileWorldScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_welcome

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    val WelcomeText = KTextView {
        withId(R.id.welcome_tv)
        withText(R.string.app_welcome_text)
    }
    val InfoText = KTextView {
        withId(R.id.bonus_tv)
        withText(R.string.app_welcome_without_loyalty_text)
    }
    val StartShoppingButton = KButton { withId(R.id.btnStartShopping) }

    fun assertWelcomeToLetoileWorldScreenDisplayed() {
        Allure.step("Проверка отображения  welcome screen и его элементов") {
            WelcomeText.isDisplayed()
            InfoText.isDisplayed()
            StartShoppingButton.isDisplayed()
        }
    }

    fun clickStartShoppingButton() {
        Allure.step("Нажать на start shopping ") {
            StartShoppingButton.click()
            assertProfileInMenuDisplayed()
        }
    }
}
