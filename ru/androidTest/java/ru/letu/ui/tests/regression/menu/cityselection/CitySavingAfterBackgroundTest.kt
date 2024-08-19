package ru.letu.ui.tests.regression.menu.cityselection

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.CityList.KRASNOYARSK
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE_REG
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.ChooseRegionScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class CitySavingAfterBackgroundTest : DefaultTest(
    "Android.Меню.Выбор города. Сохранение выбранного города после открытия приложения из бекграунда",
    loginPhone = PHONE_REG,
    loginSms = SMS
) {
    @Test
    @AllureId("62546")
    @Step("Android.Меню.Выбор города. Сохранение выбранного города после открытия приложения из бекграунда")
    fun citySavingAfterOpenAppFromBackgroundTest_62546() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Android.Меню.Выбор города. Сохранение выбранного города после открытия приложения из бекграунда") {
            Navigation.openBottomMenuIndex(1)
            MenuScreen.openCitySelectionScreen()
            ChooseRegionScreen.clickOnCityByName(KRASNOYARSK)
            MenuScreen.sendToBackground(3000, KRASNOYARSK)
        }
    }
}
