package ru.letu.ui.tests.regression.smoke.deeplinks

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import org.junit.Test
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.ui.base.DefaultTest
import ru.letu.ui.helpers.utils.testdata.Deeplink.DEEPLINK_ARTICLES
import ru.letu.ui.screens.ArticleListScreen

class DeeplinkArticlesTest : DefaultTest(
    "Проверка Deeplinks. Статьи"
) {
    @Test
    @AllureId("63940")
    @Step("Проверка Deeplinks. Статьи")
    fun deeplinkArticlesTest_63940() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Проверка Deeplinks. Статьи") {
            featureRouter.open(DEEPLINK_ARTICLES)
            ArticleListScreen.assertArticleListScreenOpen()
        }
    }
}
