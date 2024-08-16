package oasis.letu.tests.onboardingTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.CookieScreen
import oasis.letu.screens.navigation.LocationScreen
import oasis.letu.screens.navigation.NotifyScreen
import oasis.letu.screens.navigation.OnboardingScreen
import org.junit.Test

class LocationElementTest : DefaultTest(
    "UAE.Mobile.Android.Вход в МП.Онбординг. Проверка наличия элементов экран Allow your location"
) {
    @Test
    @AllureId("62730")
    @Step(
        "UAE.Mobile.Android.Вход в МП.Онбординг. Проверка наличия элементов экран Allow your location"
    )
    fun authTest_62730() {
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
            clickSkipButton()
        }
        LocationScreen {
            checkBackgroundImage()
            checkSkipButton()
            checkTextHeader()
            checkTextMain()
            checkAllowButton()
            checkTextDescription()
        }
    }
}
