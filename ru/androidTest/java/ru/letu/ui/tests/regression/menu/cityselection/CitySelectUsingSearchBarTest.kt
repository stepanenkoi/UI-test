package ru.letu.ui.tests.regression.menu.cityselection

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.CityList.BARNAUL
import ru.letu.ui.helpers.utils.testdata.TestConst.PHONE_REG
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.screens.ChooseRegionScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class CitySelectUsingSearchBarTest : DefaultTest(
    "Android.Меню.Выбор города. Доступ к местоположению разрешен. Выбор города с помощью строки поиска",
    loginPhone = PHONE_REG,
    loginSms = SMS
) {
    @Test
    @AllureId("62534")
    @Step("Android.Меню.Выбор города. Доступ к местоположению разрешен. Выбор города с помощью строки поиска")
    fun citySelectUsingSearchBarTest_62534() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Android.Меню.Выбор города. Доступ к местоположению разрешен. Выбор города с помощью строки поиска") {
            Navigation.openBottomMenuIndex(1)
            MenuScreen.openCitySelectionScreen()
            ChooseRegionScreen {
                replaceTextInSearchField(BARNAUL)
                clickOnCityByName(BARNAUL)
            }
        }
    }
}
