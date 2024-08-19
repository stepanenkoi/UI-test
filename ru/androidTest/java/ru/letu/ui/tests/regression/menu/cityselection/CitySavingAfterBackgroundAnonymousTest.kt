package ru.letu.ui.tests.regression.menu.cityselection

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.CityList.KRASNOYARSK
import ru.letu.ui.screens.ChooseRegionScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class CitySavingAfterBackgroundAnonymousTest : DefaultTest(
    "Android.Меню.Выбор города. Сохранение выбранного города после открытия приложения из бекграунда (аноним)"
) {
    @Test
    @AllureId("49074")
    @Step("Android.Меню.Выбор города. Сохранение выбранного города после открытия приложения из бекграунда (аноним)")
    fun cityBackgroundAnonymousTest_49074() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Сохранение выбранного города после открытия приложения из бекграунда (аноним)") {
            Navigation.openBottomMenuIndex()
            MenuScreen.openCitySelectionScreen()
            ChooseRegionScreen.clickOnCityByName(KRASNOYARSK)
            MenuScreen.sendToBackground(3000, KRASNOYARSK)
        }
    }
}
