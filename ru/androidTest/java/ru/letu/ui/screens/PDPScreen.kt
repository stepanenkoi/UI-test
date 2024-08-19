package ru.letu.ui.screens

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.scroll.KScrollView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import junit.framework.TestCase.assertTrue
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.R
import ru.letu.feature.product.ProductFragment
import ru.letu.routes.ProductRoute
import ru.letu.ui.base.DefaultTest.Companion.LONG_WAIT_TIME
import ru.letu.ui.helpers.TestUtils.getPrice
import ru.letu.ui.helpers.TestUtils.getString
import ru.letu.ui.helpers.TestUtils.getText
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertBackBtnToolBar
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertFavoriteBtnToolBar
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertLogoToolBar
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertSearchBtnToolBar
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertShareBtnToolBar
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.product.R as RProduct

object PDPScreen : KScreen<PDPScreen>() {

    override val layoutId: Int = ru.letu.feature.product.R.layout.fragment_product
    override val viewClass: Class<*> = ProductFragment::class.java

    val recyclerView = KRecyclerView(
        builder = { withId(R.id.contentRecycler) },
        itemTypeBuilder = {
            itemType(::Text)
            itemType(::BestPriceBanner)
            itemType(::Review)
            itemType(::ReviewGallery)
        }
    )

    val targetButtonView = KButton { withId(R.id.add) }
    val continueShopping = KButton { withId(RProduct.id.continue_shopping) }
    val productBannerView = KView { withId(RProduct.id.banner_view) }
    val productTitle = KTextView { withId(RProduct.id.title) }
    private val productRatingBar = KTextView { withId(RProduct.id.rating_bar) }
    private val productPrice = KTextView { withId(RProduct.id.price) }
    private val addToCart = KImageView { withId(ru.letu.feature.reviews.R.id.add_to_cart) }

    val productBtnBrandLogo = KView { withId(R.id.btnBrandLogo) }

    val brandNameTitle = KTextView {
        withId(R.id.brand_name)
    }

    val title = KTextView {
        withId(R.id.title)
    }

    val checkoutButton = KButton {
        withId(R.id.image)
        isClickable()
    }

    fun checkProductNameWithProductType(productType: String) {
        KTextView {
            withId(R.id.title)
            containsText(productType)
            isVisible()
        }
    }

    val chooseThirdProduct = Espresso.onView(
        Matchers.allOf(
            withId(R.id.sku),
            childAtPosition(
                ViewMatchers.withClassName(Matchers.`is`("android.widget.LinearLayout")),
                4
            )
        )
    )

    val productSkuOneHundred = KTextView { withText(RCoreResources.string.sku_one_hundred_ml) }
    val productSkuThirty = KTextView { withText(RCoreResources.string.sku_thirty_ml) }
    val productSkuFifty = KTextView { withText(RCoreResources.string.sku_fifty_ml) }
    val endecaRecycler = KScrollView { withId(ru.letu.core.endeca.R.id.endecaRecycler) }

