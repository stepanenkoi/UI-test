package oasis.letu.tests.menuTests.searchCityTests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import oasis.letu.helper.accessLocationPermissions
import oasis.letu.screens.menuScreens.MenuScreen
import oasis.letu.screens.menuScreens.SearchCityScreen
import oasis.letu.screens.navigation.BottomNavigation
import org.junit.Rule
import org.junit.Test
import ru.letu.navigation.core.routing.featureRouter
import ru.letu.routes.MainFlowRoute
import ru.letu.ui.base.MainActivity

class CheckSearchCityScreenTest : TestCase() {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun myTest() = run {
        step("Open Auth screen") {
            before {
                featureRouter newRoot MainFlowRoute()
                accessLocationPermissions()
            }.after {
            }.run {
                step("Открыть меню") {
                    Thread.sleep(4000)
                    BottomNavigation {
                        openBottomMenu()
                    }
                }
                step("Открыть экран выбора города") {
                    MenuScreen {
                        flakySafely(timeoutMs = 3000) {
                            CityText {
                                isVisible()
                                click()
                            }
                        }
                    }
                }
            }
            step("проверка элементов на экране") {
                SearchCityScreen {
                    flakySafely(timeoutMs = 3000) {
                        SelectCityText {
                            isVisible()
                        }
                    }
                    checkCity()
                }
            }
        }
    }
}
