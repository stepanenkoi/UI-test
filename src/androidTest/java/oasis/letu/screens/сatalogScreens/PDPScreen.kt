package oasis.letu.screens.сatalogScreens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import oasis.letu.helper.TestUtils
import oasis.letu.screens.authScreens.AuthorizationScreen
import ru.letu.feature.product.R
import ru.letu.feature.product.ProductFragment
import ru.letu.feature.product.ProductRoute
import ru.letu.feature.product.models.oasis.ProductArticle
import ru.letu.navigation.core.routing.featureRouter

object PDPScreen : KScreen<PDPScreen>() {

    override val layoutId: Int
        get() = R.layout.fragment_product // менять

    override
    val viewClass: Class<*>
        get() = ProductFragment::class.java

    // есть в наличии
    val recycler = KRecyclerView(
        {
            withId(ru.letu.core.endeca.R.id.endecaRecycler)
            withDescendant { withId(R.id.title) }
        },
        {
            itemType(AuthorizationScreen::RecyclerClass)
        }
    )
    val Image = KImageView {
        withId(R.id.image)
        withIndex(0) { withId(R.id.image) }
    }
    val Name = KTextView {
        withId(R.id.title)
        withIndex(0) { withId(R.id.title) }
    }
    val Price = KTextView {
        withId(R.id.title)
        withIndex(1) { withId(R.id.title) }
    }
    val ProductDescriptionButton = KButton { withId(R.id.open_description_button) }
    val Article = KTextView { withId(R.id.article) }
    val AllSku = KTextView { withId(R.id.open_more_text) }
    val SkuName1 = KTextView {
        withId(R.id.sku_name)
        withIndex(0) { withId(R.id.sku_name) }
    }
    val SkuName2 = KTextView {
        withId(R.id.sku_name)
        withIndex(1) { withId(R.id.sku_name) }
    }
    val SkuImage1 = KImageView {
        withId(R.id.image)
        withIndex(1) { withId(R.id.image) }
    }
    val SkuImage3 = KImageView {
        withId(R.id.image)
        withIndex(2) { withId(R.id.image) }
    }
    val ProductDescription = KTextView { withId(R.id.button_text) }
    val ProductDescriptionText = KTextView {
        withId(R.id.title)
        withIndex(2) { withId(R.id.title) }
    }
    val RawPrice = KTextView { withId(R.id.raw_price) }
    val DiscountPercent = KTextView { withId(R.id.discount_percent) }
    val Description = KTextView { withId(R.id.description) }
    val InTheCartText = KTextView { withId(R.id.cart_button_description) }
    val AddToCartButton = KTextView { withId(R.id.add_to_cart) }
    val Minus = KButton { withId(R.id.remove_from_cart_button) }
    val Plus = KButton { withId(R.id.add_to_cart_button) }
    val Count = KTextView { withId(R.id.in_cart_count) }
    val FavoriteButton = KButton { withId(ru.letu.R.id.favorite) }

    fun checkImage() {
        Allure.step("Проверка отображения изображения товара") {
            Image.isDisplayed()
        }
    }

    fun checkName() {
        Allure.step("Проверка отображения наименования товара") {
            Name.isDisplayed()
        }
    }

    fun checkArticle() {
        Allure.step("Проверка отображения артикуля") {
            Article.isDisplayed()
        }
    }
    fun checkSKU1Article() {
        Allure.step("Проверка отображения артикуля 1й SKU") {
            Article.containsText("DBM000003")
        }
    }
    fun checkSKU2Article() {
        Allure.step("Проверка отображения артикуля 2й SKU") {
            Article.containsText("DBM000004")
        }
    }
    fun checkSKU3Article() {
        Allure.step("Проверка отображения артикуля 3й SKU") {
            Article.containsText("DBM000001")
        }
    }

    fun checkPDButton() {
        Allure.step("Проверка отображения кнопки Product Description") {
            ProductDescription.isDisplayed()
        }
    }

    fun checkPDText() {
        Allure.step("Проверка отображения текста Product Description") {
            ProductDescriptionText.isDisplayed()
        }
    }

    fun checkPrice() {
        Allure.step("Проверка отображения цены") {
            Price.isDisplayed()
        }
    }

    fun checkRawPrice() {
        Allure.step("Проверка отображения цены без скидки") {
            RawPrice.isDisplayed()
        }
    }

    fun checkDiscount() {
        Allure.step("Проверка отображения  скидки") {
            DiscountPercent.isDisplayed()
        }
    }

