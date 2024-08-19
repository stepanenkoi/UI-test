package ru.letu.ui.screens.item

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.Matcher
import ru.letu.ui.R

class ButtonItem(parent: Matcher<View>) : KRecyclerItem<ButtonItem>(parent) {
    val button: KButton = KButton(parent) { withId(R.id.button) }
}
