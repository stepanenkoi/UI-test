package ru.letu.ui.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.profile.orders.history.online.OrdersHistoryListFragment

object OrdersHistoryListScreen : KScreen<OrdersHistoryListScreen>() {

    override val layoutId: Int = R.layout.fragment_orders_history_list
    override val viewClass: Class<*> = OrdersHistoryListFragment::class.java

    val endecaRecycler = KRecyclerView(
        builder = { withId(ru.letu.core.endeca.R.id.endecaRecycler) },
        itemTypeBuilder = {
            itemType(::SingleShipmentOrder)
            itemType(::MultiShipmentOrder)
            itemType(::Header)
        }
    )

    val toolbar = KToolbar { withId(R.id.toolbar_main) }

    class SingleShipmentOrder(parent: Matcher<View>) : KRecyclerItem<SingleShipmentOrder>(parent) {
        val departureInfo = KView {
            withIndex(0) {
                withId(R.id.departure_info_container)
            }
        }
        val changedDateNotificationGone = KTextView {
            withIndex(0) {
                withId(R.id.notification)
            }
        }
        val changedDateNotificationVisible = KTextView {
            withIndex(1) {
                withId(R.id.notification)
            }
        }
    }

    class MultiShipmentOrder(parent: Matcher<View>) : KRecyclerItem<MultiShipmentOrder>(parent) {
        val self = KView { withMatcher(parent) }
        val changedDateNotificationGone = KTextView {
            withIndex(0) {
                withId(R.id.notification)
            }
        }
        val changedDateNotificationVisible = KTextView {
            withIndex(3) {
                withId(R.id.notification)
            }
        }
    }

    class Header(parent: Matcher<View>) : KRecyclerItem<Header>(parent) {
        val title = KTextView {
            withIndex(1) {
                withText("История заказов")
            }
        }
    }
}
