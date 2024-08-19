package ru.letu.ui.screens

import io.github.kakaocup.kakao.chipgroup.KChipGroup
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import ru.letu.R

object OrderChangeDateScreen : Screen<OrderChangeDateScreen>() {

    private val toolbar = KToolbar {
        withId(R.id.toolbar)
    }
    private val datesGroup = KChipGroup {
        withId(R.id.available_dates)
    }

    private val timeGroup = KChipGroup {
        withId(R.id.available_time)
    }

    val deliveryType = KTextView {
        withId(R.id.tv_delivery_type)
    }

    val address = KTextView {
        withId(R.id.tv_address)
    }

    private val saveButton = KButton {
        withId(R.id.btn_submit)
    }

    fun testChangeDateScreenVisibility() {
        toolbar.isVisible()
        saveButton.isVisible()
        deliveryType.isVisible()
        address.isVisible()
        datesGroup.isVisible()
        datesGroup.hasChip(0)
        timeGroup.isVisible()
        timeGroup.hasChip(0)
    }
}
