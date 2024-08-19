package ru.letu.ui.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.feature.addresses.choose.v2.OrderChangeAddressFragment
import ru.letu.feature.addresses.R as DR

object OrderChangeAddressScreen : KScreen<OrderChangeAddressScreen>() {
    override val layoutId = DR.layout.fragment_order_change_address
    override val viewClass = OrderChangeAddressFragment::class.java

    val recycler = KRecyclerView(
        builder = { withId(DR.id.courierAddresses) },
        itemTypeBuilder = {
            itemType(::Address)
        }
    )

    val toolbar = KToolbar { withId(R.id.toolbar) }

    private val submitButton = KButton {
        withId(R.id.btn_submit)
    }

    private val addressHint = KTextView {
        withId(DR.id.tv_address_hint)
    }

    fun testChangeAddressScreen() {
        toolbar.isVisible()
        addressHint.isVisible()
        recycler.isVisible()
        submitButton.isVisible()
    }

    class Address(parent: Matcher<View>) : KRecyclerItem<Address>(parent) {
        val editIcon = KImageView {
            withIndex(0) {
                withId(DR.id.editIcon)
            }
        }
        val addressText = KTextView {
            withIndex(0) {
                withId(ru.letu.feature.addresses.R.id.address)
            }
        }
        val selectedIcon = KImageView {
            withIndex(0) {
                withId(DR.id.selectedIcon)
            }
        }
    }
}
