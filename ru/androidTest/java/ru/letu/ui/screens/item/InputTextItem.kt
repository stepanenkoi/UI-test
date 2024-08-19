package ru.letu.ui.screens.item

import android.view.View
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.edit.KTextInputLayout
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import ru.letu.core.endeca.R

class InputTextItem(parent: Matcher<View>) : KRecyclerItem<InputTextItem>(parent) {
    val inputLayout: KTextInputLayout = KTextInputLayout { withMatcher(parent) }
    val input: KEditText = KEditText(parent) { withId(R.id.input) }
}
