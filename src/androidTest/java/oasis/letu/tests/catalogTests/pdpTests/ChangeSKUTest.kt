package oasis.letu.tests.catalogTests.pdpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.сatalogScreens.PDPScreen
import org.junit.Test

class ChangeSKUTest : DefaultTest(
    "UAE. Mobile. Android. PDP.Изменение SKU на экране PDP"
) {
    @Test
    @AllureId("63516")
    @Step(
        "UAE. Mobile. Android. PDP.Изменение SKU на экране PDP"
    )
    fun authTest_63516() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        PDPScreen {
            getSKUPdp()
            checkSkuImage1()
            checkSkuImage2()
            checkSKU1Article()
            clickSkuImage3()
            checkSKU3Article()
            clickSkuImage2()
            checkSKU2Article()
        }
    }
}
