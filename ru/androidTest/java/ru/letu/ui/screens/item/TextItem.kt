package ru.letu.ui.screens.item

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

class TextItem(parent: Matcher<View>) : KRecyclerItem<TextItem>(parent) {
    val text: KTextView = KTextView { withMatcher(parent) }
}
