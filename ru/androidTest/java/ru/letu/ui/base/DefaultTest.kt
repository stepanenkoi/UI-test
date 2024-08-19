package ru.letu.ui.base

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
import io.qameta.allure.kotlin.Allure.step
import org.junit.Rule
import ru.letoile.android.navigation.routing.featureRouter
import ru.letoile.android.remoteconfig.api.FeatureManagerHolder
import ru.letu.routes.AuthRoute
import ru.letu.routes.MainFlowRoute
import ru.letu.routes.ProfileRoute
import ru.letu.splashbanner.feature.SplashBannerFeatures
import ru.letu.ui.helpers.TestUtils.phoneNumberRu
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.screens.ProfileScreen
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

/**
 * Kaspresso TestCase with build-in Allure support
 */
abstract class DefaultTest(
    private val testName: String,
    private val loginPhone: String? = null,
    private val loginSms: String? = null,
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
    var activityScenario: ActivityScenario<MainActivity>? = null

    abstract val runSteps: TestContext<Unit>.() -> Unit

    fun test() {
        before(testName) {
            step("Before") {
            runBeforeBlock?.invoke()
                accessLocationPermissions()
                FeatureUiToggles.disable(SplashBannerFeatures.SPLASH_BANNER_AD_TOGGLE.key)
                FeatureManagerHolder.init(FeatureUiToggles)
                skipOnboardingInTest()
                val context = InstrumentationRegistry.getInstrumentation().targetContext
                activityScenario = startActivityIntentCreator?.let {
                    ActivityScenario.launch(it.invoke(context))
                } ?: ActivityScenario.launch(startActivityClass)
                if (loginSms != null && loginPhone != null) {
                    loginUser(loginPhone, loginSms)
                }
            }
        }.after {
            step("After") {
            runAfterBlock?.invoke()
                FeatureUiToggles.disable(SplashBannerFeatures.SPLASH_BANNER_AD_TOGGLE.key)
            FeatureManagerHolder.init(FeatureUiToggles)
            activityScenario?.close()
            }
        }.run {
            step("Test") {
                runSteps.invoke(this)
            }
        }
    }

    private fun skipOnboardingInTest() {
        step("Пропускаем онбординг") {
            featureRouter newRoot MainFlowRoute()
        }
    }

    private fun loginUser(phone: String, sms: String) {
        step("Авторизоваться по телефону $phone") {
            featureRouter forward AuthRoute.loginByPhone(phoneNumberRu(phone), AuthRoute.LoginSource.MENU)
            Thread.sleep(3000)
            SimplifiedAuthorizationScreen.enterPhoneCode(sms)
            Thread.sleep(5000)
            featureRouter forward ProfileRoute.PROFILE
            ProfileScreen.assertProfileScreenOpen()
        }
    }

    companion object {
        const val WAIT_TIME = 30000L
        const val LONG_WAIT_TIME = 60000L
    }
}
