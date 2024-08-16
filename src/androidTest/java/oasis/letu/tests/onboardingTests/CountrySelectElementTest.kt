package oasis.letu.tests.onboardingTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.CookieScreen
import oasis.letu.screens.navigation.CountrySelectScreen
import oasis.letu.screens.navigation.LocationScreen
import oasis.letu.screens.navigation.NotifyScreen
import oasis.letu.screens.navigation.OnboardingScreen
import org.junit.Test

class CountrySelectElementTest : DefaultTest(
    "UAE.Mobile.Android.Вход в МП.Онбординг. Выбор страны после Тех.экранов"
) {
    @Test
    @AllureId("62331")
    @Step(
        "UAE.Mobile.Android.Вход в МП.Онбординг. Выбор страны после Тех.экранов"
    )
    fun authTest_62331() {
        testWithOnboarding()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        OnboardingScreen {
            Thread.sleep(22000) // нужен для ожидания последего экрана
            clickCloseButton()
        }
        CookieScreen {
            clickAllowButton()
        }
        NotifyScreen {
            clickAllowButton()
        }
        LocationScreen {
            clickAllowButton()
        }
        CountrySelectScreen {
            checkFlag()
            checkName()
            checkButton()
            clickName()
            checkCheckMark()
        }
    }
}
