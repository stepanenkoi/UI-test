package ru.letu.ui.tests.regression.smoke.menu

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.base.FeatureUiToggles
import ru.letu.ui.screens.BrandScreen
import ru.letu.core_resources.R as RCoreResources

class BrandClickNameTest : DefaultTest(
    "Mobile.Android.Меню.Бренды. Нажать на название любого бренда в списке",
    runBeforeBlock = { FeatureUiToggles.enable("plp_mob_cartridges_brand_toggle") }
) {
    @Test
    @AllureId("64517")
    @Step("Mobile.Android.Меню.Бренды. Нажать на название любого бренда в списке")
    fun brandClickNameTest_64517() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Меню.Бренды. Нажать на название любого бренда в списке") {
            BrandScreen {
                openBrandList()
                clickBrandName(RCoreResources.string.abclean_brand_text)
            }
        }
    }
}
