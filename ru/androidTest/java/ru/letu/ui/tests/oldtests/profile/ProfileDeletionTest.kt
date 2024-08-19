package ru.letu.ui.tests.oldtests.profile

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.runner.RunWith
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.helpers.TestUtils.sleep
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchActivity
import ru.letu.ui.screens.MenuScreen
import ru.letu.ui.screens.Navigation
import ru.letu.ui.screens.ProfileScreen
import ru.letu.ui.screens.SimplifiedAuthorizationScreen

@RunWith(AndroidJUnit4::class)
class ProfileDeletionTest : AllureTestCase() {
    private val requestNewCodeTimeout = 2 * 60 * 1_000

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    fun test_deleteButton_isVisible() {
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                agreeQuestionIsThisYourCity()
                openBottomMenu()
            }
            MenuScreen {
                openAuthorizationScreen()
            }
            SimplifiedAuthorizationScreen {
                emailTitle.click()
                enterEmail("cord@mail.ru")
                continueAuthClick()
                enterPassword("123456789")
                closeSoftKeyboard()
                continueAuthClick()
            }
        }.after {
            mActivityTestRule.finishActivity()
        }.run {
            step("1-Переходим на экран профиля") {
                MenuScreen {
                    openProfile()
                }
                ProfileScreen {
                    openPersonalDataInfo()
                }
            }
            step("2-Проверям видимость кнопки удаления аккаунта") {
                ProfileScreen.checkDeleteButtonIsVisible()
            }
        }
    }

    fun test_receiveNewCode_isDisabled() {
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {

                agreeQuestionIsThisYourCity()
                openBottomMenu()
            }
            MenuScreen {
                openAuthorizationScreen()
            }
            SimplifiedAuthorizationScreen {
                emailTitle.click()
                enterEmail("cord@mail.ru")
                continueAuthClick()
                enterPassword("123456789")
                closeSoftKeyboard()
                continueAuthClick()
            }
        }.after {
            mActivityTestRule.finishActivity()
        }.run {
            step("1-Переходим на экран профиля") {
                MenuScreen {
                    openProfile()
                }
                ProfileScreen {
                    openPersonalDataInfo()
                }
            }
            step("2-Переходим на экран удаления аккаунта") {
                ProfileScreen.openAccountDeletionScreen()
            }
            step("3-Проверяем, что кнопка удаления аккаунта недоступна для нажатия") {
                ProfileScreen {
                    checkReceiveNewCodeButtonsIsDisabled()
                    closeSoftKeyboard()
                }
            }
        }
    }

    fun test_waitReceiveNewCodeAndPressAgain() {
        before {
            launchActivity()
            accessLocationPermissions()
            Navigation {
                agreeQuestionIsThisYourCity()
                openBottomMenu()
            }
            MenuScreen {
                openAuthorizationScreen()
            }
            SimplifiedAuthorizationScreen {
                emailTitle.click()
                enterEmail("cord@mail.ru")
                continueAuthClick()
                enterPassword("123456789")
                closeSoftKeyboard()
                continueAuthClick()
            }
        }.after {
            mActivityTestRule.finishActivity()
        }.run {
            step("1-Переходим на экран профиля") {
                MenuScreen {
                    openProfile()
                }
                ProfileScreen {
                    openPersonalDataInfo()
                }
            }
            step("2-Переходим на экран удаления аккаунта") {
                ProfileScreen.openAccountDeletionScreen()
            }
            step("3-Проверяем, что кнопка удаления аккаунта недоступна для нажатия") {
                ProfileScreen.checkReceiveNewCodeButtonsIsDisabled()
            }
            step("4-Ожидаем паузу перед новым запросом") {
                sleep(requestNewCodeTimeout)
                ProfileScreen.closeSoftKeyboard()
            }
            step("5-Нажимаем на \"Получить новый код\"") {
                ProfileScreen.clickOnReceiveNewCode()
            }
            step("6-Проверяем, что кнопка удаления аккаунта недоступна для нажатия") {
                ProfileScreen {
                    checkDeleteButtonIsDisabled()
                    closeSoftKeyboard()
                }
            }
        }
    }
}
