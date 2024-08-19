package ru.letu.ui.tests.oldtests.search

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.SuggestionResultListScreen
import ru.letu.ui.screens.SuggestionScreen
import ru.letu.ui.suggestions.view.SuggestionsFragment

@RunWith(AndroidJUnit4::class)
class SearchSuggestionTests : AllureTestCase() {

    @Suppress("LongMethod")
    fun searchSmthTest() {

        var scenario: ActivityScenario<MainActivity>? = null
        before {
            scenario = launchFragmentInHiltContainer<SuggestionsFragment>()
        }.after {
            scenario?.close()
        }.run {
            step("1-Открывается экран поиска. Отображается строка поиска c плейсхолдером, кнопка поиска по QR коду.") {
                SuggestionScreen {
                    searchEditTextViewInfo.isVisible()
                    barcodeButton.isVisible()
                }
            }
            step("2-Ввести в строку поиска поисковой запрос, например слово \"п\"") {
                SuggestionScreen {
                    searchEditTextViewInfo.isVisible()
                    searchEditTextViewInfo {
                        replaceText("п")
                    }
                }
            }
            step("3-Плейсхолдер исчезает, как только в строке ввода оказывается хотя бы один символ.") {
                SuggestionScreen { searchEditTextViewInfo.isNotSelected() }
            }
            step("4-Ввести в строку поиска поисковой запрос, например слово \"помада\"") {
                SuggestionScreen {
                    searchEditTextViewInfo.isVisible()
                    searchEditTextViewInfo { replaceText("помада") }
                }
            }
            step("5-На экране отображаются подсказки с быстрыми результатами поиска") {
                SuggestionScreen {
                    searchEditTextViewInfo.isNotSelected()
                    searchEditTextViewInfo.hasText("помада")
                }
                SuggestionResultListScreen {
                    suggestionList {
                        isEnabled()
                        firstChild<SuggestionResultListScreen.SkuItem> {
                            isVisible()
                            title { containsText("помада") }
                        }
                        childAt<SuggestionResultListScreen.SkuItem>(1) {
                            isVisible()
                            title { containsText("помада") }
                        }
                    }
                }
            }
            step("6-Нажать на кнопку \"Найти\"") {
                SuggestionScreen {
                    searchEditTextViewInfo.isVisible()
                    searchEditTextViewInfo {
                        replaceText("тушь")
                        pressImeAction()
                    }
                }
            }
        }
    }

    fun zeroSearchResult() {
        var scenario: ActivityScenario<MainActivity>? = null
        before {
            scenario = launchFragmentInHiltContainer<SuggestionsFragment>()
        }.after {
            scenario?.close()
        }.run {
            step("1-Открывается экран поиска") {
                SuggestionScreen {
                    searchEditTextViewInfo.isVisible()
                    barcodeButton.isVisible()
                }
            }
            step(
                "2-Ввести в строку поиска невалидный поисковой запрос, например фразу \"боевой вертолёт\". " +
                    "Нажать на кнопку \"Найти\""
            ) {
                SuggestionScreen {
                    searchEditTextViewInfo.isVisible()
                    searchEditTextViewInfo {
                        replaceText("боевой вертолёт")
                        pressImeAction()
                    }
                }
            }
        }
    }
}
