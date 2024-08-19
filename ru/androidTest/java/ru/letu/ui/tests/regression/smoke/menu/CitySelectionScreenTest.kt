package ru.letu.ui.tests.regression.smoke.menu

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE_REG
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class CitySelectionScreenTest : DefaultTest(
    "Android.Меню.Выбор города. Экран выбора города",
    loginPhone = PHONE_REG,
    loginSms = SMS
) {
    @Test
    @AllureId("49063")
    @Step("Android.Меню.Выбор города. Экран выбора город")
    fun citySelectionScreenTest_49063() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Android.Меню.Выбор города. Экран выбора город") {
            Navigation.openBottomMenuIndex(1)
            MenuScreen.openCitySelectionScreen()
        }
    }
}