    fun checkSkuName1() {
        Allure.step("Проверка отображения SKU 1 в виде текста") {
            SkuName1.isDisplayed()
        }
    }

    fun checkSkuName2() {
        Allure.step("Проверка отображения SKU 2 в виде текста") {
            SkuName2.isDisplayed()
        }
    }

    fun clickSkuName1() {
        Allure.step("Нажать на  SKU 1 ") {
            SkuName1.click()
        }
    }

    fun clickSkuName2() {
        Allure.step("Нажать на  SKU 2") {
            SkuName2.click()
        }
    }

    fun checkSkuImage1() {
        Allure.step("Проверка отображения SKU 1 в виде картинки ") {
            SkuImage1.isDisplayed()
        }
    }

    fun checkSkuImage2() {
        Allure.step("Проверка отображения SKU 2 в виде картинки ") {
            SkuImage3.isDisplayed()
        }
    }

    fun clickSkuImage2() {
        Allure.step("Нажать на SKU 2 в виде картинки ") {
            SkuImage1.click()
        }
    }

    fun clickSkuImage3() {
        Allure.step("Нажать на SKU 3 в виде картинки ") {
            SkuImage3.click()
        }
    }

    fun scrollToBottom() {
        onView(TestUtils.withIndex(ViewMatchers.withId(ru.letu.core.endeca.R.id.title), 5))
            .perform(ViewActions.scrollTo())
    }

    fun scrollToBottom1() {
        onView(TestUtils.withIndex(ViewMatchers.withId(ru.letu.core.endeca.R.id.title), 2))
            .perform(ViewActions.scrollTo())
    }

    fun clickBack() {
        onView(isRoot()).perform(ViewActions.pressBack())
    }

    fun getOutOfStockPdp() {
        Allure.step("Открыть PDP") {
            featureRouter forward ProductRoute(
                article = ProductArticle("CAV009000"),
                pageInfoPath = "/home",
                cartridgeId = null,
                eventSource = "REC_SHELF".takeIf { false }
            )
        }
    }

    fun checkFavoriteButton() {
        Allure.step("Проверка отображения кнопки сердечка") {
            FavoriteButton.isDisplayed()
        }
    }

    fun clickFavoriteButton() {
        Allure.step("Нажать на  сердечко") {
            FavoriteButton.click()
        }
    }

    fun getSKUPdp() {
        Allure.step("Открыть PDP") {
            featureRouter forward ProductRoute(
                article = ProductArticle("DBM000003"),
                pageInfoPath = "/home",
                cartridgeId = null,
                eventSource = "REC_SHELF".takeIf { false }
            )
        }
    }

    fun getPdp() {
        Allure.step("Открыть PDP") {
            featureRouter forward ProductRoute(
                article = ProductArticle("KDL000078"),
                pageInfoPath = "/home",
                cartridgeId = null,
                eventSource = "REC_SHELF".takeIf { false }
            )
        }
    }

    fun scrollToEnd() {
        Allure.step("Проскролить экран до конца") {
            recycler.scrollToEnd()
        }
    }

    fun checkAddToCartButton() {
        Allure.step("проверка отображения кнопки Add to cart") {
            AddToCartButton.isDisplayed()
        }
    }

    fun clickAddToCartButton() {
        Allure.step("Добавить товар в корзину") {
            AddToCartButton.click()
        }
    }

    fun checkCounter() {
        Allure.step("Проверка отображения каунтера") {
            Count.isDisplayed()
        }
    }

    fun clickCounter() {
        Allure.step("Перейти в корзину") {
            Count.click()
        }
    }

    fun check1InCounter() {
        Allure.step("В коунтере отображается 1") {
            Count.containsText("1")
        }
    }

    fun check2InCounter() {
        Allure.step("В коунтере отображается 2") {
            Count.containsText("2")
        }
    }

    fun checkMinus() {
        Allure.step("Проверка отображения кнопки Минус") {
            Minus.isDisplayed()
        }
    }

    fun clickMinus() {
        Allure.step("Нажать на  кнопку Минус") {
            Minus.click()
        }
    }

    fun checkPlus() {
        Allure.step("Проверка отображения кнопки Плюс") {
            Plus.isDisplayed()
        }
    }

    fun clickPlus() {
        Allure.step("Нажать на  кнопку Плюс") {
            Plus.click()
        }
    }
    fun checkDescription() {
        Allure.step("Проверка отображения Out of Stock") {
            Description.isDisplayed()
        }
    }
}
