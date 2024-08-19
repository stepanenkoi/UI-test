package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.letu.R

object SkuSwatchScreen : Screen<SkuSwatchScreen>() {

    val skuSwatchList = KRecyclerView(
        builder = { withId(R.id.sku) },
        itemTypeBuilder = { itemType(SkuSwatchScreen::SkuSwatchItem) }
    )

    class SkuSwatchItem(parent: Matcher<View>) : KRecyclerItem<SkuSwatchItem>(parent) {
        val notAvailableSku = KTextView(parent) { withId(ru.letu.feature.product.R.id.sku_availability_overlay) }
    }
}
