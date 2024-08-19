package ru.letu.ui.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withText
import ru.letu.ui.helpers.TestUtils.first
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.core_resources.R as RCoreResources

object StorePopupScreen {
    fun selectFirstStore() {
        waitForResponses()

        val targetButtonView = onView(first(withText(RCoreResources.string.app_checkout_choose_store_btn)))
        targetButtonView.perform(click())

        waitForResponses()
    }
}
