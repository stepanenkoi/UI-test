package ru.letu.ui.tests.regression.smoke.menu

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.BrandScreen

class BrandListTest : DefaultTest(
    "Mobile. Android. Меню. Бренды. Переход на PLP бренда"
) {
    @Test
    @AllureId("50390")
    @Step("Mobile. Android. Меню. Бренды. Переход на PLP бренда")
    fun brandListTest_50390() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile. Android. Меню. Бренды. Переход на PLP бренда") {
            BrandScreen.openBrandList()
            BrandScreen.assertBrandList()
        }
    }
}
