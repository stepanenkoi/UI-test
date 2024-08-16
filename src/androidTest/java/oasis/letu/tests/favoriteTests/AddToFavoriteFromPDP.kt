package oasis.letu.tests.favoriteTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.BottomNavigation
import oasis.letu.screens.сatalogScreens.PDPScreen
import org.junit.Test

class AddToFavoriteFromPDP : DefaultTest(
    "UAE.Mobile.Android.Избранное.Добавление. Добавление товара в Избранное с PDP. Юзер аноним"
) {
    @Test
    @AllureId("60086")
    @Step(
        "UAE.Mobile.Android.Избранное.Добавление. Добавление товара в Избранное с PDP. Юзер аноним"
    )
    fun authTest_60086() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        PDPScreen {
            getPdp()
            clickFavoriteButton()
        }
        BottomNavigation {
            openFavorite()
        }
    }
}
