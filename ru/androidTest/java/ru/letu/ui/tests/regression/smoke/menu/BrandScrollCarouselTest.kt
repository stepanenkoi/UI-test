package ru.letu.ui.tests.regression.smoke.menu

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.screens.BrandScreen

class BrandScrollCarouselTest : DefaultTest(
    "Mobile.Android.Меню.Бренды. Пролистать карусель"
) {
    @Test
    @AllureId("64507")
    @Step("Mobile.Android.Меню.Бренды. Пролистать карусель")
    fun brandScrollCarouselTest_64507() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Меню.Бренды. Пролистать карусель") {
            BrandScreen {
                openBrandList()
                scrollBrands()
            }
        }
    }
}
