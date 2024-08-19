package ru.letu.ui.tests.regression.menu.cityselection

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.ChooseRegionScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.helpers.utils.testdata.CityList.BARNAUL

class CitySelectUsingSearchBarAnonymousTest : DefaultTest(
    "Android.Меню.Выбор города. Выбор города с помощью строки поиска (аноним)"
) {
    @Test
    @AllureId("49066")
    @Step("Android.Меню.Выбор города. Выбор города с помощью строки поиска (аноним)")
    fun citySelectUsingSearchBarAnonymousTest_49066() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Android.Меню.Выбор города. Выбор города с помощью строки поиска (аноним)") {
            Navigation.openBottomMenu()
            MenuScreen.openCitySelectionScreen()
            ChooseRegionScreen {
                replaceTextInSearchField(BARNAUL)
                clickOnCityByName(BARNAUL)
            }
        }
    }
}
