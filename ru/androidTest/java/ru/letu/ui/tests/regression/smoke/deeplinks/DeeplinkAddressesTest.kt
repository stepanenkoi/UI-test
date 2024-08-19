package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_ADDRESSES
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.AddressListScreen

class DeeplinkAddressesTest : DefaultTest(
    "Проверка Deeplinks. Адреса пользователя",
    loginPhone = PHONE,
    loginSms = SMS
) {
    @Test
    @AllureId("63816")
    @Step("Проверка Deeplinks. Адреса пользователяe")
    fun deeplinkAddressesTest_63816() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Адреса пользователя") {
            featureRouter.open(DEEPLINK_ADDRESSES)
            AddressListScreen.assertAddressListScreenOpen()
        }
    }
}
