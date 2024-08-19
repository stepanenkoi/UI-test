package ru.letu.ui.helpers.utils.matchers

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

/**
 * Matches RecyclerView with count of children
 *
 * @param size of children count in RecyclerView
 *
 * Created by Vladislav Kochetov on 24.11.2021.
 */
class RecyclerViewAdapterSizeNoMatcher(
    private val size: Int
    ) : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {

    private var itemCount: Int = 0

    override fun matchesSafely(view: RecyclerView) = run {
        itemCount = view.adapter?.itemCount ?: 0
        itemCount != size
    }

    override fun describeTo(description: Description) {
        description
            .appendText("RecyclerView with ")
            .appendValue(size)
            .appendText(" item(s), but got with ")
            .appendValue(itemCount)
    }
}
