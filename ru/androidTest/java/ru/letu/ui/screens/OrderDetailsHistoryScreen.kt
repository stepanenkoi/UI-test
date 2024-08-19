package ru.letu.ui.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.profile.orders.history.online.OrderHistoryDetailsFragment

object OrderDetailsHistoryScreen : KScreen<OrderDetailsHistoryScreen>() {

    override val layoutId: Int = R.layout.fragment_order_details
    override val viewClass: Class<*> = OrderHistoryDetailsFragment::class.java

    val recycler = KRecyclerView(
        builder = { withId(R.id.recycler_order_details) },
        itemTypeBuilder = {
            itemType(::ChildOrder)
        }
    )

    val toolbar = KToolbar { withId(R.id.toolbar) }

    fun checkOrderDetailsScreenIsVisible() {
        toolbar.isVisible()
        recycler.isVisible()
    }

    class ChildOrder(parent: Matcher<View>) : KRecyclerItem<ChildOrder>(parent) {
        val dateInfoText1 = KTextView {
            withIndex(0) {
                withId(R.id.txt_delivery_date)
            }
        }
        val dateInfoText2 = KTextView {
            withIndex(1) {
                withId(R.id.txt_delivery_date)
            }
        }
        val addressInfoText1 = KTextView {
            withIndex(0) {
                withId(R.id.txt_delivery_address)
            }
        }
        val addressInfoText2 = KTextView {
            withIndex(1) {
                withId(R.id.txt_delivery_address)
            }
        }
        val visibleChangeAddress = KTextView {
            withIndex(0) {
                withId(R.id.button_change_address)
            }
        }
        val invisibleChangeAddress = KTextView {
            withIndex(1) {
                withId(R.id.button_change_address)
            }
        }
        val visibleChangeDateTime = KTextView {
            withIndex(0) {
                withId(R.id.button_change_date)
            }
        }
        val invisibleChangeDateTime = KTextView {
            withIndex(1) {
                withId(R.id.button_change_date)
            }
        }
    }
}
