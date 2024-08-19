package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.letu.R

object SuggestionResultListScreen : Screen<SuggestionResultListScreen>() {
    val suggestionList = KRecyclerView(
        builder = { withId(R.id.suggestions_recycler) },
        itemTypeBuilder = { itemType(SuggestionResultListScreen::SkuItem) }
    )

    class SkuItem(parent: Matcher<View>) : KRecyclerItem<SkuItem>(parent) {
        val title = KTextView {
            withIndex(0) {
                withId(R.id.title)
            }
        }
    }
}
