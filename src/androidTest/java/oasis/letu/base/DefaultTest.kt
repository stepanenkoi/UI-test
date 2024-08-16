package oasis.letu.base

import android.Manifest
import android.content.Context
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.files.attachViewHierarchyToAllureReport
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.interceptors.watcher.testcase.TestRunWatcherInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.params.ScreenshotParams
import com.kaspersky.kaspresso.params.VideoParams
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.testcases.models.info.TestInfo
import ru.letoile.android.remoteconfig.api.FeatureManagerHolder
import io.qameta.allure.kotlin.Allure.step
import oasis.letu.helper.accessLocationPermissions
import org.junit.Rule
import ru.letu.navigation.core.routing.featureRouter
import ru.letu.routes.MainFlowRoute
import ru.letu.ui.base.MainActivity
/**
 * Kaspresso TestCase with build-in Allure support
 */
abstract class DefaultTest(
    private val testName: String,
    private val startActivityIntentCreator: ((Context) -> Intent)? = null,
    permissions: List<String> = listOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
    ),
    private val startActivityClass: Class<MainActivity> = MainActivity::class.java,
    private val runBeforeBlock: (() -> Unit)? = null,
    private val runAfterBlock: (() -> Unit)? = null
) : TestCase(
    kaspressoBuilder = run {
        Kaspresso.Builder.simple(
            customize = {
                videoParams = VideoParams(bitRate = 10_000_000, startRecordingTimeMs = 4_000L)
                screenshotParams = ScreenshotParams(quality = 1)
            }
        )
        Kaspresso.Builder.withForcedAllureSupport()
    }.apply {
        testRunWatcherInterceptors.apply {
            add(object : TestRunWatcherInterceptor {
                override fun onTestFinished(testInfo: TestInfo, success: Boolean) {
                    viewHierarchyDumper.dumpAndApply("ViewHierarchy") { attachViewHierarchyToAllureReport() }
                }
            })
        }
    }
) {

    @get:Rule
    val runtimePermissionRule: GrantPermissionRule = GrantPermissionRule.grant(*permissions.toTypedArray())
    private var activityScenario: ActivityScenario<MainActivity>? = null

    abstract val runSteps: TestContext<Unit>.() -> Unit

    fun test() {
        before(testName) {
            runBeforeBlock?.invoke()
            val context = InstrumentationRegistry.getInstrumentation().targetContext
            activityScenario = startActivityIntentCreator?.let {
                ActivityScenario.launch(it.invoke(context))
            } ?: ActivityScenario.launch(startActivityClass)
            accessLocationPermissions()
            FeatureManagerHolder.init(FeatureUiToggles)
            skipOnboardingInTest()
        }.after {
            runAfterBlock?.invoke()
            FeatureManagerHolder.init(FeatureUiToggles)
            activityScenario?.close()
        }.run {
            runSteps.invoke(this)
        }
    }
    fun testWithOnboarding() {
        before(testName) {
            runBeforeBlock?.invoke()
            val context = InstrumentationRegistry.getInstrumentation().targetContext
            activityScenario = startActivityIntentCreator?.let {
                ActivityScenario.launch(it.invoke(context))
            } ?: ActivityScenario.launch(startActivityClass)
            accessLocationPermissions()
            FeatureManagerHolder.init(FeatureUiToggles)
        }.after {
            runAfterBlock?.invoke()
            FeatureManagerHolder.init(FeatureUiToggles)
            activityScenario?.close()
        }.run {
            runSteps.invoke(this)
        }
    }

    private fun skipOnboardingInTest() {
        step("Пропускаем онбординг") {
            Thread.sleep(2000)
            featureRouter newRoot MainFlowRoute()
        }
    }

    companion object {
        const val WAIT_TIME = 10000L
    }
}
