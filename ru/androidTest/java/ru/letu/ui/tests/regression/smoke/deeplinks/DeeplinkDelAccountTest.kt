package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_DELETE
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.DelAccountScreen

class DeeplinkDelAccountTest : DefaultTest(
    "Проверка Deeplinks. Удаление аккаунта",
    loginPhone = PHONE,
    loginSms = SMS
) {
    @Test
    @AllureId("63998")
    @Step("Проверка Deeplinks. Удаление аккаунта")
    fun deeplinkDelAccountTest_63998() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Удаление аккаунта") {
            featureRouter.open(DEEPLINK_DELETE)
            DelAccountScreen.assertDelAccountScreenOpen(PHONE)
        }
    }
}
