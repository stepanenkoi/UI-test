package oasis.letu.tests.onboardingTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.screens.navigation.CookieScreen
import oasis.letu.screens.navigation.OnboardingScreen
import oasis.letu.screens.navigation.StaticPageScreen
import org.junit.Test

class CookieLinkTest : DefaultTest(
    "UAE.Mobile.Android.Вход в МП.Онбординг. Проверка ссылок на Cookies экране"
) {
    @Test
    @AllureId("56718")
    @Step(
        "UAE.Mobile.Android.Вход в МП.Онбординг. Проверка ссылок на Cookies экране"
    )
    fun authTest_56718() {
        testWithOnboarding()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        OnboardingScreen {
            Thread.sleep(22000) // нужен для ожидания последего экрана
            clickCloseButton()
        }
        CookieScreen {
            clickLink()
        }
        StaticPageScreen {
            checkContent()
        }
    }
}
