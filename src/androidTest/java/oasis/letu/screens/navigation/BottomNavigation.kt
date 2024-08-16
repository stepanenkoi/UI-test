package oasis.letu.screens.navigation

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.bottomnav.KBottomNavigationView
import io.qameta.allure.kotlin.Allure.step
import oasis.letu.screens.FavoriteScreen.assertEmptyFavoriteOpen
import oasis.letu.screens.FavoriteScreen.assertFavoriteOpen
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.сartScreens.CartScreen
import ru.letu.R
import ru.letu.ui.base.MainActivity

object BottomNavigation : KScreen<BottomNavigation>() {
    override val layoutId: Int
        get() = R.layout.fragment_main
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val bottomMenu = KBottomNavigationView { withId(R.id.bottom_navigation_view) }

    fun openBottomMenu() {
        step("Открыть экран меню") {
            bottomMenu.setSelectedItem(4)
            MenuScreen.assertMenuScreenOpen()
        }
    }
    fun openFavorite() { // с товаром
        step("Открыть избранное") {
            bottomMenu.setSelectedItem(3)
            assertFavoriteOpen()
        }
    }
    fun openEmptyFavorite() { // пустой
        step("Открыть избранное") {
            bottomMenu.setSelectedItem(3)
            assertEmptyFavoriteOpen()
        }
    }
    fun openCatalog() {
        step("Открыть экран каталог") {
            bottomMenu.setSelectedItem(1)
            // проверка отображения каталога
        }
    }

    fun openEmptyCart() {
        step("Открыть пустую корзину") {
            bottomMenu.setSelectedItem(2)
            CartScreen.assertEmptyCartOpen()
        }
    }
    fun openCart() {
        step("Открыть  корзину") {
            bottomMenu.setSelectedItem(2)
            CartScreen.assertCartOpen()
        }
    }
}
