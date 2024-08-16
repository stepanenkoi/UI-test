package oasis.letu.tests.onboardingTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.CookieScreen
import oasis.letu.screens.navigation.OnboardingScreen
import org.junit.Test

class CookieElementTest : DefaultTest(
    "UAE.Mobile.Android.Вход в МП.Онбординг. При нажатии на крестик на инф. экранах происходит переход " +
        "на Cookies экран"
) {
    @Test
    @AllureId("56716")
    @Step(
        "UAE.Mobile.Android.Вход в МП.Онбординг. При нажатии на крестик на инф. экранах происходит переход " +
            "на Cookies экран"
    )
    fun authTest_56716() {
        testWithOnboarding()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        OnboardingScreen {
            Thread.sleep(22000) // нужен для ожидания последего экрана
            clickCloseButton()
        }
        CookieScreen {
            checkBackgroundImage()
            checktextHeader()
            checktextMain()
            checkAllowButton()
        }
    }
}
