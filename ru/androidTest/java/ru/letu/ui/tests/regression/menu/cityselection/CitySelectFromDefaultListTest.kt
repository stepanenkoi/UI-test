package ru.letu.ui.tests.regression.menu.cityselection

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.CityList.NOVOSIBIRSK
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE_REG
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.ChooseRegionScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class CitySelectFromDefaultListTest : DefaultTest(
    "Android.Меню.Выбор города. Доступ к местоположению разрешен. Выбор города из дефолтного списка",
    loginPhone = PHONE_REG,
    loginSms = SMS
) {
    @Test
    @AllureId("62533")
    @Step("Android.Меню.Выбор города. Доступ к местоположению разрешен. Выбор города из дефолтного списка")
    fun citySelectFromDefaultListTest_62533() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Android.Меню.Выбор города. Доступ к местоположению разрешен. Выбор города из дефолтного списка") {
            Navigation.openBottomMenuIndex(1)
            MenuScreen.openCitySelectionScreen()
            ChooseRegionScreen.clickOnCityByName(NOVOSIBIRSK)
        }
    }
}
