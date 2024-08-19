package ru.letu.ui.tests.home

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import io.qameta.allure.kotlin.Allure.step
import letu.ru.screen.MainScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity

@RunWith(AndroidJUnit4::class)

class SimpleTest : AllureTestCase() {

    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test

fun tapButton(){

           step("Open target screen") {
               MainScreen {
                   menuButton {
                       isVisible()
                       isClickable()
                       click()
                   }
               }
           }
       }


}