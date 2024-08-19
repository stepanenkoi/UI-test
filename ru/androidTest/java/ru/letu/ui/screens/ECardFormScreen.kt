package ru.letu.ui.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.toolbar.KToolbar
import ru.letu.R
import ru.letu.core.endeca.ui.CartridgesFragment
import ru.letu.ui.screens.item.ButtonItem
import ru.letu.ui.screens.item.InputTextItem

object ECardFormScreen : KScreen<ECardFormScreen>() {
    override val layoutId: Int = ru.letu.core.endeca.R.layout.fragment_cartridges
    override val viewClass: Class<*> = CartridgesFragment::class.java

    val toolbar = KToolbar { withId(R.id.toolbar) }
    val recyclerView = KRecyclerView(
        builder = { withId(ru.letu.core.endeca.R.id.endecaRecycler) },
        itemTypeBuilder = {
            itemType(::InputTextItem)
            itemType(::ButtonItem)
        }
    )

    fun phoneInput(cartridgeAssertion: InputTextItem.() -> Unit) {
        recyclerView.childAt(16, cartridgeAssertion)
    }

    fun emailInput(cartridgeAssertion: InputTextItem.() -> Unit) {
        recyclerView.childAt(17, cartridgeAssertion)
    }

    fun saveButton(cartridgeAssertion: ButtonItem.() -> Unit) {
        recyclerView.childAt(28, cartridgeAssertion)
    }
}
