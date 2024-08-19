package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_CLIENT_CARD_TWO
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.ClientCardScreen

class DeeplinkClientCardTwoTest : DefaultTest(
    "Проверка Deeplinks. Карта клиента. Второй кейс",
    loginPhone = PHONE,
    loginSms = SMS
) {
    @Test
    @AllureId("64011")
    @Step("Проверка Deeplinks. Карта клиента. Второй кейс")
    fun deeplinkClientCardTwoTest_64011() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Карта клиента. Второй кейс") {
            featureRouter.open(DEEPLINK_CLIENT_CARD_TWO)
            ClientCardScreen.assertClientCardScreenOpen()
        }
    }
}
