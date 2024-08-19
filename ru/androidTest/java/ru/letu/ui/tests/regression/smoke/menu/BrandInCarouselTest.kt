package ru.letu.ui.tests.regression.smoke.menu

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.base.FeatureUiToggles
import ru.letu.ui.screens.BrandScreen

class BrandInCarouselTest : DefaultTest(
    "Mobile.Android.Меню.Бренды. Нажать на плитку любого бренда в карусели",
    runBeforeBlock = { FeatureUiToggles.enable("plp_mob_cartridges_brand_toggle") }
) {
    @Test
    @AllureId("64470")
    @Step(" Mobile.Android.Меню.Бренды. Нажать на плитку любого бренда в карусели")
    fun brandInCarouselTest_64470() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step(" Mobile.Android.Меню.Бренды. Нажать на плитку любого бренда в карусели") {
            BrandScreen {
                openBrandList()
                clickFeaturedBrandsItem(0)
            }
        }
    }
}
