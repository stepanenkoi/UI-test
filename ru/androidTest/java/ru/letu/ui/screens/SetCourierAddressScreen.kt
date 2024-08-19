package ru.letu.ui.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KTextView
import ru.letu.feature.addresses.edit.v1.SetCourierAddressFragment
import ru.letu.feature.addresses.R

object SetCourierAddressScreen : KScreen<SetCourierAddressScreen>() {
    override val layoutId: Int = R.layout.fragment_set_courier_address
    override val viewClass: Class<*> = SetCourierAddressFragment::class.java

    val title = KTextView { withId(R.id.setAddressTitle) }
    val city = KEditText { withId(R.id.autocomplete_city) }
    val cityHint = KTextView { withId(ru.letu.feature.checkout.R.id.city_hint) }
}
