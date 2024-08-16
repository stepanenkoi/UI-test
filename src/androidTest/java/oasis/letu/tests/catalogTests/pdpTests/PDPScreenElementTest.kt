package oasis.letu.tests.catalogTests.pdpTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.сatalogScreens.PDPScreen
import org.junit.Test

class PDPScreenElementTest : DefaultTest(
    "UAE.Mobile.Android.Каталог.Категории.PLP. PDP. Ключевые элементы на карточке товара"
) {
    @Test
    @AllureId("58815")
    @Step(
        "UAE.Mobile.Android.Каталог.Категории.PLP. PDP. Ключевые элементы на карточке товара"
    )
    fun authTest_58815() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        PDPScreen {
            getPdp()
            checkFavoriteButton()
            checkImage()
            checkName()
            checkArticle()
            checkPrice()
            checkRawPrice()
            checkDiscount()
            checkPDButton()
            checkPDText()
            scrollToBottom()
            checkAddToCartButton()
            clickAddToCartButton()
            checkMinus()
            checkCounter()
            checkPlus()
        }
    }
}
