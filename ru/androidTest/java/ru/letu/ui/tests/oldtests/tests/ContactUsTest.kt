package ru.letu.ui.tests.oldtests.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.R
import ru.letu.contactUs.ContactUsFragment
import ru.letu.contactUs.cartridges.uiCartridges.UIChatBotCartridge
import ru.letu.contactUs.cartridges.uiCartridges.UIPhoneCartridge
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.ContactUsScreen

@RunWith(AndroidJUnit4::class)
class ContactUsTest : AllureTestCase() {

    fun contactUsScreen() {
        ContactUsScreen {
            init {
                launchFragmentInHiltContainer<ContactUsFragment>()
            }
                .run {
                    step("1. Отображается белый тулбар") {
                        toolbar.isVisible()
                        toolbar.hasBackgroundColor(R.color.background)
                    }
                    step("2. Отображаются ссылки на чат-ботов") {
                        recyclerView {
                            childWith<ContactUsScreen.ChatBot> {
                                withTag(UIChatBotCartridge::class)
                                withText("Написать в Telegram")
                            }.apply {
                                textView.isCompletelyDisplayed()
                            }
                            childWith<ContactUsScreen.ChatBot> {
                                withTag(UIChatBotCartridge::class)
                                withText("Написать в Viber")
                            }.apply {
                                textView.isCompletelyDisplayed()
                            }
                            childWith<ContactUsScreen.ChatBot> {
                                withTag(UIChatBotCartridge::class)
                                withText("Написать в WhatsApp")
                            }.apply {
                                textView.isCompletelyDisplayed()
                            }
                        }
                    }
                    step("3. Отображаются номера телефонов") {
                        recyclerView {
                            childWith<ContactUsScreen.PhoneNumber> {
                                withTag(UIPhoneCartridge::class)
                                withDescendant {
                                    withText("*2345")
                                }
                            }.apply {
                                isVisible()
                                textView.isCompletelyDisplayed()
                            }
                            childWith<ContactUsScreen.PhoneNumber> {
                                withTag(UIPhoneCartridge::class)
                                withDescendant {
                                    withText("8-800-200-23-45")
                                }
                            }.apply {
                                isVisible()
                                textView.isCompletelyDisplayed()
                            }
                        }
                    }
                }
        }
    }
}
