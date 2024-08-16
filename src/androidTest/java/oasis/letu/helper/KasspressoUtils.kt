package oasis.letu.helper

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.core.util.Preconditions
import androidx.fragment.app.Fragment
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import ru.letu.R
import ru.letu.ui.base.MainActivity

/**
 * Launches fragment attached to [MainActivity]
 *
 * From documentation https://developer.android.com/training/dependency-injection/hilt-testing:
 *
 * [launchFragmentInContainer] from the androidx.fragment:fragment-testing library
 * is NOT possible to use right now as it uses a hardcoded Activity under the hood
 * (i.e. EmptyFragmentActivity) which is not annotated with @AndroidEntryPoint.
 * As a workaround, use this function that is equivalent.
 */
inline fun <reified T : Fragment> launchFragmentInHiltContainer(
    fragmentArgs: Bundle? = null,
    @StyleRes themeResId: Int = R.style.LetuTheme
): ActivityScenario<MainActivity>? {
    val startActivityIntent = Intent.makeMainActivity(
        ComponentName(
            ApplicationProvider.getApplicationContext(),
            MainActivity::class.java
        )
    ).putExtra(
        "androidx.fragment.app.testing.FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY",
        themeResId
    )

    val scenario = ActivityScenario.launch<MainActivity>(startActivityIntent)

    scenario.onActivity { activity ->
        val fragment: Fragment = activity.supportFragmentManager.fragmentFactory.instantiate(
            Preconditions.checkNotNull(T::class.java.classLoader),
            T::class.java.name
        )
        fragment.arguments = fragmentArgs
        activity.supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_content, fragment, "")
            .commitNow()
    }

    return scenario
}

/**
 * Allows application to access device location, when android asks user for permissions
 */
fun accessLocationPermissions() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            "pm grant " + ApplicationProvider.getApplicationContext<Context>().packageName +
                " android.permission.ACCESS_FINE_LOCATION"
        )
        InstrumentationRegistry.getInstrumentation().uiAutomation.executeShellCommand(
            (
                "pm grant " + ApplicationProvider.getApplicationContext<Context>().packageName +
                    " android.permission.ACCESS_COARSE_LOCATION"
                )
        )
    }
}
