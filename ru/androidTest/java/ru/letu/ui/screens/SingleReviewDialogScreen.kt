package ru.letu.ui.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import ru.letu.core.endeca.R
import ru.letu.feature.reviews.ui.singlereview.SingleReviewBottomSheetDialog

object SingleReviewDialogScreen : KScreen<SingleReviewDialogScreen>() {
    override val layoutId: Int = R.layout.sheet_cartridges_fragment
    override val viewClass: Class<*> = SingleReviewBottomSheetDialog::class.java

    val recyclerView = KRecyclerView(
        builder = { withId(R.id.endecaRecycler) },
        itemTypeBuilder = {
            itemType(PDPScreen::Review)
        }
    )
}
