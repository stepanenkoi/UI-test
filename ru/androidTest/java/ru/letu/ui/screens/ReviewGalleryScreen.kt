package ru.letu.ui.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.feature.reviews.ui.media.ProductMediaGalleryFragment
import ru.letu.ui.screens.bottomsheet.SkuListCirclesBottomSheetScreen.assertSKUListWithCircles
import ru.letu.core.endeca.R as REndeca
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.product.R as RProduct
import ru.letu.feature.reviews.R as Reviews

object ReviewGalleryScreen : KScreen<ReviewGalleryScreen>() {

    override val layoutId: Int = ru.letu.feature.reviews.R.layout.fragment_pdp_media_gallery
    override val viewClass: Class<*> = ProductMediaGalleryFragment::class.java

    val author = KTextView { withId(Reviews.id.review_author) }
    val readReview = KTextView { withId(Reviews.id.tv_read_review) }

    val productTitle = KTextView { withId(Reviews.id.product_title) }
    val productBrand = KTextView { withId(Reviews.id.product_brand) }
    val productPrice = KTextView { withId(Reviews.id.product_price) }
    val productOldPrice = KTextView { withId(Reviews.id.product_old_price) }

    val addToCart = KImageView { withId(Reviews.id.add_to_cart) }
    val inCart = KImageView { withId(Reviews.id.in_cart) }

    val productInfoCarousel = KView { withId(REndeca.id.product_info_carousel) }
    private val productBannerView = KView { withId(RProduct.id.banner_view) }
    private val productAddCartContainer = KView { withId(RProduct.id.add_cart_container) }

    private val productCartBtnDesc = KTextView {
        withId(RProduct.id.cart_button_description)
        withText(RCoreResources.string.app_in_cart)
    }
    private val productOpenMoreBtn = KButton { withId(RProduct.id.open_more_button) }

    fun clickAddToCart() {
        step("Нажать добавить в корзину") {
            addToCart.click()
            assertProductAddCart()
        }
    }

    fun clickOpenMoreBtn() {
        step("Нажать на кнопку Все n вариантов") {
            productOpenMoreBtn.click()
            assertSKUListWithCircles()
        }
    }

    fun assertProductOpen() {
        step("Карточка товара открыта") {
            productBannerView.isDisplayed()
            productAddCartContainer.isDisplayed()
            addToCart.isDisplayed()
        }
    }

    private fun assertProductAddCart() {
        step("Товар добавлен в корзину") {
            productCartBtnDesc.isDisplayed()
        }
    }
}
