package ru.letu.ui.tests.regression.menu.cityselection

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.CityList.INVALID_CITY_SEARCH_QUERY
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE_REG
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.ChooseRegionScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class CitySearchForAnInvalidTest : DefaultTest(
    "Android.Меню.Выбор города. Поиск невалидного города",
    loginPhone = PHONE_REG,
    loginSms = SMS
) {
    @Test
    @AllureId("62547")
    @Step("Android.Меню.Выбор города. Поиск невалидного города")
    fun citySearchForAnInvalidTest_62547() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Android.Меню.Выбор города. Поиск невалидного города") {
            Navigation.openBottomMenuIndex(1)
            MenuScreen.openCitySelectionScreen()
            ChooseRegionScreen {
                replaceTextInSearchField(INVALID_CITY_SEARCH_QUERY)
                assertCityNotFoundText()
            }
        }
    }
}
