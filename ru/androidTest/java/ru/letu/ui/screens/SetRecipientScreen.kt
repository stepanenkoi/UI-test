package ru.letu.ui.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import ru.letu.feature.checkout.R
import ru.letu.feature.checkout.ui.fragment.SetRecipientFragment

object SetRecipientScreen : KScreen<SetRecipientScreen>() {
    override val layoutId: Int = R.layout.fragment_set_recipient
    override val viewClass: Class<*> = SetRecipientFragment::class.java

    val toolbar = KToolbar { withId(R.id.toolbar) }
    val description = KTextView { withId(R.id.description) }
    val name = KEditText { withId(R.id.name) }
    val surname = KEditText { withId(R.id.surname) }
    val phone = KEditText { withId(R.id.phone) }
    val email = KEditText { withId(R.id.email) }
    val saveButton = KButton { withId(R.id.confirm_button) }

    fun checkScreenIsVisible() {
        toolbar.isVisible()
        description.isVisible()
        name.isVisible()
        surname.isVisible()
        phone.isVisible()
        email.isVisible()
        saveButton.isVisible()
    }
}
