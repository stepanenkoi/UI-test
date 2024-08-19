package ru.letu.ui.screens

import android.view.View
import androidx.test.espresso.ViewInteraction
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KProgressBar
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.feature.checkout.fragment.CartFragment
import ru.letu.ui.R
import ru.letu.ui.base.DefaultTest.Companion.LONG_WAIT_TIME
import ru.letu.ui.helpers.childViewById
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.dialogscreen.DelCartDialogScreen
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core.endeca.R as REndeca
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.checkout.R as RCheckout

object CartScreen : LetuKScreen<CartScreen>(
    RCheckout.layout.fragment_cart,
    CartFragment::class.java,
    RCheckout.id.cart
) {
    val toolbar = KToolbar { withId(R.id.toolbar_main) }
    val toolbarImage: ViewInteraction = childViewById(R.id.toolbar_main, R.id.toolbar_logo)
    val toolbarSearchMenu: ViewInteraction = childViewById(R.id.toolbar_main, R.id.search)

    val toolbarSearch = KView { withId(R.id.toolbar_search) }
    private val cityDestination = KTextView {
        isDescendantOfA { withId(RCheckout.id.cityContainer) }
        withText(RCoreResources.string.checkout_cart_city_destination)
    }

    private val cityName = KTextView {
        isDescendantOfA { withId(RCheckout.id.cityContainer) }
        withId(RCheckout.id.cityName)
    }

    private val checkoutCartSelectedAll = KTextView {
        withText(RCoreResources.string.checkout_cart_selected_all)
        withId(RCheckout.id.checkbox)
    }

    private val removeSelected = KTextView {
        withText(RCoreResources.string.app_cart_remove_selected)
        withId(RCheckout.id.removeSelected)
    }

    private val checkoutCartBtn = KButton {
        withIndex(0) {
            withText(RCoreResources.string.checkout_cart_continue)
        }
    }

    private val cartText = KButton {
        withIndex(1) {
            withText(RCoreResources.string.app_cart_new)
        }
    }

    val productCheckbox = KCheckBox { withId(R.id.checkbox) }
    val productNplBonuses = KTextView { withId(RCheckout.id.nplBonuses) }
    val productLike = KImageView { withId(RCheckout.id.like) }
    val productTrash = KImageView { withId(RCheckout.id.trash) }
    val productIcon = KImageView { withId(R.id.icon) }

    val productBrandName = KCheckBox { withId(RCheckout.id.brandName) }
    val productDisplayName = KTextView { withId(RCheckout.id.productDisplayName) }
    val productSkuName = KImageView { withId(RCheckout.id.skuDisplayName) }
    val productPrice = KImageView { withId(RCheckout.id.price) }
    val productPriceBlock = KImageView { withId(RCheckout.id.priceBlock) }
    val productLinearSale = KTextView { withText(RCheckout.id.linearSaleSection) }
    val productCounter = KTextView { withText(RCheckout.id.counter) }
    val productMinus = KImageView { withText(RCheckout.id.minus) }
    val productCount = KTextView { withText(RCheckout.id.count) }
    val productPlus = KImageView { withText(RCheckout.id.plus) }

    private val couponsTitle = KTextView {
        withId(RCheckout.id.text_coupons_carousel_title)
        withText(RCheckout.string.apply_coupon_title)
    }

    private val totalPriceTitle = KTextView {
        withId(RCheckout.id.title)
        withText(RCoreResources.string.checkout_total_header)
    }

    val leftTitle = KTextView {
        isDescendantOfA { withId(RCheckout.id.shadow) }
        withId(RCheckout.id.left)
    }

    val rightTitle = KTextView {
        isDescendantOfA { withId(RCheckout.id.shadow) }
        withId(RCheckout.id.right)
    }

    private val shadow = KView { withId(RCheckout.id.shadow) }
    private val containerDelivery = KView { withId(RCheckout.id.container_delivery) }
    private val progressDelivery = KProgressBar { withId(RCheckout.id.progress_delivery) }
    private val textDelivery = KTextView { withId(RCheckout.id.text_delivery) }
    private val priceFlow = KView { withId(RCheckout.id.priceFlow) }
    private val totalPrice = KView { withId(RCheckout.id.totalPrice) }
    private val priceWithoutDiscount = KView { withId(RCheckout.id.priceWithoutDiscount) }
    private val salePercent = KTextView {
        isDescendantOfA { withId(RCheckout.id.container) }
        withId(RCheckout.id.salePercent)
    }
    private val bonusesBlock = KView { withId(RCheckout.id.bonusesBlock) }
    private val payBtnTitle = KTextView {
        withId(RCheckout.id.pay_button_title)
        withText(RCoreResources.string.checkout_cart_continue)
    }
    private val emptyCart = KView { withId(RCheckout.id.emptyCart) }

    val recyclerView = KRecyclerView(
        builder = {
            isDescendantOfA { withId(RCheckout.id.endecaView) }
            withId(REndeca.id.endecaRecycler)
        },
        itemTypeBuilder = {
            itemType(CartScreen::HeaderCartridge)
            itemType(CartScreen::CommerceItemCartridge)
        }
    )

    private val recyclerCoupon = KRecyclerView(
        builder = {
            withId(RCheckout.id.recycler_coupon_list)
        },
        itemTypeBuilder = {
            itemType(CartScreen::CouponItem)
        }
    )

    class CouponItem(parent: Matcher<View>) : KRecyclerItem<CouponItem>(parent) {
        val textAmount = KTextView(parent) { withId(RCheckout.id.text_amount) }
        val textDescription = KTextView(parent) { withId(RCheckout.id.text_description) }
        val switchCoupon = KSwitch(parent) { withId(RCheckout.id.switch_activate_coupon) }
        val textMostProfitable = KTextView(parent) {
            withText(RCoreResources.string.coupon_is_most_profitable)
            withId(RCheckout.id.text_most_profitable)
        }
    }

    class HeaderCartridge(parent: Matcher<View>) : KRecyclerItem<HeaderCartridge>(parent) {
        val openAction = KView(parent) { withId(RCheckout.id.open_action) }
        val openCatalog = KView(parent) { withId(RCheckout.id.open_catalog) }
        val emptyCart = KView(parent) { withId(RCheckout.id.emptyCart) }
    }

    class ProductItem(parent: Matcher<View>) : KRecyclerItem<CommerceItemCartridge>(parent) {
        val productCheckbox = KCheckBox(parent) { withId(R.id.checkbox) }
    }

    fun clickCheckoutBtn() {
        step("Нажать на кнопку Продолжить") {
            checkoutCartBtn.click()
            ToolBarElementScreen.assertTitleToolBarIndex(1, RCoreResources.string.app_checkout_toolbar_title)
        }
    }

    fun clickTrashBtn(index: Int) {
        step("Нажать на пиктограмму с мусорной корзиной") {
            KImageView {
                isDescendantOfA { withId(REndeca.id.endecaRecycler) }
                withIndex(index) { withId(RCheckout.id.trash) }
            }.click()
        }
    }

    fun clickTrashBtn() {
        step("Нажать на пиктограмму с мусорной корзиной в карточке первого товара") {
            CartUiScreen.trash.click()
            DelCartDialogScreen.assertDelCartDialogOpen()
        }
    }

    fun clickMinusBtn() {
        step("Нажать на минус") {
            CartUiScreen.minus.click()
            assertCartIsEmpty()
        }
    }

    fun clickRemoveSelected() {
        step("Нажать на Удалить выбранные") {
            CartUiScreen.removeSelected.click()
            DelCartDialogScreen.assertDelCartDialogOpen()
        }
    }

    fun assertCartScreenOpen() {
        step("Экран Корзина открыт") {
            recyclerView.isDisplayed()
            cartText.isDisplayed()
        }
    }

    fun assertCartIsEmpty() {
        step("Корзина пуста") {
            waitForDisplayed(RCheckout.id.emptyCart, LONG_WAIT_TIME)
            emptyCart.isDisplayed()
        }
    }

    fun assertCartScreen() {
        step("Экран Корзина открыт") {
            recyclerView.isDisplayed()
            recyclerView.hasDescendant { withText(RCoreResources.string.app_cart_new) }
            cityDestination.isDisplayed()
            cityName.isDisplayed()
            checkoutCartSelectedAll.isDisplayed()
            removeSelected.isDisplayed()
        }
    }

    fun assertProductItem(position: Int) {
        step("Проверка элементов ${position + 1} -й Карточки товара в Корзине") {
            KCheckBox { withIndex(position) { withId(R.id.checkbox) } }.isDisplayed()
            KTextView { withIndex(position) { withId(RCheckout.id.nplBonuses) } }.isDisplayed()
            KImageView { withIndex(position) { withId(RCheckout.id.like) } }.isDisplayed()
            KImageView { withIndex(position) { withId(RCheckout.id.trash) } }.isDisplayed()
            KImageView { withIndex(position) { withId(R.id.icon) } }.isDisplayed()

            KCheckBox { withIndex(position) { withId(RCheckout.id.brandName) } }.isDisplayed()
            KTextView { withIndex(position) { withId(RCheckout.id.productDisplayName) } }.isDisplayed()
            KImageView { withIndex(position) { withId(RCheckout.id.skuDisplayName) } }.isDisplayed()
            KImageView { withIndex(position) { withId(RCheckout.id.price) } }.isDisplayed()
            KImageView { withIndex(position) { withId(RCheckout.id.priceBlock) } }.isDisplayed()
            KView { withIndex(position) { withId(RCheckout.id.linearSaleSection) } }.isDisplayed()
            KTextView { withIndex(position) { withId(RCheckout.id.counter) } }.isDisplayed()
            KImageView { withIndex(position) { withId(RCheckout.id.minus) } }.isDisplayed()
            KTextView { withIndex(position) { withId(RCheckout.id.count) } }.isDisplayed()
            KImageView { withIndex(position) { withId(RCheckout.id.plus) } }.isDisplayed()
        }
    }

    fun assertCouponsDisplayed(position: Int) {
        step("Проверка отображения основых элементов ${position + 1} купона") {
            couponsTitle.isDisplayed()
            recyclerCoupon.childAt<CouponItem>(position) {
                textAmount.isDisplayed()
                textDescription.isDisplayed()
                switchCoupon.isDisplayed()
            }
        }
    }

    fun assertOrderAmountBlockDisplayed() {
        step("Проверка отображения основых элементов блока Сумма заказа") {
            totalPriceTitle.isDisplayed()
            shadow.isDisplayed()
            containerDelivery.isDisplayed()
            progressDelivery.isDisplayed()
            textDelivery.isDisplayed()
            priceFlow.isDisplayed()
            totalPrice.isDisplayed()
            priceWithoutDiscount.isDisplayed()
            salePercent.isDisplayed()
            bonusesBlock.isDisplayed()
            payBtnTitle.isDisplayed()
        }
    }

    class CommerceItemCartridge(parent: Matcher<View>) : KRecyclerItem<CommerceItemCartridge>(parent) {
        val cartTitle = KTextView(parent) { withText(RCoreResources.string.app_cart_new) }
    }

    object CartUiScreen : UiScreen<CartUiScreen>() {
        override val packageName: String = "ru.letu.preprod"

        val trash = UiView {
            withId(this@CartUiScreen.packageName, "trash")
            withClassName("android.widget.ImageView")
        }

        val minus = UiView {
            withId(this@CartUiScreen.packageName, "minus")
            withClassName("android.widget.ImageView")
        }

        val removeSelected = UiTextView {
            withId(this@CartUiScreen.packageName, "removeSelected")
            withClassName("android.widget.TextView")
        }
    }
}
