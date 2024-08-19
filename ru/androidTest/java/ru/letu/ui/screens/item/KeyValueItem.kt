package ru.letu.ui.screens.item

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.letu.core.endeca.R

class KeyValueItem(parent: Matcher<View>) : KRecyclerItem<KeyValueItem>(parent) {
    val key: KTextView = KTextView(parent) { withId(R.id.name) }
    val value: KTextView = KTextView(parent) { withId(R.id.value) }
}
