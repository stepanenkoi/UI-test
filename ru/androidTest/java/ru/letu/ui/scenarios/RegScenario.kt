package ru.letu.ui.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.feature.loyalty.routes.LoyaltyRoute
import ru.letu.routes.AuthRoute
import ru.letu.ui.helpers.TestUtils
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.SimplifiedAuthorizationScreen
import ru.letu.ui.screens.bottomsheet.NewLoyaltyProgramInfoBottomSheetScreen.assertNewLoyaltyProgramInfoBottomSheetScreenOpen

class RegScenario(phone: String, sms: String) : Scenario() {
    override val steps: TestContext<Unit>.() -> Unit = {
        step("Зарегистрироваться по телефону $phone") {
            featureRouter forward AuthRoute.registerByPhone(TestUtils.phoneNumberRu(phone), AuthRoute.LoginSource.MENU)
            SimplifiedAuthorizationScreen.enterPhoneCode(sms)
            Thread.sleep(5000)
            SimplifiedAuthorizationScreen.continueButton {
                isEnabled()
                click()
            }
            assertNewLoyaltyProgramInfoBottomSheetScreenOpen()
            featureRouter forward LoyaltyRoute.LOYALTY_CARD
            Navigation.openBottomMenuIndex()
        }
    }
}
