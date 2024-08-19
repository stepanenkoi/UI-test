package ru.letu.ui.tests.regression.smoke.profile

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.TestConst.SMS
import ru.letu.ui.helpers.utils.testdata.TestConst.USER_FOR_DELETE
import ru.letu.ui.scenarios.RegScenario
import ru.letu.ui.screens.DelAccountScreen
import ru.letu.ui.screens.DelYourAccountHasBeenDeletedScreen
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.ProfileScreen

class ProfileDelAccountTest : DefaultTest(
    "Mobile.Android.Меню.Профиль.Удалить профиль: Удаление аккаунта- Прямой кейс"
) {
    @Test
    @AllureId("23729")
    @Step("Mobile.Android.Меню.Профиль.Удалить профиль: Удаление аккаунта- Прямой кейс")
    fun profileDelAccountTest_23729() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Меню.Профиль.Удалить профиль: Удаление аккаунта- Прямой кейс") {
            scenario(RegScenario(USER_FOR_DELETE, SMS))
            MenuScreen.openProfileScreen()
            ProfileScreen {
                profileScrollToEnd()
                flakySafely { clickAccountDelBtn() }
            }
            DelAccountScreen {
                assertDelAccountScreenOpen(USER_FOR_DELETE)
                typeCodeDelAccount(SMS)
                clickDelAccountBtn()
            }
            DelYourAccountHasBeenDeletedScreen.clickYourAccountHasBeenDelBtn()
            Navigation.openBottomMenu()
            MenuScreen.assertUserIsNotAuthorized()
        }
    }
}
