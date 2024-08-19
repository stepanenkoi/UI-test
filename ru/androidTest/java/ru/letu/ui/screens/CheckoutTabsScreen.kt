package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.letu.feature.checkout.R
import ru.letu.feature.checkout.fragment.CheckoutMultiDeliveryFragment
import ru.letu.R as R1
import ru.letu.feature.checkout.R as RCheckout

object CheckoutTabsScreen : LetuKScreen<CheckoutTabsScreen>(
    RCheckout.layout.fragment_checkout_multi_delivery,
    CheckoutMultiDeliveryFragment::class.java,
    R1.id.coordinatorLayout
) {

    val recyclerView = KRecyclerView(
        builder = { withId(ru.letu.core.endeca.R.id.endecaRecycler) },
        itemTypeBuilder = {
            itemType(::CheckoutTabsHolder)
        }
    )

    class CheckoutTabsHolder(parent: Matcher<View>) : KRecyclerItem<CheckoutTabsHolder>(parent) {
        val selectCity = KView(parent) { withId(R.id.select_city) }
        val changeCity = KButton(parent) { withId(R.id.changeCity) }
        val pickupTab = KView(parent) { withId(R.id.pickupTab) }
        val pickupTabTitle = KTextView(parent) { withId(R.id.pickupTab_text) }
        val courierTab = KView(parent) { withId(R.id.courierTab) }
        val courierTabTitle = KTextView(parent) { withId(R.id.courierTab_text) }
        val pickup = KView(parent) { withId(R.id.pickup) }
        val point = KView(parent) { withId(R.id.point_of_issue) }
        val courier = KView(parent) { withId(R.id.courier) }
    }
}
