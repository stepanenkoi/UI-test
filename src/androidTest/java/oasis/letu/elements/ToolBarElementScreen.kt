package oasis.letu.elements

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.toolbar.KToolbar
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.core_resources.R as RCore

object ToolBarElementScreen : Screen<ToolBarElementScreen>() {
    private val toolBar = KToolbar { withId(R.id.toolbar_main) }

    val searchButton = KButton {
        withId(R.id.search)
        withContentDescription(RCore.string.app_search)
    }

    fun asserTitleToolBar(title: Int) {
        step("Проверить текст $title в тулбаре") {
            toolBar.hasDescendant { withText(title) }
        }
    }
}
