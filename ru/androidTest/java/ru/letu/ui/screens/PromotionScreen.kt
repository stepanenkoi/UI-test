package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.core_resources.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.feature.loyalty.R as RLoyalty

object PromotionScreen : Screen<PromotionScreen>() {

    private val promoCodeDesc = KTextView { withId(RLoyalty.id.txt_promo_code_description_text) }
    val promoCodeRemainedDate = KView { withId(RLoyalty.id.txt_promo_code_remained_date_text) }
    val borderPromoCode = KTextView { withId(RLoyalty.id.border_promo_code) }
    val cardViewImage = KView { withId(RLoyalty.id.cardViewImage) }
    val promotionConditionText = KTextView { withId(RLoyalty.id.promotion_condition_text) }

    fun assertPromotionScreen() {
        step("Акция открыта") {
            ToolBarElementScreen {
                assertTitleToolBar(R.string.promotion)
                assertBackBtnToolBar()
            }
            promoCodeDesc.isDisplayed()
        }
    }
}
