package ru.letu.ui.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.merchants.MerchantsFragment
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object MerchantListingScreen : KScreen<MerchantListingScreen>() {
    override val layoutId: Int = R.layout.fragment_merchant_list
    override val viewClass: Class<*> = MerchantsFragment::class.java
    val merchantsName = KTextView {
        withId(R.id.tv_merchants)
    }
    val merchantsCount = KTextView {
        withId(R.id.tv_merchants_count)
    }
    val merchantsRecycler = KRecyclerView(
        builder = { withId(R.id.merchants) },
        {
            itemType(MerchantListingScreen::Merchant)
        }
    )

    class Merchant(parent: Matcher<View>) : KRecyclerItem<Merchant>(parent) {
        val noProducts = KView { withId(R.id.iv_no_products) }
    }

    fun assertMerchantScreenOpen() {
        step("Экран Продавцы открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_merchants)
                assertBackBtnToolBar()
                assertSearchBtnToolBar()
            }
            merchantsName.isDisplayed()
            merchantsCount.isDisplayed()
            merchantsRecycler.isDisplayed()
        }
    }
}
