package ru.letu.ui.helpers.other

import android.app.Instrumentation
import android.view.View
import ru.letu.network.features.test.TestUtils.retrieveAllTestLogs
import androidx.test.espresso.FailureHandler
import androidx.test.espresso.base.DefaultFailureHandler
import org.hamcrest.Matcher
import ru.letoile.android.logger.Logger

class UiTestsHandler(instrumentation: Instrumentation) : FailureHandler {
    private val delegate: FailureHandler

    init {
        delegate = DefaultFailureHandler(instrumentation.targetContext)
    }

    override fun handle(error: Throwable, viewMatcher: Matcher<View>) {
        val allLogs = retrieveAllTestLogs()
        Logger.d(allLogs)

        Logger.e(error)
        delegate.handle(error, viewMatcher)
    }
}
