package ru.letu.ui.screens.bottomsheet

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.feature.product.R

object SkuListCirclesBottomSheetScreen : Screen<SkuListCirclesBottomSheetScreen>() {

    val skuListCirclesTitle = KTextView {
        withId(R.id.title)
        withText(ru.letu.core_resources.R.string.app_sku_selectore_choice_title)
    }
    val skuListCircles = KView { withId(R.id.sku_list) }

    fun assertSKUListWithCircles() {
       step("Список SKU с кружками") {
            skuListCirclesTitle.isDisplayed()
            skuListCircles.isDisplayed()
            skuListCircles {
                hasDescendant { withId(R.id.sku_color) }
                hasDescendant { withId(R.id.title) }
                hasDescendant { withId(R.id.check_icon) }
            }
        }
    }
}
