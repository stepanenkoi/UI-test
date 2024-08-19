package ru.letu.ui.screens

import androidx.test.espresso.web.assertion.WebViewAssertions
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms
import androidx.test.espresso.web.webdriver.Locator
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.CoreMatchers.containsString

object PayInstallmentPlanUiScreen : Screen<PayInstallmentPlanUiScreen>() {

    private const val TEXT_BTN = "Поделить"
    private const val PARTNER_NAME = "Letoile"

    fun assertPayInstallmentPlanOpen() {
        step("Сервис Подели открыт") {
            Thread.sleep(10000)
            onWebView().withElement(DriverAtoms.findElement(Locator.ID, "partnerName"))
                .check(WebViewAssertions.webMatches(DriverAtoms.getText(), containsString(PARTNER_NAME)))

            onWebView().withElement(DriverAtoms.findElement(Locator.ID, "pay-btn"))
                .check(WebViewAssertions.webMatches(DriverAtoms.getText(), containsString(TEXT_BTN)))
        }
    }
}
