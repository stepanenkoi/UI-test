package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_STREAMS
import ru.letu.ui.screens.StreamsListScreen

class DeeplinkOnlineStreamsTest : DefaultTest(
    "Проверка Deeplinks. Прямые эфиры"
) {
    @Test
    @AllureId("63802")
    @Step("Проверка Deeplinks. Прямые эфиры")
    fun deeplinkOnlineStreamsTest_63802() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Прямые эфиры") {
            featureRouter.open(DEEPLINK_STREAMS)
            StreamsListScreen.assertStreamsListScreenOpen()
        }
    }
}
