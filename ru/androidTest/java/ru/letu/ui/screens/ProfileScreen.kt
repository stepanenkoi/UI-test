package ru.letu.ui.screens

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.ui.base.DefaultTest.Companion.WAIT_TIME
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.ui.screens.elements.ToolBarElementScreen.assertToolBarWithTitle
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.loyalty.R as RLoyalty

object ProfileScreen : Screen<ProfileScreen>() {
    val personalDataTitle = KTextView { withText(RCoreResources.string.app_private_data) }

    val deleteAccountButton = KButton { withId(R.id.btn_delete_account) }
    val resendCodeButton = KButton { withId(R.id.btn_resend_code) }
    private val profileUserName = KTextView {
        waitForDisplayed(R.id.text_profile_info_title, WAIT_TIME)
        withId(R.id.text_profile_info_title)
    }

    private val subTitle = KTextView { withId(R.id.text_profile_info_subtitle) }
    private val cardMain = KTextView { withId(RLoyalty.id.card_main) }

    private val cardNotActivatedText = KTextView {
        withId(RLoyalty.id.tv_not_activated)
        withText(RCoreResources.string.app_ndk_not_activated)
    }
    private val cardBonusesImg = KImageView {
        withId(RLoyalty.id.iv_bonuses)
        withDrawable(RLoyalty.drawable.ic_ndk_bonuses)
    }
    private val cardBonuses = KTextView { withId(RLoyalty.id.tv_bonuses) }
    private val cardBonusesText = KTextView { withId(RLoyalty.id.tv_letu) }
    private val cardPercent = KTextView { withId(RLoyalty.id.tv_percent) }

    private val accountDelBtn = KButton {
        withId(R.id.account_menu_button)
        withText(RCoreResources.string.app_profile_delete_button)
    }

    private val profileRecycler = KRecyclerView(
        builder = {
            isDescendantOfA { withId(R.id.swipe_refresh) }
            withId(R.id.contentRecycler)
                  },
        itemTypeBuilder = {
            itemType(ProfileScreen::ProfileViewHolder)
        }
    )

    class ProfileViewHolder(parent: Matcher<View>) : KRecyclerItem<ProfileViewHolder>(parent) {
        val title = KTextView { withIndex(0) { withId(R.id.text_profile_info_title) } }
        val subTitle = KTextView { withIndex(0) { withId(R.id.text_profile_info_subtitle) } }
    }

    fun logoutUser() {
        profileUserName
    }

    fun profileScrollToEnd() {
        step("Прокручиваем профиль до конца") {
            profileRecycler.scrollToEnd()
            assertDelBtnIsDisplayed()
        }
    }

    fun clickAccountDelBtn() {
        step("Нажать на кнопку Удалить профиль") {
            accountDelBtn {
                isDisplayed()
                longClick()
            }
            assertToolBarWithTitle(RCoreResources.string.app_profile_deletion_title)
        }
    }

    fun assertProfileOpen() {
        step("Экран профиля открыт") {
            waitForDisplayed(RLoyalty.id.card_main, WAIT_TIME)
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_profile)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            profileUserName.isDisplayed()
            subTitle.isDisplayed()
            cardMain.isDisplayed()
        }
    }

    fun assertProfileScreenOpen() {
        step("Экран профиля открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_profile)
                assertBackBtnToolBar()
            }
        }
    }

    private fun assertDelBtnIsDisplayed() {
        step("Кнопка удаления аккаута отображается") {
            accountDelBtn.isDisplayed()
        }
    }

    fun assertUserName(name: String) {
        step("Проверка имени пользователя $name") {
            waitForDisplayed(R.id.text_profile_info_title, WAIT_TIME)
            profileUserName.hasText(name)
        }
    }

    fun assertCardNotActivated() {
        step("Проверка что карта не активна") {
            cardNotActivatedText.isDisplayed()
            cardBonusesImg.isDisplayed()
            cardBonuses.isDisplayed()
            cardBonusesText.isDisplayed()
            cardPercent.isNotDisplayed()
        }
    }

    fun assertCardActivated() {
        step("Проверка что карта активна") {
            cardBonusesImg.isDisplayed()
            cardBonuses.isDisplayed()
            cardBonusesText.isDisplayed()
            cardPercent.isDisplayed()
        }
    }

    fun openPersonalDataInfo() {
        personalDataTitle {
            isVisible()
            click()
        }
    }

    fun checkDeleteButtonIsVisible() {
        deleteAccountButton {
            isVisible()
        }
    }

    fun openAccountDeletionScreen() {
        deleteAccountButton {
            isVisible()
            click()
        }
        closeSoftKeyboard()
    }

    fun checkReceiveNewCodeButtonsIsDisabled() {
        resendCodeButton {
            isDisabled()
        }
    }

    fun clickOnReceiveNewCode() {
        resendCodeButton {
            isVisible()
            click()
        }
    }

    fun checkDeleteButtonIsDisabled() {
        deleteAccountButton {
            isDisabled()
        }
    }
}
