package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_MESSAGES
import ru.letu.ui.helpers.utils.testdata.TestConst
import ru.letu.ui.screens.AppealScreen

class DeeplinkMessagesTest : DefaultTest(
    "Проверка Deeplinks. Мои обращения",
    loginPhone = TestConst.PHONE,
    loginSms = TestConst.SMS
) {
    @Test
    @AllureId("63801")
    @Step("Проверка Deeplinks. Мои обращения")
    fun deeplinkOrdersTest_63801() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Мои обращения") {
            featureRouter.open(DEEPLINK_MESSAGES)
            AppealScreen.assertAppealScreenOpen()
        }
    }
}
