package oasis.letu.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.swiperefresh.KSwipeRefreshLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import ru.letu.feature.wishlist.R
import ru.letu.ui.home.v1.HomeFragment

object FavoriteScreen : KScreen<FavoriteScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_favorite
    override val viewClass: Class<*>
        get() = HomeFragment::class.java

    // пустой
    val Title = KTextView {
        withId(ru.letu.R.id.title)
        withText(ru.letu.core_resources.R.string.app_favorite)
    }
    val Image = KImageView { withId(R.id.heartImage) }
    val Text = KTextView {
        withId(R.id.text)
        withText(ru.letu.core_resources.R.string.app_favorite_empty)
    }

    fun checkTitle() {
        Allure.step("проверка отображения заголовка") {
            Title.isDisplayed()
        }
    }

    fun checkImage() {
        Allure.step("проверка отображения картинки") {
            Image.isDisplayed()
        }
    }

    fun checkText() {
        Allure.step("проверка отображения текста") {
            Text.isDisplayed()
        }
    }

    fun assertEmptyFavoriteOpen() {
        Allure.step("Проверка отображения экрана избранного ") {
            checkTitle()
            checkImage()
            checkText()
        }
    }

    // с товаром
    val PlpImage = KImageView {
        withId(ru.letu.R.id.image_container)
        withIndex(0) { withId(ru.letu.R.id.image_container) }
    }

    //    val PlpBrandName = KTextView { withId(ru.letu.R.id.brand_name) }
    val PlpName = KTextView {
        withId(ru.letu.R.id.text_product_name)
        withIndex(0) { withId(ru.letu.R.id.text_product_name) }
    }
    val RatingBar = KImageView { withId(ru.letu.R.id.rating_bar) }
    val ReviewsCount = KTextView { withId(ru.letu.R.id.reviews_count) }
    val AddToCartButton = KButton { withId(ru.letu.R.id.cart_button) }
    val Unavailable = KTextView { withId(ru.letu.R.id.text_unavailable) }
    val Price = KTextView { withId(ru.letu.R.id.price_layout) }
    val RawPrice = KTextView { withId(ru.letu.R.id.text_raw_price) }
    val Discount = KTextView { withId(ru.letu.R.id.text_discount_price) }
    val DiscountPercent = KTextView { withId(ru.letu.R.id.text_discount_percent) }
    val PriceText = KTextView { withId(ru.letu.R.id.text_price) }

    fun checkProdImage() {
        Allure.step("проверка отображения фото товара") {
            PlpImage.isDisplayed()
        }
    }

    //    fun checkBrandName() {
//        Allure.step("проверка отображения имени бренда") {
//            PlpBrandName.isDisplayed()
//        }
//    }
    fun checkProdName() {
        Allure.step("проверка отображения имени товара") {
            PlpName.isDisplayed()
        }
    }
    fun clickProdName() {
        Allure.step("кликнуть товар") {
            PlpName.click()
        }
    }

    fun checkAddToCartButton() {
        Allure.step("проверка отображения добавить в корзину") {
            AddToCartButton.isDisplayed()
        }
    }

    fun clickAddToCartButton() {
        Allure.step("нажать кнопку добавить в корзину") {
            AddToCartButton.click()
        }
    }

    fun checkPrice() {
        Allure.step("проверка отображения цены") {
            PriceText.isDisplayed()
        }
    }

    fun clickImage() {
        Allure.step("нажать кнопку добавить в корзину") {
            AddToCartButton.click()
        }
    }

    val FavoriteButton = KCheckBox {
        withId(ru.letu.R.id.check_box_favourite)
        withIndex(0) { withId(ru.letu.R.id.check_box_favourite) }
    }

    fun clickFavorite() {
        Allure.step("Нажать на сердечко") {
            FavoriteButton.click()
        }
    }

    fun assertFavoriteOpen() {
        Allure.step("Проверка отображения экрана избранного ") {
            checkTitle()
            checkProdImage()
            checkProdName()
        }
    }

    val swipeRefresh = KSwipeRefreshLayout {
        withId(R.id.swipe_refresh)
        withIndex(0) { withId(R.id.swipe_refresh) }
    }
}
