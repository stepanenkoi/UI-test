package ru.letu.ui.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import ru.letoile.android.remoteconfig.api.isEnabled
import ru.letu.R
import ru.letu.profile.presentation.feature.ProfileFeatures
import ru.letu.profile.presentation.fragment.profile.ProfileFragment
import ru.letu.ui.helpers.utils.extensions.isNotEmpty
import ru.letu.ui.helpers.utils.kview.KCardView

/**
 * Created by Vladislav Kochetov on 15.03.2022.
 */
object AccountProfileScreen : KScreen<AccountProfileScreen>() {

    val profileList = KRecyclerView(
        builder = { withId(R.id.contentRecycler) },
        itemTypeBuilder = {
            itemType(AccountProfileScreen::AccountProfileInfo)
            itemType(AccountProfileScreen::AccountLoyaltyNplWidget)
            itemType(AccountProfileScreen::AccountLoyaltyShowQrButton)
            itemType(AccountProfileScreen::AccountCouponsWidget)
            itemType(AccountProfileScreen::AccountOrderWidget)
            itemType(AccountProfileScreen::AccountMenuLink)
            itemType(AccountProfileScreen::AccountMenuButton)
        }
    )

    override val layoutId: Int
        get() = R.layout.fragment_profile

    override val viewClass: Class<*>
        get() = ProfileFragment::class.java

    fun checkConsistency() {
        profileList.isNotEmpty()
    }

    fun checkConsistencyProfileInfo() {
        profileList {
            firstChild<AccountProfileInfo> {
                isDisplayed()
                title.hasAnyText()
                subTitle.hasAnyText()
            }
        }
    }

    /**
     * Check if "account_widget_loyalty_toggle" & "card_loyalty_program_toggle" & User.isLoyaltyCard is true
     * */
    fun checkConsistencyLoyaltyNplWidget() {
        profileList {
            children<AccountLoyaltyNplWidget> {
                isDisplayed()
            }
            children<AccountLoyaltyShowQrButton> {
                isDisplayed()
            }
        }
    }

    fun checkConsistencyOrderWidget() {
        profileList {
            children<AccountOrderWidget> {
                isDisplayed()
                title.hasAnyText()
            }
        }
    }

    /** Needs for account_widget_coupons_toggle + profile_coupons_toggle */
    fun checkConsistencyCouponsWidget() {
        profileList {
            children<AccountCouponsWidget> {
                isDisplayed()
                title.hasAnyText()
            }
        }
    }

    fun checkConsistencyMenuLink() {
        profileList {
            children<AccountMenuLink> {
                isDisplayed()
            }
        }
    }

    fun checkConsistencyMenuButton() {
        if (ProfileFeatures.ACCOUNT_MENU_DELETE.isEnabled()) {
            profileList {
                lastChild<AccountMenuButton> {
                    isDisplayed()
                    button.hasAnyText()
                    message.hasAnyText()
                }
            }
        }
    }

    /** UIAccountProfileInfoCartridgeViewHolder */
    class AccountProfileInfo(parent: Matcher<View>) : KRecyclerItem<AccountProfileInfo>(parent) {
        val title = KTextView { withIndex(0) { withId(R.id.text_profile_info_title) } }
        val subTitle = KTextView { withIndex(0) { withId(R.id.text_profile_info_subtitle) } }
    }

    /** UIActiveNdkHolder */
    class AccountLoyaltyNplWidget(parent: Matcher<View>) : KRecyclerItem<AccountProfileInfo>(parent) {
        val card = KCardView { withIndex(0) { withId(ru.letu.feature.loyalty.R.id.card_main) } }
    }

    /** UiAccountWidgetLoyaltyShowQrButtonCartridgeHolder */
    class AccountLoyaltyShowQrButton(parent: Matcher<View>) : KRecyclerItem<AccountProfileInfo>(parent) {
        val title = KTextView { withIndex(0) { withId(ru.letu.feature.loyalty.R.id.text_loyalty_qr_button) } }
    }

    /** UiAccountWidgetCouponsCartridgeHolder */
    class AccountCouponsWidget(parent: Matcher<View>) : KRecyclerItem<AccountCouponsWidget>(parent) {
        val title = KTextView { withIndex(0) { withId(R.id.text_list_title) } }
    }

    /** UIAccountWidgetOrdersCartridgeViewHolder */
    class AccountOrderWidget(parent: Matcher<View>) : KRecyclerItem<AccountOrderWidget>(parent) {
        val title = KTextView { withIndex(0) { withId(R.id.text_list_title) } }
    }

    /** UIAccountMenuLinkCartridgeViewHolder */
    class AccountMenuLink(parent: Matcher<View>) : KRecyclerItem<AccountMenuLink>(parent) {
        val title = KTextView { withIndex(0) { withId(R.id.text_account_menu_item_title) } }
        val badge = KTextView { withIndex(0) { withId(R.id.text_account_menu_item_badge) } }
    }

    /** UIAccountMenuButtonCartridgeViewHolder */
    class AccountMenuButton(parent: Matcher<View>) : KRecyclerItem<AccountMenuButton>(parent) {
        val button = KTextView { withIndex(0) { withId(R.id.account_menu_button) } }
        val message = KTextView { withIndex(0) { withId(R.id.account_menu_button_message) } }
    }
}
