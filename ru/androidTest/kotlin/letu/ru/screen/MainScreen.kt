package letu.ru.screen
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import ru.letu.R



object MainScreen : KScreen<MainScreen>(){
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val menuButton = KView { withId(R.id.navigation_bar_item_icon_view)}

}