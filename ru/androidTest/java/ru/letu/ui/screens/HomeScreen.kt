package ru.letu.ui.screens

import android.view.View
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.pager.KViewPager
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.base.DefaultTest.Companion.WAIT_TIME
import ru.letu.ui.helpers.TestUtils.getString
import ru.letu.ui.home.v2.HomeFragmentV2
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.helpers.utils.kview.KBannerView
import ru.letu.ui.screens.dialogscreen.PermissionDialogUiScreen.assertPermissionDialogOpen
import ru.letu.core_resources.R as RCoreResources

object HomeScreen : LetuKScreen<HomeScreen>(R.layout.fragment_home_v2, HomeFragmentV2::class.java, R.id.home) {

    val recyclerView = KRecyclerView(
        builder = { withId(R.id.endeca_view) },
        itemTypeBuilder = {
            itemType(HomeScreen::BannerCartridge)
        }
    )

    private val home = KView { withId(R.id.home) }
    private val showAllBtn = KButton {
        withId(R.id.button)
        withText(RCoreResources.string.show_all)
    }

    private val categoryTitle = KTextView { withId(R.id.category_title) }

    private fun assertCategoryOpen(title: Int) {
        categoryTitle.hasText(getString(title))
    }

    class BannerCartridge(parent: Matcher<View>) : KRecyclerItem<BannerCartridge>(parent) {
        val bannerView = KBannerView(parent) {
            withId(ru.letu.feature.banners.R.id.bannerView)
        }

        val bannerVP = KViewPager(parent) {
            withId(ru.letu.feature.banners.R.id.viewPager)
        }
    }

    fun clickShowAllBtn(title: Int) {
        step("Нажать Показать всё") {
            showAllBtn.click()
            assertCategoryOpen(title)
        }
    }

    fun assertHomeScreenOpen() {
        step("Главный экран открыт") {
            waitForDisplayed(R.id.home, WAIT_TIME)
            home.isDisplayed()
        }
    }

    fun assertShowAllBtnDisplayed() {
        step("Кнопка Показать всё отображается") {
            showAllBtn.isDisplayed()
        }
    }

    object HomeUiScreen : UiScreen<HomeUiScreen>() {
        override val packageName: String = "ru.letu.preprod"

        private val barcodeBtn = UiView {
            withId(this@HomeUiScreen.packageName, "barcode")
            withClassName("android.widget.ImageView")
        }

        private val endecaRecycler = UiScrollView {
            withDescendant {
                withId(this@HomeUiScreen.packageName, "search_button")
                withClassName("android.widget.FrameLayout")
            }
            withId(this@HomeUiScreen.packageName, "endecaRecycler")
            withClassName("android.widget.GridView")
        }

        private val endeca = UiTextView {
            withId(this@HomeUiScreen.packageName, "tag")
            withText(RCoreResources.string.new_items)
            withClassName("android.widget.TextView")
        }

        private val recyclerSections = UiView {
            withId(this@HomeUiScreen.packageName, "recycler_sections")
            withClassName("androidx.recyclerview.widget.RecyclerView")
            withDescendant {
                withId(this@HomeUiScreen.packageName, "tag")
                withText(RCoreResources.string.new_items)
                withClassName("android.widget.TextView")
            }
        }

        fun clickBarcodeBtn() {
            step("Нажать на кнопку сканирования штрихкода") {
                barcodeBtn.click()
                assertPermissionDialogOpen()
            }
        }

        fun scrollToRecyclerSections() {
            step("Проскролить экран до Новинок") {
                endecaRecycler.scrollToView(recyclerSections)
                endeca.isDisplayed()
            }
        }

        fun clickEndeca() {
            step("Нажать Новинки") {
                endeca.click()
                assertShowAllBtnDisplayed()
            }
        }
    }
}
