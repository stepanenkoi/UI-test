package oasis.letu.screens.navigation

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.qameta.allure.kotlin.Allure
import ru.letu.onboarding.R
import ru.letu.ui.base.MainActivity

object StaticPageScreen : KScreen<StaticPageScreen>() {
    override val layoutId: Int
        get() = ru.letu.feature.staticpage.R.layout.fragment_static_page
    override val viewClass: Class<*>
        get() = MainActivity::class.java

    val content = KView {
        withId(ru.letu.core.endeca.R.id.title)
        withIndex(0) { withId(ru.letu.core.endeca.R.id.title) }
    }
    fun checkContent() {
        Allure.step("Проверка отображения контента") {
            content.isDisplayed()
        }
    }
}
