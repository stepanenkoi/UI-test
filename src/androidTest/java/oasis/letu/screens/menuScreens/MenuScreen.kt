package oasis.letu.screens.menuScreens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import oasis.letu.helper.TestUtils.clickText
import oasis.letu.screens.authScreens.AuthorizationScreen
import oasis.letu.screens.navigation.BottomNavigation.openBottomMenu
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.base.MainActivity

object MenuScreen : KScreen<MenuScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_menu

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    val loginOrRegisterButton = KView { withId(R.id.menuButton) }
    val CityText = KTextView { withIndex(0) { withId(R.id.txtItemMenu) } }
    val UserName = KTextView { withId(R.id.userName) }
    val PersonalInformation = KTextView { withId(R.id.txtDescription) }
    val SocialLinks = KView { withId(R.id.social_links) }
    val LogOutButton = KButton {
        withId(R.id.button)
    }

    fun checkLogRegButton() {
        step("Проверка отображения кнопки Login or Register") {
            loginOrRegisterButton.isDisplayed()
        }
    }
    fun openAuthorizationScreen() {
        step("Нажать на кнопку Войти или зарегистрироваться") {
            loginOrRegisterButton.click()
            AuthorizationScreen.assertAuthorizationScreenOpen()
        }
    }
    fun openPersonalInformation() {
        step("Открыть экран Personal information") {
            UserName.click()
        }
    }

    val recycler = KRecyclerView(
        {
            withId(ru.letu.core.endeca.R.id.endecaRecycler)
            withDescendant { withId(R.id.menuItemContent) }
        },
        {
            itemType(::RecyclerClass)
        }
    )

    class RecyclerClass(parent: Matcher<View>) : KRecyclerItem<RecyclerClass>(parent) {
        val clinicText = KTextView(parent) { withId(R.id.txtItemMenu) }
    }

    fun scrollToEnd() {
        recycler.scrollToEnd()
    }

    fun assertMenuScreenOpen() {
        step("Экран меню открыт") {
            loginOrRegisterButton.isDisplayed()
        }
    }

    fun assertProfileInMenuDisplayed() {
        step("Проверка отображения профиля в меню") {
            UserName.isDisplayed()
            PersonalInformation.isDisplayed()
        }
    }

    fun clickLogOut() {
        step("Сделать логаут") {
            scrollToEnd()
            clickText(ru.letu.core_resources.R.string.logout_title)
            Thread.sleep(2000) // без него не работает
            LogOutButton.click()
            openBottomMenu()
        }
    }
}
