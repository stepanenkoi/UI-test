package ru.letu.ui.tests.oldtests.ecard

import android.content.Intent
import android.net.Uri
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Ignore
import org.junit.Rule
import org.junit.runner.RunWith
import ru.letu.ui.R
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.screens.ECardCartScreen
import ru.letu.ui.screens.ECardFormScreen
import ru.letu.core_resources.R as RCoreResources

@Ignore("Use for debugging. Occasional system prompt on web links can ruin your day")
@RunWith(AndroidJUnit4::class)
class ECardDeepLinkTest : AllureTestCase() {

    private val testEmail: String = "letutest@alkor.co.ru"
    private val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.letu.ru/ecards"))

    @get:Rule
    val rule = ActivityScenarioRule<MainActivity>(intent)

    fun addECardOpensFromDeepLink() {
        var scenario: ActivityScenario<MainActivity>? = null
        before {
            scenario = rule.scenario
            accessLocationPermissions()
        }
            .after {
                scenario?.close()
            }
            .run {
                step("На экране отображается белый тулбар с стрелкой назад") {
                    ECardFormScreen {
                        toolbar.isVisible()
                        toolbar.hasHomeAsUpIndicatorDrawable(R.drawable.ic_black_arrow_back)
                    }
                }
                step("Нажимаем кнопку сохранить в корзину, получая ошибку для обязательных полей") {
                    runBlocking { delay(4_000) }

                    ECardFormScreen {
                        saveButton { button.click() }
                        phoneInput {
                            isVisible()
                            input.isFocused()
                            inputLayout.hasError(RCoreResources.string.core_ui_error_required_empty)
                        }
                        emailInput {
                            isVisible()
                            inputLayout.hasError(RCoreResources.string.core_ui_error_required_empty)
                        }
                    }
                }
                step("Вводим обязательные поля для форм") {
                    ECardFormScreen {
                        phoneInput {
                            isVisible()
                            input.replaceText("9149999999")
                        }
                        emailInput {
                            isVisible()
                            input.replaceText(testEmail)
                        }
                    }
                }
                step("Нажимаем кнопку сохранить в корзину") {
                    runBlocking { delay(300) }

                    ECardFormScreen { saveButton { button.click() } }
                }
                step("В корзине отображается добавленный сертификат") {
                    ECardCartScreen {
                        title {
                            isVisible()
                            text.hasText("Ваш заказ")
                        }
                        certificatesTitle {
                            isVisible()
                            text.hasText("Сертификаты 1")
                        }
                        keyValue(position = 5) {
                            key.hasText(RCoreResources.string.gift_certificate_cart_email_title)
                            value.hasText(testEmail)
                        }
                        keyValue(position = 6) {
                            key.hasText(RCoreResources.string.gift_certificate_cart_phone_title)
                            value.hasText("+7 (914) 999-99-99")
                        }
                    }
                }
            }
    }
}
