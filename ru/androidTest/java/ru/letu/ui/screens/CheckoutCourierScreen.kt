package ru.letu.ui.screens

import ru.letu.ui.helpers.TestUtils.setTextAndApplyIME
import ru.letu.ui.helpers.TestUtils.waitFor
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.ui.helpers.ViewInfo

object CheckoutCourierScreen {
    val addressInput = ViewInfo("Address input", ru.letu.feature.addresses.R.id.autocomplete_address)

    fun fillCourierFields() {
        val address = "ул Тестовская, д 1"

        setTextAndApplyIME(ru.letu.feature.addresses.R.id.autocomplete_address, address)

        waitFor(addressInput)

        waitForResponses()
    }
}
