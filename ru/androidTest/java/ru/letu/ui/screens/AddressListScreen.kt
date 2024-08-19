package ru.letu.ui.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.feature.addresses.view.AddressesFragment
import ru.letu.ui.helpers.utils.extensions.hasNoSize
import ru.letu.ui.helpers.utils.extensions.isNotEmpty
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.addresses.R as RDelivery

/**
 * Created by Vladislav Kochetov on 10.03.2022.
 */
object AddressListScreen : KScreen<AddressListScreen>() {

    private val toolbar = KToolbar { withId(R.id.toolbar_main) }
    private val addAddressButton = KButton { withId(RDelivery.id.button_add_address) }
    private val emptyAddressListText = KTextView { withId(RDelivery.id.text_empty_address_list) }
    private val addressListRecycler = KRecyclerView(
        builder = { withId(R.id.contentRecycler) },
        itemTypeBuilder = { itemType(AddressListScreen::AddressItem) }
    )

    override val layoutId: Int
        get() = RDelivery.layout.fragment_addresses

    override val viewClass: Class<*>
        get() = AddressesFragment::class.java

    fun consistencyCheck() {
        toolbar.isDisplayed()
        addAddressButton.isClickable()
        emptyAddressListText.isNotDisplayed()
        addressListRecycler {
            isNotEmpty()
            hasNoSize(0)
            firstChild<AddressItem> {
                cityNameText {
                    isDisplayed()
                    hasAnyText()
                }
                showMoreButton.isDisplayed()
                defaultSwitcher.isDisplayed()
            }
        }
    }

    /** AccountAddressesItemHolder */
    class AddressItem(parent: Matcher<View>) : KRecyclerItem<AddressItem>(parent) {
        val cityNameText = KTextView {
            // Index 0 to avoid AmbiguousViewMatcherException
            withIndex(0) {
                withId(RDelivery.id.text_address_city_name)
            }
        }
        val showMoreButton = KImageView {
            withIndex(0) {
                withId(RDelivery.id.button_show_more)
            }
        }
        val defaultSwitcher = KSwitch {
            withIndex(0) {
                withId(RDelivery.id.switch_address_default)
            }
        }
    }

    fun assertAddressListScreenOpen() {
        step("Экран Мои адреса открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_saved_addresses)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            addAddressButton.isDisplayed()
            emptyAddressListText.isDisplayed()
        }
    }
}
