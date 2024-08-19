package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.helpers.TestUtils.getString
import ru.letu.ui.helpers.utils.testdata.CityList.MOSCOW
import ru.letu.ui.helpers.utils.testdata.CityList.SAINT_PETERSBURG
import ru.letu.ui.helpers.utils.testdata.CityList.VORONEZH
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.addresses.R as RAddresses

object ChooseRegionScreen : Screen<ChooseRegionScreen>() {
    private val cityHeader = KTextView {
        withId(RAddresses.id.txt_city_info)
        withText(RCoreResources.string.app_txt_city_select_title)
    }
    val cityName = KTextView { withId(RAddresses.id.city_name) }
    val citiesListInfo = KView { withId(R.id.cities_view) }
    val searchField = KEditText { withId(R.id.insert_city) }
    private val imgVoiceChoose = KImageView { withId(RAddresses.id.img_voice_choose) }
    private val imgClose = KImageView { withId(RAddresses.id.img_close_activity) }
    private val cityNotFoundText = KTextView {
        withId(RAddresses.id.city_not_found)
        withText(RCoreResources.string.app_city_not_found)
    }

    private val cityRecyclerView = KRecyclerView(
        builder = {
            withId(R.id.cities_view)
        },
        itemTypeBuilder = {
            itemType(::CitiesItem)
        }
    )

    class CitiesItem(parent: Matcher<View>) : KRecyclerItem<CitiesItem>(parent) {
        val cityName = KTextView(parent) { withId(RAddresses.id.city_name) }
    }

    private fun hasCityName(name: String) {
        cityRecyclerView.hasDescendant { withText(name) }
    }

    fun selectCityInsertUsingSearch(cityName: String) {
        citiesListInfo {
            isVisible()
        }
        searchField {
            click()
            replaceText(cityName)
        }
        val chooseCity = KView {
            withId(ru.letu.feature.addresses.R.id.city_name)
            withParent { withId(R.id.city_view) }
            isVisible()
            withText(cityName)
        }
        chooseCity.click()
    }

    fun selectCity(cityName: String) {
        citiesListInfo {
            isVisible()
        }
        val chooseCity = KButton {
            withId(ru.letu.feature.addresses.R.id.city_name)
            withText(cityName)
        }
        chooseCity {
            click()
        }
    }

    fun replaceTextInSearchField(searchQuery: String) {
        step("Ввести запрос $searchQuery в строку происка города") {
            searchField.replaceText(searchQuery)
            assertTextInSearchField(searchQuery)
        }
    }

    private fun assertTextInSearchField(searchQuery: String) {
        step("Текст $searchQuery введен в строку происка города") {
            searchField.hasText(searchQuery)
        }
    }

    fun clickOnCityByName(cityName: String) {
        step("Нажать на город $cityName") {
            KTextView {
                withId(RAddresses.id.city_name)
                withText(cityName)
            }.click()
            MenuScreen.assertCitySelection(cityName)
        }
    }

    fun assertCityNotFoundText() {
        step("Показывается текст ${getString(RCoreResources.string.app_city_not_found)}") {
            cityNotFoundText.isDisplayed()
        }
    }

    fun assertCitySelectionScreenOpen() {
        step("Экран выбора города открыт") {
            imgClose.isDisplayed()
            searchField.hasHint(RCoreResources.string.app_guess_city_hint)
            imgVoiceChoose.isDisplayed()
            cityHeader.isDisplayed()
            cityRecyclerView.isDisplayed()
            hasCityName(VORONEZH)
            hasCityName(MOSCOW)
            hasCityName(SAINT_PETERSBURG)
        }
    }
}
