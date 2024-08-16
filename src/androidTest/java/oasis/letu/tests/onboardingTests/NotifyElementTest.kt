package oasis.letu.tests.onboardingTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.CookieScreen
import oasis.letu.screens.navigation.NotifyScreen
import oasis.letu.screens.navigation.OnboardingScreen
import org.junit.Test

class NotifyElementTest : DefaultTest(
    "UAE.Mobile.Android.Вход в МП.Онбординг. Проверка наличия элементов экран Dont miss a thing"
) {
    @Test
    @AllureId("62729")
    @Step(
        "UAE.Mobile.Android.Вход в МП.Онбординг. Проверка наличия элементов экран Dont miss a thing"
    )
    fun authTest_62729() {
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
            checkBackgroundImage()
            checkSkipButton()
            checkTextHeader()
            checkTextMain()
            checkAllowButton()
            checkTextDescription()
        }
    }
}
