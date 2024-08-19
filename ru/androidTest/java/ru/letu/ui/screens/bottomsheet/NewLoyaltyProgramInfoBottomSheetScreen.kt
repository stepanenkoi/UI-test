package ru.letu.ui.screens.bottomsheet

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.feature.loyalty.R
import ru.letu.feature.loyalty.presentation.screen.dialog.NewLoyaltyProgramInfoBottomSheetFragment
import ru.letu.acquisition.R as RAcquisition

object NewLoyaltyProgramInfoBottomSheetScreen : KScreen<NewLoyaltyProgramInfoBottomSheetScreen>() {
    override val layoutId: Int = ru.letu.acquisition.R.layout.dialog_loyalty_program_info
    override val viewClass: Class<*> = NewLoyaltyProgramInfoBottomSheetFragment::class.java

    private val newLoyaltyRecycler = KRecyclerView(
        builder = { withId(RAcquisition.id.recycler_nlp) },
        itemTypeBuilder = {
            itemType(::NewLoyaltyItem)
        }
    )

    class NewLoyaltyItem(parent: Matcher<View>) : KRecyclerItem<NewLoyaltyItem>(parent) {
        val cardMain = KTextView { withId(R.id.card_main) }
    }

    private val loyaltyTitle = KTextView {
        withId(R.id.text_loyalty_title)
    }

    fun closeNewLoyaltyBottomSheet() {
        step("Закрыть Боттом щит Программы лояльности") {
            newLoyaltyRecycler.scrollToEnd()
        }
    }

    fun assertNewLoyaltyProgramInfoBottomSheetScreenOpen() {
        step("Боттом щит Программы лояльности открыт") {
            loyaltyTitle.isDisplayed()
        }
    }
}
