package oasis.letu.screens.сatalogScreens

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import oasis.letu.helper.StringFormatter
import oasis.letu.helper.TestUtils.getText
import oasis.letu.helper.TestUtils.sleep
import oasis.letu.helper.TestUtils.withIndex
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.base.MainActivity

object PLPScreen : KScreen<PLPScreen>() {

    override val layoutId: Int
        get() = R.layout.cartridge_ui_plp_product

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    val tag1 = KTextView {
        withId(ru.letu.ui.R.id.tag)
        withIndex(0) { withId(ru.letu.ui.R.id.tag) }
    }
    val tag2 = KTextView {
        withId(ru.letu.ui.R.id.tag)
        withIndex(1) { withId(ru.letu.ui.R.id.tag) }
    }

    val recycler = KRecyclerView(
        {
            withIndex(0) { withId(ru.letu.core.endeca.R.id.endecaRecycler) }
        },
        {
            itemType(PLPScreen::RecyclerClass)
        }
    )

    class RecyclerClass(parent: Matcher<View>) : KRecyclerItem<RecyclerClass>(parent)

    val sortText = KTextView { withId(ru.letu.ui.R.id.sort_type_title) }
    val sortImage = KImageView { withId(ru.letu.ui.R.id.sort_icon) }
    val filterText = KTextView {
        withId(ru.letu.ui.R.id.filter_title)
        // withText(ru.letu.core_resources.R.string.core_ui_filter)
    }
    val filterNumber = KTextView { withId(ru.letu.ui.R.id.filter_applied) }
    val filterImage = KImageView { withId(ru.letu.ui.R.id.filter_icon) }
    val plpImage1 = KImageView {
        withId(R.id.image_container)
        withIndex(0) { withId(R.id.image_container) }
    }
    val favorite = KImageView {
        withId(R.id.check_box_favourite)
        withIndex(0) { withId(R.id.check_box_favourite) }
    }
    val plpImage2 = KImageView {
        withId(R.id.image_container)
        withIndex(1) { withId(R.id.image_container) }
    }
    val plpBrandName1 = KTextView {
        withId(R.id.text_brand_name)
        withIndex(0) { withId(R.id.text_brand_name) }
    }
    val plpBrandName2 = KTextView {
        withId(R.id.text_brand_name)
        withIndex(1) { withId(R.id.text_brand_name) }
    }
    val plpName1 = KTextView {
        withId(R.id.text_product_name)
        withIndex(0) { withId(R.id.text_product_name) }
    }
    val plpName2 = KTextView {
        withId(R.id.text_product_name)
        withIndex(1) { withId(R.id.text_product_name) }
    }
    val ratingBar1 = KImageView {
        withId(R.id.rating_bar)
        withIndex(0) { withId(R.id.rating_bar) }
    }
    val ratingBar2 = KImageView {
        withId(R.id.rating_bar)
        withIndex(1) { withId(R.id.rating_bar) }
    }
    val reviewsCount1 = KTextView {
        withId(R.id.reviews_count)
        withIndex(0) { withId(R.id.reviews_count) }
    }
    val reviewsCount2 = KTextView {
        withId(R.id.reviews_count)
        withIndex(1) { withId(R.id.reviews_count) }
    }
    val addToCartButton1 = KButton {
        withId(R.id.cart_button)
        withIndex(0) { withId(R.id.cart_button) }
    }
    val addToCartButton2 = KButton {
        withId(R.id.cart_button)
        withIndex(1) { withId(R.id.cart_button) }
    }
    val unavailable1 = KTextView {
        withId(R.id.text_unavailable)
        withIndex(1) { withId(R.id.text_unavailable) }
    }
    val unavailable2 = KTextView {
        withId(R.id.text_unavailable)
        withIndex(2) { withId(R.id.text_unavailable) }
    }
    val price1 = KTextView {
        withId(R.id.text_price)
        withIndex(0) { withId(R.id.text_price) }
    }
    val price2 = KTextView {
        withId(R.id.text_price)
        withIndex(1) { withId(R.id.text_price) }
    }
    val rawPrice1 = KTextView {
        withId(R.id.text_raw_price)
        withIndex(0) { withId(R.id.text_raw_price) }
    }
    val rawPrice2 = KTextView {
        withId(R.id.text_raw_price)
        withIndex(1) { withId(R.id.text_raw_price) }
    }
    val Discount1 = KTextView {
        withId(R.id.text_discount_price)
        withIndex(0) { withId(R.id.text_discount_price) }
    }
    val discount2 = KTextView {
        withId(R.id.text_discount_price)
        withIndex(1) { withId(R.id.text_discount_price) }
    }
    val discountPercent1 = KTextView {
        withId(R.id.text_discount_percent)
        withIndex(0) { withId(R.id.text_discount_percent) }
    }
    val discountPercent2 = KTextView {
        withId(R.id.text_discount_percent)
        withIndex(1) { withId(R.id.text_discount_percent) }
    }
    val sortType1 = KCheckBox {
        withId(ru.letu.feature.plp.R.id.sort_type)
        withIndex(0) { withId(ru.letu.feature.plp.R.id.sort_type) }
    }
    val sortType2 = KCheckBox {
        withId(ru.letu.feature.plp.R.id.sort_type)
        withIndex(1) { withId(ru.letu.feature.plp.R.id.sort_type) }
    }
    val sortType3 = KCheckBox {
        withId(ru.letu.feature.plp.R.id.sort_type)
        withIndex(2) { withId(ru.letu.feature.plp.R.id.sort_type) }
    }

