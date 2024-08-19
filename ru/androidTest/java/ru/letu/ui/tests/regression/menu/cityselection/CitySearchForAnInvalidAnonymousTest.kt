package ru.letu.ui.tests.regression.menu.cityselection

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.ChooseRegionScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.helpers.utils.testdata.CityList

class CitySearchForAnInvalidAnonymousTest : DefaultTest(
    "Android.Меню.Выбор города. Поиск невалидного города (аноним)"
) {
    @Test
    @AllureId("49070")
    @Step("Android.Меню.Выбор города. Поиск невалидного города (аноним)")
    fun citySearchForAnInvalidAnonymousTest_49070() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Android.Меню.Выбор города. Поиск невалидного города (аноним)") {
            Navigation.openBottomMenu()
            MenuScreen.openCitySelectionScreen()
            ChooseRegionScreen {
                replaceTextInSearchField(CityList.INVALID_CITY_SEARCH_QUERY)
                assertCityNotFoundText()
            }
        }
    }
}
