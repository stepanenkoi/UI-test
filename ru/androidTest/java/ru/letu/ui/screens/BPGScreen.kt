package ru.letu.ui.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import ru.letu.R

object BPGScreen {

    fun fillFields() {
        val url = "https://rivegauche.ru"
        val urlEditText = onView(withId(R.id.edt_product_url))
        urlEditText.perform(ViewActions.replaceText(url), ViewActions.closeSoftKeyboard())

        val price = "100"
        val priceEditText = onView(withId(R.id.edt_product_price))
        priceEditText.perform(ViewActions.replaceText(price), ViewActions.closeSoftKeyboard())

        val phone = "+79876543210"
        val phoneEditText = onView(withId(R.id.edt_user_phone))
        phoneEditText.perform(ViewActions.replaceText(phone), ViewActions.closeSoftKeyboard())
    }

    fun submitForm() {
        onView(withId(R.id.btn_bpg_continue))
            .perform(ViewActions.click())
    }

    fun checkIfSuccess() {
        onView(withId(R.id.bpg_success_title))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        onView(withId(R.id.btn_bpg_continue))
            .perform(ViewActions.click())
    }
}
