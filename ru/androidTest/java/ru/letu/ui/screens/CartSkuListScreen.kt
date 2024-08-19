package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.letu.feature.checkout.R as R1

object CartSkuListScreen : Screen<CartSkuListScreen>() {

    val skuList = KRecyclerView(
        builder = { withId(R1.id.allProductContent) },
        itemTypeBuilder = { itemType(CartSkuListScreen::SkuItem) }
    )

    class SkuItem(parent: Matcher<View>) : KRecyclerItem<SkuItem>(parent) {
        val warningProductStatus = KTextView(parent) { withId(R1.id.error) }
    }
}
