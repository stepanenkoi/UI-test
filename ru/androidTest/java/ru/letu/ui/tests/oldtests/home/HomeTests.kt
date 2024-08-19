package ru.letu.ui.tests.oldtests.home

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.runner.RunWith
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchActivity
import ru.letu.ui.screens.HomeScreen
import ru.letu.ui.screens.Navigation

@RunWith(AndroidJUnit4::class)
class HomeTests : AllureTestCase() {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    fun checkBanner() {
        init {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                skipOnboarding()
                agreeQuestionIsThisYourCity()
            }
        }.run {
            step("1.Виден баннер на главном экране") {
                HomeScreen {
                    recyclerView {
                        firstChild<HomeScreen.BannerCartridge> {
                            HomeScreen.isDisplayed()
                            bannerView.isDisplayed()
                        }
                    }
                }
            }
            step("2.Скроллим на 3 баннера вперед") {
                HomeScreen {
                    recyclerView {
                        firstChild<HomeScreen.BannerCartridge> {
                            bannerVP.scrollRight()
                            bannerVP.scrollRight()
                            bannerVP.scrollRight()
                            bannerView.isDisplayed()
                        }
                    }
                }
            }
            step("3. Открываем 4ый баннер") {
                HomeScreen {
                    recyclerView {
                        firstChild<HomeScreen.BannerCartridge> {
                            bannerVP.click()
                        }
                    }
                }
            }
        }
    }
}
