package ru.letu.ui.screens

import androidx.test.espresso.web.assertion.WebViewAssertions.webMatches
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms
import androidx.test.espresso.web.webdriver.DriverAtoms.findElement
import androidx.test.espresso.web.webdriver.DriverAtoms.getText
import androidx.test.espresso.web.webdriver.DriverAtoms.webClick
import androidx.test.espresso.web.webdriver.Locator
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.CoreMatchers.containsString
import ru.letu.ui.screens.bottomsheet.AppReviewQuestionBottomSheetScreen

object PayCardUiScreen : Screen<PayCardUiScreen>() {

    fun cardNumberSetText(number: String) {
        onWebView().withElement(findElement(Locator.ID, "pan_sub")).perform(DriverAtoms.webKeys(number))
    }

    fun cardMonthSetText(month: String) {
        onWebView().withElement(findElement(Locator.ID, "monthRaw")).perform(DriverAtoms.webKeys(month))
    }

    fun cardYearSetText(year: String) {
        onWebView().withElement(findElement(Locator.ID, "monthYear")).perform(DriverAtoms.webKeys(year))
    }

    fun cardCvcSetText(cvc: String) {
        onWebView().withElement(findElement(Locator.ID, "cvc")).perform(DriverAtoms.webKeys(cvc))
    }

    fun cardCvcBindingSetText(cvc: String) {
        step("Ввести cvc $cvc в поле карты") {
            onWebView().withElement(findElement(Locator.ID, "cvc_binding")).perform(DriverAtoms.webKeys(cvc))
        }
    }

    fun clickCardPaymentBtn() {
        step("Нажать н кнопку Оплатить") {
            onWebView().withElement(findElement(Locator.ID, "paymentWithBinding")).perform(webClick())
        }
    }

    fun cardPasswordSetText(password: String) {
        step("Ввести пароль $password") {
            onWebView().withElement(findElement(Locator.ID, "password")).perform(DriverAtoms.webKeys(password))
            AppReviewQuestionBottomSheetScreen.assertAppReviewQuestionBottomSheetOpen()
        }
    }

    fun assertCvcBindingEntered(cvc: String) {
        step("Код Сvc $cvc введен") {
            onWebView().withElement(findElement(Locator.ID, "cvc_binding"))
                .check(webMatches(getText(), containsString(cvc)))
        }
    }
}
