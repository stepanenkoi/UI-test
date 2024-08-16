package oasis.letu.bottomSheet

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import oasis.letu.helper.TestUtils.clickText
import oasis.letu.screens.authScreens.AuthorizationScreen
import org.hamcrest.Matcher
import ru.letu.login.R

object CountrySelectionBottomScreen : Screen<CountrySelectionBottomScreen>() {

    private val countrySelectionBottomRecycler = KRecyclerView(
        {
            withId(R.id.list_of_country)
            withDescendant { withId(ru.letu.feature.region.common.R.id.countryName) }
        },
        {
            itemType(::RecyclerClass)
        }
    )

    class RecyclerClass(parent: Matcher<View>) : KRecyclerItem<RecyclerClass>(parent) {
        val clinicText = KTextView(parent) { withId(ru.letu.R.id.txtItemMenu) }
    }

    fun scrollToEnd() {
        step("Проскролить экран до конца") {
            countrySelectionBottomRecycler.scrollToEnd()
        }
    }

    fun assertCountrySelectionBottomOpen() {
        step("Боттом щит выбора страны открыт") {
            countrySelectionBottomRecycler.isDisplayed()
        }
    }

    fun clickCountryByText(country: String) {
        step("Выбрать страну $country") {
            clickText(country)
            AuthorizationScreen.assertCountrySelection(country)
        }
    }
}
