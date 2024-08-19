package ru.letu.ui.tests.oldtests.tests

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.R
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.help.HelpFragment
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.HelpScreen

@RunWith(AndroidJUnit4::class)
class HelpTests : AllureTestCase() {

    fun testHelpScreen() {
        var scenario: ActivityScenario<MainActivity>? = null
        before {
            scenario = launchFragmentInHiltContainer<HelpFragment>()
            accessLocationPermissions()
        }
            .after {
                scenario?.close()
            }
            .run {
                step("1. На экране отображается черный тулбар") {
                    HelpScreen {
                        toolbar.isVisible()
                        toolbar.hasBackgroundColor(R.color.white)
                    }
                }
                step("2. Экран содержит кликабельную вкладку 'Подробнее об оплате'") {
                    HelpScreen {
                        aboutPayment.isVisible()
                        aboutPayment.isClickable()
                        aboutDelivery.isVisible()
                        aboutDelivery.isClickable()
                        aboutRefund.isVisible()
                        aboutRefund.isClickable()
                    }
                }
                step("3. Перейти на вкладку 'Подробнее о возврате'") {
                    HelpScreen {
                        aboutRefund.click()
                    }
                }
            }
    }
}
