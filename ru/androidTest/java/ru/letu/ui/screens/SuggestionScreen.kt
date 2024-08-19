package ru.letu.ui.screens

import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.scroll.KScrollView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.R
import ru.letu.routes.SearchResultsRoute
import ru.letu.routes.SuggestionsRoute
import ru.letu.ui.base.DefaultTest.Companion.LONG_WAIT_TIME
import ru.letu.ui.base.DefaultTest.Companion.WAIT_TIME
import ru.letu.ui.helpers.TestUtils
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.SuggestionScreen.SuggestionUiScreen.blurAdults
import ru.letu.ui.screens.SuggestionScreen.SuggestionUiScreen.textProductUiName
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen.assertSpecifyAddressDialogDisplayed
import ru.letu.ui.screens.dialogscreen.AdultsDialogUiScreen.assertAdultsDialogOpen
import ru.letu.ui.screens.dialogscreen.PermissionDialogUiScreen
import ru.letu.ui.screens.elements.ProgressScreen
import ru.letu.ui.screens.elements.ProgressUiScreen
import ru.letu.core.endeca.R as REndeca
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.plp.R as RFeaturePlp

object SuggestionScreen : Screen<SuggestionScreen>() {

    private const val CONSULTATION = "Видеоконсультант"
    private const val BUY_WITH_EXPERT = "Купить с экспертом"
    private fun searchQueryFoundText(searchQueryError: String): String {
        return "По запросу «$searchQueryError» найдено 0 вариантов товара"
    }

    val searchEditTextViewInfo = KEditText {
        withIndex(0) {
            withId(R.id.search_input)
        }
    }

    val barcodeButton = KImageView {
        withIndex(0) {
            withId(ru.letu.ui.R.id.barcode_button)
        }
    }

    val textProductName = KTextView { withIndex(0) { withId(RFeaturePlp.id.text_product_name) } }
    private val textProductBrandName = KTextView { withIndex(0) { withId(RFeaturePlp.id.text_brand_name) } }
    private val brandName = KTextView { withId(R.id.brand_name) }

    private val searchHistoryTitle = KTextView {
        withId(R.id.title)
        withText(RCoreResources.string.app_search_history)
    }
    private val searchHistoryClear = KTextView {
        withId(R.id.clear)
        withText(RCoreResources.string.app_clear)
    }

    private val searchHistoryImg = KTextView { withId(R.id.suggest_item_image) }
    private val searchHistoryName = KTextView { withId(R.id.suggest_item_name) }
    private val searchHistoryDeleteSuggest = KTextView { withId(R.id.img_delete_suggest) }

    private val plpSkusSearchResults = KTextView {
        withId(R.id.title)
        withText(RCoreResources.string.consultant_help_text)
    }

    val searchTitle = KTextView {
        isDescendantOfA { withId(REndeca.id.endecaRecycler) }
        withId(R.id.title)
        withText(RCoreResources.string.app_search)
    }

    private val plpSkusFound = KTextView {
        isDescendantOfA { withId(REndeca.id.endecaRecycler) }
        withIndex(1) { withId(R.id.title) }
    }

    private val productInfoConsultantTitle = KTextView {
        isDescendantOfA { withId(REndeca.id.product_info_carousel) }
        withIndex(0) { withId(R.id.title) }
    }

    private val productInfoBuyWithExpertTitle = KTextView {
        isDescendantOfA { withId(REndeca.id.product_info_carousel) }
        withIndex(1) { withId(R.id.title) }
    }

    private val cartBtn = KButton {
        withIndex(0) { withId(RFeaturePlp.id.cart_button) }
    }

    private val allResults = KTextView {
        isDescendantOfA { withId(REndeca.id.endecaRecycler) }
        withText(RCoreResources.string.app_search_all_results)
    }

    private val suggestProduct = KTextView {
        isDescendantOfA { withId(R.id.suggestions_recycler) }
        withIndex(0) { withId(R.id.suggest_item_name) }
    }

    val endecaRecycler = KScrollView {
        withId(REndeca.id.endecaRecycler)
    }