    fun checkTag1() {
        Allure.step("проверка отображения тега") {
            tag1.isDisplayed()
        }
    }
    fun clickTag2() {
        Allure.step("выбрать 2й тег") {
            tag2.click()
        }
    }

    fun checkSort() {
        Allure.step("проверка отображения кнопки сортировки") {
            sortText.isDisplayed()
        }
    }

    fun openSortMenu() {
        Allure.step("нажать на сортировку ") {
            sortText.click()
        }
    }

    fun checkFilter() {
        Allure.step("проверка отображения кнопки фильтров") {
            filterText.isDisplayed()
        }
    }

    fun checkFilterNumber() {
        Allure.step("проверка отображения счетчика фильтров") {
            filterNumber.isDisplayed()
        }
    }

    fun checkNumberOfFilters1() {
        Allure.step("проверка отображения 1 активного фильтра") {
            filterNumber.containsText("1")
        }
    }

    fun checkNumberOfFilters2() {
        Allure.step("проверка отображения 1 активного фильтра") {
            filterNumber.containsText("2")
        }
    }

    fun clickFilter() {
        Allure.step("нажать на фильтры ") {
            filterText.click()
        }
    }

    fun checkName1() {
        Allure.step("проверка отображения наименования 1го товара") {
            plpName1.isDisplayed()
        }
    }

    fun checkName2() {
        Allure.step("проверка отображения наименования 2го товара") {
            plpName2.isDisplayed()
        }
    }

    fun checkImage1() {
        Allure.step("проверка отображения изображения 1го товара") {
            plpImage1.isDisplayed()
        }
    }

    fun checkImage2() {
        Allure.step("проверка отображения изображения 2го товара") {
            plpImage2.isDisplayed()
        }
    }

    fun clickName() {
        Allure.step("открыть pdp 1го товара") {
            plpName1.click()
        }
    }

    fun clickName2() {
        Allure.step("открыть pdp 2го товара") {
            plpName2.click()
        }
    }

    fun checkBrandName1() {
        Allure.step("проверка отображения наименования бренда 1го товара") {
            plpBrandName1.isDisplayed()
        }
    }

    fun checkPrice1() {
        Allure.step("проверка отображения цены 1го товара") {
            price1.isDisplayed()
        }
    }

    fun checkUnvaible1() {
        Allure.step("проверка отображения что товар не доступен") {
            unavailable1.isDisplayed()
        }
    }

    fun checkAddToCart1() {
        Allure.step("проверка отображения кнопки добавить в корзину у 1го товара") {
            addToCartButton1.isDisplayed()
        }
    }

    fun AddToCart1() {
        Allure.step("Нажать на кнопку добавить в корзину у 1го товара") {
            addToCartButton1.click()
        }
    }

    fun GoToCart() {
        Allure.step("Перейти в корзину") {
            addToCartButton1.click()
            sleep(3000)
            addToCartButton1.click()
        }
    }

    fun checkFavorite() {
        Allure.step("проверка отображения кнопки добавления в избранное") {
            favorite.isDisplayed()
        }
    }

    fun clickFavorite() {
        Allure.step("добавить в избранное") {
            favorite.click()
        }
    }

    fun checkSort1() {
        Allure.step("проверка отображения первого вида сортировки") {
            sortType1.isDisplayed()
        }
    }

    fun clickSort1() {
        Allure.step("выбор первого вида сортировки") {
            sortType1.click()
        }
    }

    fun sortByHigherPrice() {

        Allure.step("Проверка сортировки по возрастанию цены") {
            val priceList = mutableListOf<Int>()
            for (index in 0..3) {
                priceList.add(
                    StringFormatter.formatStringToInt(
                        getText(
                            withIndex(withId(R.id.text_price), index)
                        )
                    )
                )
            }
            assert(priceList.asSequence().windowed(2).all { (a, b) -> a <= b })
        }
    }

    fun sortByLowerPrice() {
        Allure.step("Проверка сортировки по уобыванию цены") {
            val priceList = mutableListOf<Int>()
            for (index in 0..3) {
                priceList.add(
                    StringFormatter.formatStringToInt(
                        getText(
                            withIndex(withId(R.id.text_price), index)
                        )
                    )
                )
            }
            assert(priceList.asSequence().windowed(2).all { (a, b) -> a >= b })
        }
    }

    fun sortByAlphabetical() {
        Allure.step("Проверка сортировки по алфавиту") {
            val priceList = mutableListOf<String>()
            for (index in 0..3) {
                priceList.add(
                    getText(
                        withIndex(withId(R.id.text_product_name), index)
                    )
                )
            }
            assert(priceList.asSequence().zipWithNext { a, b -> a <= b }.all { it })
        }
    }

    fun checkSort2() {
        Allure.step("проверка отображения второго вида сортировки") {
            sortType2.isDisplayed()
        }
    }

    fun clickSort2() {
        Allure.step("выбор второго вида сортировки") {
            sortType2.click()
        }
    }

    fun checkSort3() {
        Allure.step("проверка отображения третьего вида сортировки") {
            sortType3.isDisplayed()
        }
    }

    fun clickSort3() {
        Allure.step("выбор третьего вида сортировки") {
            sortType3.click()
        }
    }
}
