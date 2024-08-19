/*
package ru.letu.ui.tests.tickets.plp.quiz

import android.app.Activity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import junit.framework.Assert.assertNotNull
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.letu.core.data.network.models.acquisition.isShowGrid
import ru.letu.ui.SplashActivity
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.catalog.plp.PLPActivity
import ru.letu.ui.catalog.plp.PlpAdapter
import ru.letu.ui.helpers.TestUtils.sleep
import ru.letu.ui.helpers.TestUtils.waitForResponses
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchActivity
import ru.letu.ui.screens.HomeScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.PLPScreen
import java.util.*

@RunWith(AndroidJUnit4::class)
@Ignore("turn on with https://alkorco.atlassian.net/browse/DC-2517")
class QuizPassTest : AllureTestCase() {
    private val oneSecondDelay = 1_000

    @get:Rule
    var mActivityTestRule = ActivityTestRule(SplashActivity::class.java)

    fun test_startQuiz_success() {
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
        }.after {
            mActivityTestRule.finishActivity()
        }.run {
            step("1 - Переход к квизу") {
                navigateToQuiz()
            }
            step("2 - Проверяем отображение кнопки \"Помощь в подборе аромата\"") {
                PLPScreen.checkIfStartQuizButtonVisible()
            }
            step("3 - Нажимаем на кнопку начала квиза и проверяем, что ответы отображаются") {
                PLPScreen.startQuizAndCheckRunningQuiz()
            }
        }
    }

    fun test_startQuizAndBackToNotStartedQuiz_success() {
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
        }.after {
            mActivityTestRule.finishActivity()
        }.run {
            step("1 - Переход к квизу") {
                navigateToQuiz()
            }
            step("2 - Нажимаем на кнопку начала квиза и проверяем, что ответы отображаются") {
                PLPScreen.startQuizAndCheckRunningQuiz()
            }
            step("3 - Нажимаем на кнопку назад") {
                PLPScreen.clickToQuizBackButton()
            }
            step("4 - Проверяем, что квиз не начат") {
                PLPScreen.checkIfQuizNotRunning()
            }
        }
    }


    fun test_errorShowedOnNotSelectedAnswer() {
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
        }.after {
            mActivityTestRule.finishActivity()
        }.run {
            step("1 - Переход к квизу") {
                navigateToQuiz()
                PLPScreen.startQuizAndCheckRunningQuiz()
                sleep(oneSecondDelay)
            }
            step("2 - Нажимаем на кнопку далее") {
                PLPScreen.clickToQuizNextButton()
            }
            step("3 - Проверяем, что отображается сообщение с ошибкой") {
                PLPScreen.checkErrorShowed()
                sleep(oneSecondDelay)
            }
        }
    }


    fun test_correctAnswerLayoutOnDifferentQuestions() {
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
        }.after {
            mActivityTestRule.finishActivity()
        }.run {
            step("1 - Переход к квизу") {
                navigateToQuiz()
                PLPScreen.startQuizAndCheckRunningQuiz()
                sleep(oneSecondDelay)
            }
            step("2 - Проверяем все ответы до предпоследнего. (потому что после ответа на последний вопрос придется очищать данные приложения,  тк квиз возможно пройти только 1 раз для пользователя)") {
                //Получаем текущую активити
                var currentActivity: Activity? = null
                InstrumentationRegistry.getInstrumentation().runOnMainSync {
                    currentActivity = ActivityLifecycleMonitorRegistry.getInstance()
                        .getActivitiesInStage(Stage.RESUMED).first()
                }
                val adapter: PlpAdapter = (currentActivity as PLPActivity).plpAdapter
                val questionnaire = adapter.questionnaire

                assertNotNull(questionnaire)
                assert(questionnaire!!.questions.isNotEmpty())

                questionnaire.questions.forEachIndexed { index, question ->
                    if (index < questionnaire.questions.size - 1) {
                        sleep(oneSecondDelay)
                        val isShowGrid = question.isShowGrid()
                        if (isShowGrid) {
                            PLPScreen.checkIsImageShowed()
                        } else {
                            PLPScreen.checkIsImageNotShowed()
                        }
                        val randomAnswerIndex = Random().nextInt(question.possibleAnswers.size)
                        PLPScreen.selectAnswerOnQuiz(randomAnswerIndex)
                        sleep(oneSecondDelay)
                        PLPScreen.clickToQuizNextButton()
                    }
                }
            }
        }
    }

    private fun navigateToQuiz() {
        waitForResponses()
        // Переходим на экран PLP Scent bibliotheque
        HomeScreen.clickOnScentBibliotheque()
        waitForResponses()
    }

}
*/