    val textAvailable = KTextView { withId(RFeaturePlp.id.text_available) }

    fun openSuggestionScreen() {
        step("Открыть экран поиска") {
            featureRouter forward SuggestionsRoute()
            assertSuggestionScreenOpen()
        }
    }

    fun openSuggestionHistoryScreen(suggest: String) {
        step("Открыть экран поиска с запросом $suggest в истории запроса") {
            featureRouter forward SuggestionsRoute()
            assertSearchHistorySuggest(suggest)
        }
    }

    fun openSearchResults(searchQuery: String) {
        step("Открыть результат поиска по запросу $searchQuery ") {
            featureRouter replace SearchResultsRoute("/search?Dy=1&Ntt=$searchQuery")
            ProgressScreen.assertProgressBarDisplayed()
        }
    }

    fun replaceTextSearchInput(searchQuery: String) {
        step("Ввести в поле поиска запрос $searchQuery") {
            SuggestionScreen {
                searchEditTextViewInfo.isVisible()
                searchEditTextViewInfo.replaceText(searchQuery)
            }
            assertSearchQueryEntered(searchQuery)
        }
    }

    fun clickTextSearchInput(searchQuery: String) {
        step("Нажать на поисковую подсказку $searchQuery") {
            closeSoftKeyboard()
            KTextView {
                withId(R.id.title)
                withText(searchQuery.lowercase())
            }.click()
            ProgressUiScreen.assertProgressDisplayed()
        }
    }

    fun clickBarcodeBtn() {
        step("Нажать на кнопку поиска по коду") {
            barcodeButton.click()
            PermissionDialogUiScreen.assertPermissionDialogOpen()
        }
    }

    fun clickSearch(searchQuery: String) {
        step("Нажать на кнопку Найти") {
            SuggestionScreen {
                searchEditTextViewInfo.isVisible()
                searchEditTextViewInfo.pressImeAction()
            }
            assertSearchResults(searchQuery)
        }
    }

    fun clickSearch() {
        step("Нажать на кнопку Найти") {
            SuggestionScreen {
                searchEditTextViewInfo.isVisible()
                searchEditTextViewInfo.pressImeAction()
            }
            assertSearchResultDisplayed()
        }
    }

    fun clickSearchSuggestionBrand(brand: String) {
        step("Нажать на подсказку с брендом $brand") {
            KTextView { withText("Бренд $brand") }.click()
            assertBrandScreenOpen(brand)
        }
    }

    fun clickSearchProductEighteenPlus() {
        step("Нажать на кнопку Найти с поиском товара 18+ с неподтвержденным возрастом") {
            SuggestionScreen {
                searchEditTextViewInfo.isVisible()
                searchEditTextViewInfo.pressImeAction()
            }
            assertAdultsDialogOpen()
        }
    }

    fun clickSearchSuggestProduct() {
        step("Нажать на подсказку с продуктом") {
            suggestProduct.click()
            assertSpecifyAddressDialogDisplayed()
        }
    }

    fun clickSearchSuggestionAll() {
        step("Нажать на подсказку Все результаты поиска") {
            allResults.longClick()
            assertSearchResultDisplayed()
        }
    }

    fun clickSearchSuggestionByIndex(index: Int) {
        step("Нажать на ${index + 1} -ю подсказку") {
            closeSoftKeyboard()
            KTextView {
                isDescendantOfA { withId(R.id.suggestions_recycler) }
                withIndex(index) { withId(R.id.title) }
            }.click()
            ProgressUiScreen.assertProgressDisplayed()
            assertSearchResultDisplayed()
        }
    }

    fun clickAddToCart(goodsInCart: String) {
        step("Нажать на кнопку В Корзину") {
            cartBtn.click()
            assertAddCartTextBtn(goodsInCart.toInt() - 1)
            Navigation.assertBadgeCart(goodsInCart)
        }
    }

    fun clickAdultsBlurProduct() {
        step("Нажать на заблюренный продукт") {
            blurAdults.click()
            assertAdultsDialogOpen()
        }
    }

