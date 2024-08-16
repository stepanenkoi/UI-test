package oasis.letu.tests.catalogTests.pdpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.сatalogScreens.PDPScreen
import org.junit.Test

class OutOfStockPDPScreenElementTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP. PDP. Карточка товара которого нет в наличии (склад/магазин)"
) {
    @Test
    @AllureId("58822")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP. PDP. Карточка товара которого нет в наличии (склад/магазин)"
    )
    fun authTest_58822() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        PDPScreen {
            getOutOfStockPdp()
            checkFavoriteButton()
            checkImage()
            checkName()
            checkArticle()
            checkPDButton()
            checkPDText()
            scrollToBottom1()
            checkDescription()
        }
    }
}
