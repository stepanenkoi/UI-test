package ru.letu.ui.tests.oldtests.ecard

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.runner.RunWith
import ru.letu.analytics.core.common.pages.PageInfo
import ru.letu.core.endeca.ui.CartridgesFragment
import ru.letu.routes.CertificateRoute
import ru.letu.ui.R
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.ECardCartScreen
import ru.letu.ui.screens.ECardFormScreen
import ru.letu.core_resources.R as RCoreResources

@RunWith(AndroidJUnit4::class)
class ECardAddCertificateToCartTest : AllureTestCase() {

    private val testEmail: String = "letutest@alkor.co.ru"

    fun addCertificateToCartFlow() {
        var scenario: ActivityScenario<MainActivity>? = null
        before {
            scenario = launchFragmentInHiltContainer<CartridgesFragment>(
                CartridgesFragment.extras(
                    url = CertificateRoute.ADD_GIFT_CERT_PATH,
                    pageInfo = PageInfo.GIFT_CERTIFICATE_FORM,
                )
            )
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
