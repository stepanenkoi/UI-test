package ru.letu.ui.helpers.utils.extensions

import androidx.test.espresso.assertion.ViewAssertions
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.recycler.RecyclerAdapterAssertions
import ru.letu.ui.helpers.utils.matchers.RecyclerViewAdapterSizeNoMatcher

/**
 * Created by Vladislav Kochetov on 24.11.2021.
 */

fun RecyclerAdapterAssertions.hasNoSize(size: Int) {
    view.check(ViewAssertions.matches(RecyclerViewAdapterSizeNoMatcher(size)))
}

fun KRecyclerView.isNotEmpty() {
    isDisplayed()
    hasNoSize(0)
}
