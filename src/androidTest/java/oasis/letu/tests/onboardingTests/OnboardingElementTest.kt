package oasis.letu.tests.onboardingTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.OnboardingScreen
import org.junit.Test

class OnboardingElementTest : DefaultTest(
    "UAE.Mobile.Android.Вход в МП.Онбординг. Проверка наличия элементов на всех экранах онбординга"
) {
    @Test
    @AllureId("56724")
    @Step(
        "UAE.Mobile.Android.Вход в МП.Онбординг.  Проверка наличия элементов на всех экранах онбординга"
    )
    fun authTest_56724() {
        testWithOnboarding()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        OnboardingScreen {
            Thread.sleep(22000) // нужен для ожидания последего экрана
            checkToolbar()
            checkCloseButton()
            checkTimer()
            checkTextTitle()
            checkTextSubtitle()
            checkVideo()
            checkButton()
        }
    }
}
