package ru.letu.ui.screens

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withText
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.R
import ru.letu.routes.BrandListRoute
import ru.letu.ui.base.DefaultTest.Companion.LONG_WAIT_TIME
import ru.letu.ui.helpers.TestUtils.getText
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertSearchBtnToolBar
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertTitleToolBar
import ru.letu.core_resources.R as RCoreResources

object BrandScreen : Screen<BrandScreen>() {
    private val brandsContentList = KTextView { withId(R.id.brands_content_list) }
    private val popularBrandsTitle = KTextView {
        withId(R.id.name)
        withText(RCoreResources.string.app_popular_brands)
    }

    private val alphabetList = KView { withId(R.id.alphabet_list) }
    private val tagList = KView { withId(R.id.tag_list) }

    private val featuredBrandsRecycler = KRecyclerView(
        builder = {
            withId(R.id.featured_brands)
        },
        itemTypeBuilder = {
            itemType(::FeaturedBrandsItem)
        }
    )

    class FeaturedBrandsItem(parent: Matcher<View>) : KRecyclerItem<FeaturedBrandsItem>(parent) {
        val alphabetList = KView(parent) { withId(R.id.alphabet_list) }
    }

    fun openBrandList() {
        step("Открыть экран брендов") {
            featureRouter forward BrandListRoute.list()
            assertBrandListOpen()
        }
    }

    fun clickFeaturedBrandsItem(position: Int) {
        step("Нажать на ${ position + 1 } бренд в каруселе") {
            featuredBrandsRecycler.childAt<FeaturedBrandsItem>(position) {
                click()
            }
            PLPScreen.assertPLPBrandOpen()
        }
    }

    fun clickBrandName(name: Int) {
        step("Нажать на бренд ${ getText(withText(name)) }") {
            waitForDisplayed(R.id.name, LONG_WAIT_TIME)
            KTextView {
                withId(R.id.name)
                withText(name)
            }.click()
            PLPScreen {
                assertPLPBrandOpen()
                assertPLPBrandNameOpen(name)
            }
        }
    }

    fun scrollBrands() {
        step("Пролистать карусель") {
            featuredBrandsRecycler.scrollToEnd()
            featuredBrandsRecycler.scrollToStart()
        }
    }

    fun assertBrandListOpen() {
        step("Экран брендов открыт") {
            assertTitleToolBar(RCoreResources.string.app_brands)
            assertSearchBtnToolBar()
            featuredBrandsRecycler.isDisplayed()
        }
    }

    fun assertBrandList() {
        step("Проверка основных элементов экрана брендов") {
            waitForDisplayed(R.id.alphabet_list, LONG_WAIT_TIME)
            brandsContentList.isDisplayed()
            popularBrandsTitle.isDisplayed()
            featuredBrandsRecycler.isDisplayed()
            alphabetList.isDisplayed()
            tagList.isDisplayed()
        }
    }
}
