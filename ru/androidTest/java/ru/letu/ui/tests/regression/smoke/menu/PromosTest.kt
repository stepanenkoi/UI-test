package ru.letu.ui.tests.regression.smoke.menu

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class PromosTest : DefaultTest(
    "Mobile. Android. Меню. Акции"
) {
    @Test
    @AllureId("26777")
    @Step("Mobile. Android. Меню. Акции")
    fun promosTest_26777() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Меню. Акции") {
            Navigation.openBottomMenu()
            MenuScreen.clickPromoBtn()
//            PromosScreen.assertPromosScreen()
//            PromosScreen.clickPromos()
//            PromotionScreen.assertPromoCodeScreen()
        }
    }
}
