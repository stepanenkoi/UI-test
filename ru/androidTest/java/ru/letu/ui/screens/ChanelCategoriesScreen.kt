package ru.letu.ui.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.letu.R
import ru.letu.ui.helpers.TestUtils.first
import ru.letu.ui.helpers.TestUtils.waitFor
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.ui.helpers.ViewInfo

object ChanelCategoriesScreen {

    val categoriesViewInfo = ViewInfo("Chanel categories", R.id.chanel_category)

    fun selectNovelty() {
        waitFor(categoriesViewInfo)
        val noveltiesView = onView(first(withText("Новинки")))
        noveltiesView.perform(click())
        waitForResponses()
    }
}
