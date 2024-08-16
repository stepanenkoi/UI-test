package oasis.letu.screens.сatalogScreens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import ru.letu.core.endeca.R
import ru.letu.ui.base.MainActivity

object GroupScreen : KScreen<GroupScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_cartridges
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val groupName1 = KTextView {
        withId(R.id.title)
        withIndex(1) { withId(R.id.title) }
    }

    fun clickGroup() {
        Allure.step("открыть первую подкатегорию") {
            groupName1.click()
        }
    }
}
