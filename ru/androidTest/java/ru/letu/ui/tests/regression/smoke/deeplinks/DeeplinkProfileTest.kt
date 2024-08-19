package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_PROFILE
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.ProfileScreen

class DeeplinkProfileTest : DefaultTest(
    "Проверка Deeplinks. Profile",
    loginPhone = PHONE,
    loginSms = SMS
) {
    @Test
    @AllureId("63782")
    @Step("Проверка Deeplinks. Profile")
    fun deeplinkProfileTest_63782() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Profile") {
            featureRouter.open(DEEPLINK_PROFILE)
            ProfileScreen.assertProfileOpen()
        }
    }
}
