package ru.letu.ui.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.contactUs.ContactUsFragment

object ContactUsScreen : KScreen<ContactUsScreen>() {
    override val layoutId: Int = R.layout.fragment_contact_us
    override val viewClass: Class<*> = ContactUsFragment::class.java

    val toolbar = KToolbar { withId(R.id.toolbar_main) }
    val recyclerView = KRecyclerView(
        builder = { withId(R.id.contentRecycler) },
        itemTypeBuilder = {
            itemType(ContactUsScreen::ChatBot)
            itemType(ContactUsScreen::PhoneNumber)
        }
    )

    class ChatBot(parent: Matcher<View>) : KRecyclerItem<ChatBot>(parent) {
        val textView = KTextView { withMatcher(parent) }
    }

    class PhoneNumber(parent: Matcher<View>) : KRecyclerItem<PhoneNumber>(parent) {
        val textView = KTextView(parent) { withId(R.id.phone_number) }
    }
}
