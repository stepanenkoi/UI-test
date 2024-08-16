package oasis.letu.tests.catalogTests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import oasis.letu.helper.accessLocationPermissions
import oasis.letu.screens.сatalogScreens.CatalogScreen
import oasis.letu.screens.navigation.BottomNavigation
import org.junit.Rule
import org.junit.Test
import ru.letu.navigation.core.routing.featureRouter
import ru.letu.routes.MainFlowRoute
import ru.letu.ui.base.MainActivity

class CatalogScreenElementsTest : TestCase() {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun myTest() = run {

        before {
            featureRouter newRoot MainFlowRoute()
            accessLocationPermissions()
            Thread.sleep(3000)
            BottomNavigation.openCatalog()
        }.after {
        }.run {
            step("Проверка элементов на экране") {
                CatalogScreen {
                    checkImage()
                    checkName1()
                }
            }
        }
    }
}
