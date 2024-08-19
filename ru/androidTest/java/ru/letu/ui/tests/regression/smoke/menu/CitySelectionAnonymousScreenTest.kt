package ru.letu.ui.tests.regression.smoke.menu

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation

class CitySelectionAnonymousScreenTest : DefaultTest(
    "Android.Меню.Выбор города. Экран выбора города (аноним)"
) {
    @Test
    @AllureId("62352")
    @Step("Android.Меню.Выбор города. Экран выбора города (аноним)")
    fun citySelectionScreenTest_62352() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Android.Меню.Выбор города. Экран выбора город") {
            Navigation.openBottomMenu()
            MenuScreen.openCitySelectionScreen()
        }
    }
}
