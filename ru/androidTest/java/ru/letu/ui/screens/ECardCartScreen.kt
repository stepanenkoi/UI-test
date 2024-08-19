package ru.letu.ui.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.toolbar.KToolbar
import ru.letu.R
import ru.letu.core.endeca.ui.CartridgesFragment
import ru.letu.ui.screens.item.KeyValueItem
import ru.letu.ui.screens.item.TextItem

object ECardCartScreen : KScreen<ECardCartScreen>() {
    override val layoutId: Int = ru.letu.core.endeca.R.layout.fragment_cartridges
    override val viewClass: Class<*> = CartridgesFragment::class.java

    val toolbar = KToolbar { withId(R.id.toolbar) }
    val recyclerView = KRecyclerView(
        builder = { withId(ru.letu.core.endeca.R.id.endecaRecycler) },
        itemTypeBuilder = {
            itemType(::TextItem)
            itemType(::KeyValueItem)
        }
    )

    fun title(cartridgeAssertion: TextItem.() -> Unit) {
        recyclerView.childAt(0, cartridgeAssertion)
    }

    fun certificatesTitle(cartridgeAssertion: TextItem.() -> Unit) {
        recyclerView.childAt(2, cartridgeAssertion)
    }

    fun keyValue(position: Int, cartridgeAssertion: KeyValueItem.() -> Unit) {
        recyclerView.childAt(position, cartridgeAssertion)
    }
}
