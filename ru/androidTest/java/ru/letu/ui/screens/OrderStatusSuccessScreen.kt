package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.helpers.utils.testdata.TestConst.ORDER_STATUS_SUCCESS
import ru.letu.core.endeca.R as REndeca

object OrderStatusSuccessScreen : Screen<OrderStatusSuccessScreen>() {

    private val orderStatusRecyclerView = KRecyclerView(
        { withId(REndeca.id.endecaRecycler) },
        {
            itemType(::OrderStatusItem)
        }
    )

    class OrderStatusItem(parent: Matcher<View>) : KRecyclerItem<OrderStatusItem>(parent) {
        val orderStatusTitle = KTextView(parent) {
            withId(R.id.title)
        }
    }

    fun assertOrderStatusSuccess() {
        orderStatusRecyclerView.firstChild<OrderStatusItem> {
            orderStatusTitle.containsText(ORDER_STATUS_SUCCESS)
        }
    }
}
