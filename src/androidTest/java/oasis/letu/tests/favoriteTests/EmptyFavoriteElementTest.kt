package oasis.letu.tests.favoriteTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.BottomNavigation
import org.junit.Test

class EmptyFavoriteElementTest : DefaultTest(
    "UAE.Mobile.Android.Избранное. Проверка наличия элементов на пустом Избранном"
) {
    @Test
    @AllureId("59533")
    @Step(
        "UAE.Mobile.Android.Избранное. Проверка наличия элементов на пустом Избранном"
    )
    fun authTest_59533() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        BottomNavigation {
            openEmptyFavorite()
        }
    }
}
