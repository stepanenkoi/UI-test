package oasis.letu.screens.сatalogScreens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.common.utilities.getResourceString
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.slider.KSlider
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import oasis.letu.helper.TestUtils.sleep
import oasis.letu.screens.menuScreens.PersonalDataScreen
import oasis.letu.testData.TestDataScreen
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.base.MainActivity

object FilterScreen : KScreen<FilterScreen>() {

    override val layoutId: Int
        get() = ru.letu.feature.filter.R.layout.fragment_filters_v2

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    // Экран Фильтров
    val clearButton = KTextView {
        withId(ru.letu.ui.R.id.button_clear)
    }
    val facetName1 = KTextView {
        withId(ru.letu.feature.filter.R.id.facet_name)
        withIndex(0) { withId(ru.letu.feature.filter.R.id.facet_name) }
    }
    val radioButton1 = KCheckBox {
        withId(ru.letu.feature.filter.R.id.facet_check)
        withIndex(0) { withId(ru.letu.feature.filter.R.id.facet_check) }
    }
    val facetName2 = KTextView {
        withId(ru.letu.feature.filter.R.id.facet_name)
        withIndex(1) { withId(ru.letu.feature.filter.R.id.facet_name) }
    }
    val radioButton2 = KCheckBox {
        withId(ru.letu.feature.filter.R.id.facet_check)
        withIndex(1) { withId(ru.letu.feature.filter.R.id.facet_check) }
    }
    val priceTitle = KTextView {
        withId(ru.letu.feature.filter.R.id.title)
        withText(ru.letu.core_resources.R.string.app_filter_price)
    }
    val minPrice = KEditText {
        withId(ru.letu.feature.filter.R.id.minPrice)
    }
    val maxPrice = KEditText {
        withId(ru.letu.feature.filter.R.id.maxPrice)
    }
    val slider = KSlider {
        withId(ru.letu.feature.filter.R.id.priceSlider)
    }
    val brandTitle = KTextView {
        withId(ru.letu.feature.filter.R.id.group_title)
    }
    val allButton = KTextView {
        withId(ru.letu.feature.filter.R.id.all_button)
    }
    val applyButton = KButton {
        withId(ru.letu.core.endeca.R.id.button)
        withIndex(1) { withId(ru.letu.core.endeca.R.id.button) }
    }

    fun checkClear() {
        Allure.step("проверка отображения кнопки clear") {
            clearButton.isDisplayed()
        }
    }
    fun clickClear() {
        Allure.step("нажать на  кнопку clear") {
            clearButton.click()
        }
    }
    fun checkFacetName1() {
        Allure.step("проверка отображения 1го фасета") {
            facetName1.isDisplayed()
        }
    }

    fun clickFacetName1() {
        Allure.step("выбрать 1й фасет") {
            facetName1.click()
        }
    }

    fun checkFacetName2() {
        Allure.step("проверка отображения 2го фасета") {
            facetName2.isDisplayed()
        }
    }

    fun clickFacetName2() {
        Allure.step("выбрать 2й фасет") {
            facetName2.click()
        }
    }

    fun checkRadioButton1() {
        Allure.step("проверка отображения 1го чекбокса") {
            radioButton1.isDisplayed()
        }
    }

    fun checkButton1Chosen() {
        Allure.step("проверка что активен 1й чекбокс") {
            radioButton1.isChecked()
        }
    }

    fun checkRadioButton2() {
        Allure.step("проверка отображения 2го чекбокса") {
            radioButton2.isDisplayed()
        }
    }

    fun checkButton2Chosen() {
        Allure.step("проверка что активен 2й чекбокс") {
            radioButton2.isChecked()
        }
    }

    fun checkPriceTitel() {
        Allure.step("проверка отображения заголовка Price") {
            priceTitle.isDisplayed()
        }
    }

    fun checkMinPrice() {
        Allure.step("проверка отображения поля минимальной цены") {
            minPrice.isDisplayed()
        }
    }

    fun enterMinPrice() {
        Allure.step("ввести минимальную цену") {
            minPrice.clearText()
            minPrice.typeText(TestDataScreen.MIN)
            minPrice.containsText(TestDataScreen.MIN)
        }
    }


    fun checkMaxPrice() {
        Allure.step("проверка отображения поля максимальной цены") {
            maxPrice.isDisplayed()
        }
    }

    fun enterMaxPrice() {
        Allure.step("ввести максимальную цену") {
            sleep(1000)
            maxPrice.clearText()
            sleep(1000)
            maxPrice.typeText(TestDataScreen.MAX)
            maxPrice.containsText(TestDataScreen.MAX)
        }
    }

    fun checkSlider() {
        Allure.step("проверка отображения слайдер") {
            slider.isDisplayed()
        }
    }

    fun checkBrandTitle() {
        Allure.step("проверка отображения заголовка Brands") {
            brandTitle.isDisplayed()
        }
    }

