package ru.letu.ui.screens.bottomsheet

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.ui.screens.PLPScreen
import ru.letu.core_resources.R as RCoreResources

object SortPlpBottomSheetScreen : Screen<SortPlpBottomSheetScreen>() {

    val plpSortingTitle = KTextView { withText(RCoreResources.string.plp_sorting) }
    val plpSortingPopular = KTextView { withText(RCoreResources.string.plp_sort_option_popular) }
    val plpSortingPriceDesc = KTextView { withText(RCoreResources.string.plp_sort_option_price_desc) }
    val plpSortingPriceAsc = KTextView { withText(RCoreResources.string.plp_sort_option_price_asc) }
    val plpSortingDate = KTextView { withText(RCoreResources.string.plp_sort_option_date) }
    val plpSortingReviews = KTextView { withText(RCoreResources.string.plp_sort_option_reviews) }
    val plpSortingDiscount = KTextView { withText(RCoreResources.string.plp_sort_option_discount) }
    val plpSortingRating = KTextView { withText(RCoreResources.string.plp_sort_option_rating) }

    fun clickSortingPriceAsc() {
        step("Нажать на По возрастанию цены") {
            plpSortingPriceAsc.click()
            PLPScreen.assertSortByHigherPrice()
        }
    }

    fun assertSortPlpBottomOpen() {
        step("Боттом сортироки открыт") {
            plpSortingTitle.isDisplayed()
            plpSortingPopular.isDisplayed()
            plpSortingPriceDesc.isDisplayed()
            plpSortingPriceAsc.isDisplayed()
            plpSortingDate.isDisplayed()
            plpSortingReviews.isDisplayed()
            plpSortingDiscount.isDisplayed()
            plpSortingRating.isDisplayed()
        }
    }
}
