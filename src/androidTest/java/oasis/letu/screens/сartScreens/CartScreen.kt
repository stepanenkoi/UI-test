package oasis.letu.screens.сartScreens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import oasis.letu.screens.authScreens.AuthorizationScreen.assertAuthorizationScreenOpen
import oasis.letu.screens.сatalogScreens.CatalogScreen.assertCatalogScreenOpen
import ru.letu.feature.checkout.R
import ru.letu.ui.home.v1.HomeFragment

object CartScreen : KScreen<CartScreen>() {
    override val layoutId: Int
        get() = R.layout.cartridge_ui_checkout_header_empty
    override val viewClass: Class<*>
        get() = HomeFragment::class.java

    // Пустая
    val EmptyText = KTextView { withId(R.id.empty_cart_hint) }
    val EmptyDescription = KTextView { withId(R.id.empty_cart_description) }
    val CatalogButton = KButton { withId(R.id.open_catalog) }

    // С товарами
    val Icon = KImageView {
        withId(R.id.icon)
        withIndex(0) { withId(R.id.icon) }
    }
    val Checkbox = KButton { withId(R.id.checkbox) }
    val BrandName = KTextView { withId(R.id.brandName) }
    val ProductName = KTextView { withId(R.id.productDisplayName) }
    val ShadesImage = KImageView { withId(R.id.shadesImageUrl) }
    val SkuName = KTextView { withId(R.id.skuDisplayName) }
    val ErrorText = KTextView { withId(R.id.error) }
    val Minus = KImageView { withId(R.id.minus) }
    val Count = KTextView { withId(R.id.count) }
    val Plus = KImageView { withId(R.id.plus) }
    val Price = KTextView { withId(R.id.price) }
    val RawPrice = KTextView { withId(R.id.rawPrice) }
    val SalePercent = KTextView { withId(R.id.salePercent) }
    val DeleteItem = KImageView { withId(R.id.trash) }
    val AddToFavorite = KImageView { withId(R.id.like) }
    val Opt = KTextView { withId(R.id.opt) }
    val OptText = KTextView { withId(R.id.optVigoda) }
    val CheckoutButton = KButton { withId(R.id.checkout_button) }
    val DeleteItemButton = KButton { withId(ru.letu.ui.R.id.rightButton) }
    val CancelButton = KButton { withId(ru.letu.ui.R.id.leftButton) }
    val DialogText = KTextView { withId(ru.letu.ui.R.id.dialog_message) }
    val DialogTitle = KTextView { withId(ru.letu.ui.R.id.dialog_title) }

    fun assertEmptyCartOpen() {
        Allure.step("Проверка отображения экрана пустой корзины ") {
            EmptyText.isDisplayed()
            EmptyDescription.isDisplayed()
            CatalogButton.isDisplayed()
        }
    }

    fun assertCartOpen() {
        Allure.step("Проверка отображения экрана корзины ") {
            checkBrandName()
            checkProductName()
        }
    }

    fun checkImage() {
        Allure.step("Проверка отображения картинки товара") {
            Icon.isDisplayed()
        }
    }

    fun checkBrandName() {
        Allure.step("Проверка отображения бренда") {
            BrandName.isDisplayed()
        }
    }

    fun checkProductName() {
        Allure.step("Проверка отображения наименования товара") {
            ProductName.isDisplayed()
        }
    }

    fun checkPrice() {
        Allure.step("Проверка отображения цены") {
            Price.isDisplayed()
        }
    }

    fun clickCatalogButton() {
        Allure.step("Нажать на кнопку открытия Каталога ") {
            CatalogButton.click()
            assertCatalogScreenOpen()
        }
    }

    fun checkContinueButton() {
        Allure.step("Проверка отображения кнопки Continue ") {
            CheckoutButton.isDisplayed()
        }
    }

    fun clickContinueButton() { // для проверки авторизации
        Allure.step("Нажать на Continue ") {
            CheckoutButton.click()
            assertAuthorizationScreenOpen()
        }
    }

    fun clickCheckoutButton() {
        Allure.step("Нажать на Continue ") {
            CheckoutButton.click()
            // тут чекаут
        }
    }

    fun checkTrashButton() {
        Allure.step("Проверка отображения кнопки Удалить товар") {
            DeleteItem.isDisplayed()
        }
    }

    fun clickTrashButton() {
        Allure.step("Удалить товар") {
            DeleteItem.click()
            DeleteItemButton.click()
            assertEmptyCartOpen()
        }
    }

    fun checkNumberInCounter(number: String) {
        Allure.step("проверка значения $number в каунтере") {
            Count.hasText(number)
        }
    }

    fun checkPlus() {
        Allure.step("Проверить отображение плюса") {
            Plus.isDisplayed()
        }
    }

    fun clickPlus() {
        Allure.step("нажать на плюс") {
            Plus.click()
        }
    }

    fun checkMinus() {
        Allure.step("Проверить отображение минуса") {
            Minus.isDisplayed()
        }
    }

    fun clickMinus() {
        Allure.step("нажать на минус") {
            Minus.click()
        }
    }

    fun checkFavorite() {
        Allure.step("Проверить отображения сердечка") {
            AddToFavorite.click()
        }
    }

    fun addToFavorite() {
        Allure.step("нажать на сердечко") {
            AddToFavorite.click()
        }
    }
}