    fun assertSuggestionScreenOpen() {
        step("Открывается экран поиска. Отображается строка поиска c плейсхолдером, кнопка поиска по QR коду.") {
            SuggestionScreen {
                searchEditTextViewInfo.isVisible()
                barcodeButton.isVisible()
            }
        }
    }

    private fun assertSearchQueryEntered(searchQuery: String) {
        step("Поисковой запрос $searchQuery введен") {
            searchEditTextViewInfo.hasText(searchQuery)
        }
    }

    fun assertSearchResults(searchQuery: String) {
        step("Проверка что результат соответствует запросу $searchQuery") {
            waitForDisplayed(RFeaturePlp.id.text_product_name, WAIT_TIME)
            textProductUiName.containsText(searchQuery)
        }
    }

    fun assertSearchResultDisplayed() {
        step("Экран показа результата поиска открыт") {
            waitForResponses()
            searchTitle.isDisplayed()
        }
    }

    fun assertSearchQueryFound(searchQueryError: String) {
        step("Отображается Нулевая страница поиска") {
            waitForDisplayed(REndeca.id.product_info_carousel, LONG_WAIT_TIME)
            plpSkusFound.hasText(searchQueryFoundText(searchQueryError))
            plpSkusSearchResults.isDisplayed()

            productInfoConsultantTitle.hasText(CONSULTATION)
            productInfoBuyWithExpertTitle.hasText(BUY_WITH_EXPERT)
        }
    }

    private fun assertAddCartTextBtn(index: Int) {
        step("Отображается кнопка с текстом В КОРЗИНЕ") {
            KTextView { withIndex(index) { withText(RCoreResources.string.app_in_cart) } }.isDisplayed()
        }
    }

    private fun assertSearchHistorySuggest(suggest: String) {
        step("В истории запросов отображается запрос с именем $suggest") {
            searchHistoryTitle.isDisplayed()
            searchHistoryClear.isDisplayed()
            searchHistoryImg.isDisplayed()
            searchHistoryName.hasText(suggest)
            searchHistoryDeleteSuggest.isDisplayed()
        }
    }

    fun assertSearchBrandIsDisplayed(brand: String) {
        step("В подсказках отображается бренд $brand") {
            closeSoftKeyboard()
            KTextView { withText("Бренд $brand") }.isDisplayed()
        }
    }

    fun assertSearchProductIsDisplayed() {
        step("Отображается подсказка с продуктом") {
            closeSoftKeyboard()
            suggestProduct.isDisplayed()
        }
    }

    fun assertSearchAllResultsIsDisplayed() {
        step("Отображается подсказка Все результаты поиска") {
            closeSoftKeyboard()
            allResults.isDisplayed()
        }
    }

   fun assertBrandScreenOpen(brand: String) {
        step("Экран бренда $brand открыт") {
            brandName.hasText(brand)
            textProductBrandName.containsText(brand)
        }
    }

    object SuggestionUiScreen : UiScreen<SuggestionUiScreen>() {
        override val packageName: String = "ru.letu.preprod"

        private val imgAdults = UiView {
            withId(this@SuggestionUiScreen.packageName, "imgAdults")
            withClassName("android.widget.ImageView")
        }

        val image = UiView {
            withId(this@SuggestionUiScreen.packageName, "image")
            withClassName("android.widget.ImageView")
        }

        val blurAdults = UiView {
            withId(this@SuggestionUiScreen.packageName, "blur")
            withClassName("android.view.View")
        }

        val searchUiTitle = UiTextView {
            withText(TestUtils.getString(RCoreResources.string.app_search))
            withId(this@SuggestionUiScreen.packageName, "title")
            withClassName("android.widget.TextView")
        }

        val textProductUiName = UiTextView { withId(this@SuggestionUiScreen.packageName, "text_product_name") }

        fun assertProductIsBlur() {
            step("Товары для взрослых заблюрены") {
                imgAdults.isDisplayed()
                blurAdults.isDisplayed()
            }
        }

        fun assertProductIsNotBlur() {
            step("Товары для взрослых не заблюрены") {
                image.isDisplayed()
            }
        }
    }
}