    private fun childAtPosition(parentMatcher: Matcher<View>, position: Int): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent) &&
                    view == parent.getChildAt(position)
            }
        }
    }

    fun openPDP(idProduct: String) {
        step("Открыть карточку товара $idProduct") {
            featureRouter forward ProductRoute(
                link = "/product/$idProduct",
                pageInfoPath = "test"
            )
        }
        SpecifyAddressDialogScreen.assertSpecifyAddressDialogDisplayed()
    }

    fun addProductToCart() {
        waitForResponses()

        targetButtonView {
            click()
        }
    }

    // UITextCartridge::class
    class Text(parent: Matcher<View>) : KRecyclerItem<Text>(parent)

    // UIPdpBestPriceButtonCartridge::class
    class BestPriceBanner(parent: Matcher<View>) : KRecyclerItem<BestPriceBanner>(parent)

    // UIPdpReviewCartridge::class
    class Review(parent: Matcher<View>) : KRecyclerItem<Review>(parent) {

        val reviewText: KTextView = KTextView(parent) { withId(R.id.review_text) }

        val media: KRecyclerView = KRecyclerView(
            parent = parent,
            builder = { withId(ru.letu.feature.reviews.R.id.rv_media) },
            itemTypeBuilder = {
                itemType(::Media)
            }
        )

        class Media(parent: Matcher<View>) : KRecyclerItem<Media>(parent) {
            val image = KImageView(parent) { withId(ru.letu.feature.reviews.R.id.media) }
        }
    }

    // UIPdpReviewGalleryCartridge::class
    class ReviewGallery(parent: Matcher<View>) : KRecyclerItem<ReviewGallery>(parent) {
        val media: KRecyclerView = KRecyclerView(
            builder = { withMatcher(parent) },
            itemTypeBuilder = {
                itemType(::Media)
            }
        )

        class Media(parent: Matcher<View>) : KRecyclerItem<Media>(parent) {
            val image: KImageView = KImageView(parent) { withId(ru.letu.feature.reviews.R.id.media) }
        }
    }

    val imageListRecycler = KRecyclerView(
        builder = { withId(RProduct.id.image_list) },
        itemTypeBuilder = {
            itemType(::ImageListSku)
        }
    )
    class ImageListSku(parent: Matcher<View>) : KRecyclerItem<ImageListSku>(parent) {
        val skuAvailabilityOverlay = KView(parent) { withId(RProduct.id.sku_availability_overlay) }
        val skuSelectionOverlay = KView(parent) { withId(RProduct.id.sku_selection_overlay) }
        val imageSku = KImageView(parent) { withId(RProduct.id.image) }
    }

    fun assertPDPOpen() {
        step("Карточка продукта открыта") {
            assertSearchBtnToolBar()
            assertBackBtnToolBar()
            assertFavoriteBtnToolBar()
            assertShareBtnToolBar()
            productRatingBar.isDisplayed()
            productPrice.isDisplayed()
            addToCart.isDisplayed()
        }
    }

    fun assertPDPChanelOpen() {
        step("Карточка продукта Chanel открыта") {
            waitForDisplayed(R.id.brand_name, LONG_WAIT_TIME)
            assertSearchBtnToolBar()
            assertLogoToolBar()
            brandNameTitle.hasText(getString(RCoreResources.string.app_chanel_home).uppercase())
        }
    }

    fun clickSku(position: Int) {
        assertSKUNotSelected(position)
        step("Нажать на ${position + 1} SKU") {
            imageListRecycler.childAt<ImageListSku>(position) {
                click()
            }
            assertSKUSelected(position)
        }
    }

    private fun clickSkuMl(sku: Int) {
        step("Нажать на SKU ${ getString(sku) }") {
            KTextView { withText(sku) }.click()
            assertSkuMlSelected(sku)
        }
    }

    fun assertPriceSKUSelected(sku: Int) {
        step("Меняется цена при смене SKU") {
            val priceOne = getText(withId(RProduct.id.final_price))
            clickSkuMl(sku)
            val priceTwo = getText(withId(RProduct.id.final_price))
            assertTrue(priceOne?.let { getPrice(it) } != priceTwo?.let { getPrice(it) })
        }
    }

    private fun assertSKUSelected(position: Int) {
        step("SKU ${ position + 1 } выбран") {
            imageListRecycler.childAt<ImageListSku>(position) {
                skuSelectionOverlay.isDisplayed()
            }
        }
    }

    private fun assertSKUNotSelected(position: Int) {
        step("SKU ${position + 1} не выбран") {
            imageListRecycler.childAt<ImageListSku>(position) {
                skuSelectionOverlay.isNotDisplayed()
            }
        }
    }

    private fun assertSkuMlSelected(sku: Int) {
        step("SKU  ${ getString(sku) } выбран") {
            KTextView { withText(sku) }.isSelected()
        }
    }
}
