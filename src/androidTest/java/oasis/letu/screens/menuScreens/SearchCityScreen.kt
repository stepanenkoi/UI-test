package oasis.letu.screens.menuScreens

import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import oasis.letu.helper.TestUtils
import oasis.letu.helper.isVisible
import ru.letu.feature.addresses.R
import ru.letu.ui.base.MainActivity

object SearchCityScreen : KScreen<SearchCityScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_search_address

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    val SelectCityText = KTextView { withId(R.id.txt_city_info) }

    fun checkCity() {
        Espresso.onView(TestUtils.withIndex(ViewMatchers.withId(R.id.city_name), 0))
            .isVisible()
    }
}
