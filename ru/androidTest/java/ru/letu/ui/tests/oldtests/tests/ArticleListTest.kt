package ru.letu.ui.tests.oldtests.tests

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.blog.presentation.fragment.articlelist.ArticleListFragment
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.helpers.utils.extensions.isNotEmpty
import ru.letu.ui.screens.ArticleListScreen

/**
 * Created by Vladislav Kochetov on 16.11.2021.
 */
@RunWith(AndroidJUnit4::class)
class ArticleListTest : AllureTestCase() {

    fun checkDisplayingArticleList() {
        var scenario: ActivityScenario<MainActivity>? = null
        before {
            scenario = launchFragmentInHiltContainer<ArticleListFragment>()
            accessLocationPermissions()
        }.after {
            scenario?.close()
        }.run {
            step("1-Проверка загрузки страницы") {
                ArticleListScreen { checkPageDisplaying() }
            }
            step("2-Проверка размера списка статей на 1 странице ($TARGET_ARTICLE_LIST_SIZE)") {
                ArticleListScreen {
                    articleList { hasSize(TARGET_ARTICLE_LIST_SIZE) }
                }
            }
            step("3-Проверка полей первого айтема") {
                ArticleListScreen { checkArticleItemFieldsConsistency() }
            }
            step("4-Проверка загрузки второй страницы") {
                ArticleListScreen {
                    articleList {
                        lastChild<ArticleListScreen.LoadingListItem> { isEnabled() }
                    }
                }
            }
        }
    }

    fun filterByLastTag() {
        var scenario: ActivityScenario<MainActivity>? = null
        before {
            scenario = launchFragmentInHiltContainer<ArticleListFragment>()
            accessLocationPermissions()
        }.after {
            scenario?.close()
        }.run {
            step("1-Проверка загрузки тегов") {
                ArticleListScreen {
                    tagList { isNotEmpty() }
                }
            }
            step("2-Фильтрация по первому тегу") {
                ArticleListScreen { clickOnLastTag() }
            }
            step("3-Проверка загрузки") {
                ArticleListScreen {
                    articleList { isNotEmpty() }
                }
            }
            step("4-Проверка загрузки тегов") {
                ArticleListScreen {
                    tagList { isNotEmpty() }
                }
            }
            step("5-Сброс выбранного тега") {
                ArticleListScreen { clickOnLastTag() }
            }
            step("6-Проверка загрузки списка статей") {
                ArticleListScreen {
                    articleList { isNotEmpty() }
                }
            }
        }
    }

    private companion object {
        private const val TARGET_ARTICLE_LIST_SIZE = 12
    }
}
