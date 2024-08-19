package ru.letu.ui.screens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.toolbar.KToolbar
import io.qameta.allure.kotlin.Allure.step
import ru.letu.R
import ru.letu.ui.help.HelpFragment
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

object HelpScreen : KScreen<HelpScreen>() {
    override val layoutId: Int = R.layout.fragment_help
    override val viewClass: Class<*> = HelpFragment::class.java

    val toolbar = KToolbar { withId(R.id.toolbar_main) }

    val aboutInfo = KTextView { withText(RCoreResources.string.app_help_info) }
    val aboutPayment = KView { withId(R.id.payment) }
    val aboutDelivery = KView { withId(R.id.delivery) }
    val aboutRefund = KView { withId(R.id.refund) }

    fun assertHelpScreenOpen() {
        step("Экран Помощь открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_help)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            aboutInfo.isDisplayed()
            aboutPayment.isDisplayed()
            aboutDelivery.isDisplayed()
            aboutRefund.isDisplayed()
        }
    }
}
