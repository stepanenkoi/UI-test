package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_AGREEMENT
import ru.letu.ui.screens.AgreementScreen

class DeeplinkAgreementTest : DefaultTest(
    "Проверка Deeplinks. Пользовательское соглашение"
) {
    @Test
    @AllureId("63869")
    @Step("Проверка Deeplinks. Пользовательское соглашение")
    fun deeplinkAgreementTest_63869() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Пользовательское соглашение") {
            featureRouter.open(DEEPLINK_AGREEMENT)
            flakySafely { AgreementScreen.assertAgreementScreenOpen() }
        }
    }
}
