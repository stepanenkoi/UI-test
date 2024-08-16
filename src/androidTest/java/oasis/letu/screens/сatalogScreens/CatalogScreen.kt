package oasis.letu.screens.сatalogScreens

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.qameta.allure.kotlin.Allure
import oasis.letu.helper.TestUtils
import oasis.letu.helper.isVisible
import ru.letu.feature.catalog.R.id
import ru.letu.feature.catalog.R.layout
import ru.letu.ui.base.MainActivity

object CatalogScreen : KScreen<CatalogScreen>() {
    override val layoutId: Int
        get() = layout.cartridge_ui_catalog
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val categoryName1 = KImageView {
        withId(id.categoryName)
        withIndex(0) { withId(id.categoryName) }
    }
    val categoryName2 = KImageView {
        withId(id.categoryName)
        withIndex(1) { withId(id.categoryName) }
    }
    val imageCategory1 = KImageView {
        withId(id.imageCategory)
        withIndex(0) { withId(id.imageCategory) }
    }
    val ImageCategory2 = KImageView {
        withId(id.imageCategory)
        withIndex(1) { withId(id.imageCategory) }
    }

    fun checkName1() {
        Allure.step("проверка отображения наименования 1й категории") {
            categoryName1.isDisplayed()
        }
    }

    fun clickName1() {
        Allure.step("открыть первую категорию") {
            categoryName1.click()
        }
    }

    fun clickName2() {
        Espresso
            .onView(TestUtils.withIndex(ViewMatchers.withId(id.categoryName), 2))
            .perform(ViewActions.click())
    }

    fun clickName3() {
        Espresso
            .onView(TestUtils.withIndex(ViewMatchers.withId(id.categoryName), 3))
            .perform(ViewActions.click())
    }

    fun checkImage() {
        Espresso.onView(TestUtils.withIndex(ViewMatchers.withId(id.imageCategory), 0)).isVisible()
    }

    fun assertCatalogScreenOpen() {
        Allure.step("Проверка отображения экрана Каталог") {
            checkName1()
            checkImage()
        }
    }
}