    fun checkAllButton() {
        Allure.step("проверка отображения кнопки See all") {
            allButton.isDisplayed()
        }
    }

    fun clickAllButton() {
        Allure.step("кликнуть See all") {
            allButton.click()
        }
    }

    fun checkApplyButton() {
        Allure.step("проверка отображения кнопки Apply") {
            applyButton.isDisplayed()
        }
    }

    fun clickApplyButton() {
        Allure.step("нажать кнопку Apply") {
            applyButton.click()
        }
    }

    // Экран фильтров брендов
    val searchInput = KEditText {
        withId(ru.letu.core.endeca.R.id.search_input)
        withHint(getResourceString(ru.letu.core_resources.R.string.filters_hint_search_brand))
    }
    val tagBrandA = KTextView {
        withId(ru.letu.ui.R.id.tag)
        withText("A")
    }
    val tagBrandB = KTextView {
        withId(ru.letu.ui.R.id.tag)
        withText("B")
    }
    val checkBoxBrand1 = KCheckBox {
        withId(ru.letu.feature.filter.R.id.facet_check)
        withIndex(0) { withId(ru.letu.feature.filter.R.id.facet_check) }
    }
    val checkBoxBrand2 = KCheckBox {
        withId(ru.letu.feature.filter.R.id.facet_check)
        withIndex(1) { withId(ru.letu.feature.filter.R.id.facet_check) }
    }
    val brandName1 = KTextView {
        withId(ru.letu.feature.filter.R.id.facet_name)
        withIndex(0) { withId(ru.letu.feature.filter.R.id.facet_name) }
    }
    val brandName2 = KTextView {
        withId(ru.letu.feature.filter.R.id.facet_name)
        withIndex(1) { withId(ru.letu.feature.filter.R.id.facet_name) }
    }
    val applyBrandButton = KButton {
        withId(ru.letu.core.endeca.R.id.button)
        withIndex(0) { withId(ru.letu.core.endeca.R.id.button) }
    }
    val recycler = KRecyclerView(
        {
            withId(ru.letu.core.endeca.R.id.endecaRecycler)
            withDescendant { withId(ru.letu.feature.filter.R.id.facet_name) }
        },
        {
            itemType(PersonalDataScreen::RecyclerClass)
        }
    )

    class RecyclerClass(parent: Matcher<View>) : KRecyclerItem<RecyclerClass>(parent)

    fun scrollToUp() {
        recycler.scrollToStart()
    }
    fun scrollToDown() {
        recycler.scrollToEnd()
    }

    fun checkSearchField() {
        Allure.step("проверка отображения поля поиска") {
            searchInput.isDisplayed()
        }
    }

    fun clearField() {
        searchInput.clearText()
    }

    fun enterKenzo() {
        Allure.step("ввести kenzo в поле поиска бренда") {
            searchInput.clearText()
            searchInput.typeText(TestDataScreen.KENZO)
        }
    }

    fun enterDolce() {
        Allure.step("ввести dolce в поле поиска бренда") {
            searchInput.clearText()
            searchInput.typeText(TestDataScreen.DOLCE)
        }
    }

    fun checkTagA() {
        Allure.step("проверка отображения тага А") {
            tagBrandA.isDisplayed()
        }
    }

    fun checkTagB() {
        Allure.step("проверка отображения тага B") {
            tagBrandB.isDisplayed()
        }
    }

    fun checkBrandName1() {
        Allure.step("проверка отображения наименования 1го бренда") {
            brandName1.isDisplayed()
        }
    }

    fun clickBrandName1() {
        Allure.step("выбрать 1й бренд") {
            checkBoxBrand1.click()
        }
    }

    fun checkKenzoBrandName1() {
        Allure.step("проверка отображения наименования 1го бренда kenzo") {
            brandName1.containsText(TestDataScreen.KENZO)
        }
    }

    fun checkDGBrandName1() {
        Allure.step("проверка отображения наименования 1го бренда DG") {
            brandName1.containsText(TestDataScreen.DG)
        }
    }

    fun checkBrandName2() {
        Allure.step("проверка отображения наименования 2го бренда") {
            brandName2.isDisplayed()
        }
    }

    fun checkDMBrandName2() {
        Allure.step("проверка отображения наименования 2го бренда DM") {
            brandName2.containsText(TestDataScreen.DM)
        }
    }

    fun checkBrandCheckbox1() {
        Allure.step("проверка отображения чекбокса 1го бренда") {
            checkBoxBrand1.isDisplayed()
        }
    }

    fun checkBrandCheckbox2() {
        Allure.step("проверка отображения чекбокса 2го бренда") {
            checkBoxBrand2.isDisplayed()
        }
    }

    fun checkApplyBrandButton() {
        Allure.step("проверка отображения кнопки Apply") {
            applyBrandButton.isDisplayed()
        }
    }

    fun clickApplyBrandButton() {
        Allure.step("нажать  кнопку Apply") {
            applyBrandButton.click()
        }
    }
}

