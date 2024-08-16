import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import oasis.letu.helper.accessLocationPermissions
import oasis.letu.screens.HomeScreen
import org.junit.Rule
import org.junit.Test
import ru.letu.ui.base.MainActivity

class SwipeMainBannerTest : TestCase() {
    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun myTest() = run {

        before {
            accessLocationPermissions()
        }.after {
        }.run {

            step("Check Banner") {
                Thread.sleep(5000)
                HomeScreen {
                    expandButton {
                        isVisible()
                        click()
                    }

//                    mainBannerVP {
// //                        isVisible()
// //                        scrollRight()
// //                        scrollLeft()
// //                        scrollToFirst()
//                        scrollToLast()
//                    }
                }
            }
            step("свайп") {
                HomeScreen {
                    Thread.sleep(4000)
                }
            }
        }
    }
//            step("click"){
//                HomeScreen {
//                    expandButton {
//                        click()
//                    }
//                }
//            }
//            step("Swipe banner") {
//                HomeScreen {
//                    recyclerView {
//                        firstChild<HomeScreen.BannerCartridge> {
//                            bannerVP.scrollRight()
//                            bannerVP.scrollRight()
//                            bannerVP.scrollRight()
//                            bannerView.isDisplayed()
//                        }
//                    }
//                }
//            }
}
