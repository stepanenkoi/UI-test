package ru.letu.ui.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager.KViewPager
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.swiperefresh.KSwipeRefreshLayout
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letu.R
import ru.letu.blog.presentation.fragment.articlelist.ArticleListFragment
import ru.letu.ui.helpers.utils.kview.KDottedBannerIndicator
import ru.letu.ui.helpers.utils.kview.KLottieAnimationView
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources

/**
 * Created by Vladislav Kochetov on 18.03.2022.
 */
object ArticleListScreen : KScreen<ArticleListScreen>() {

    val swipeRefresh = KSwipeRefreshLayout { withId(R.id.swipe_refresh) }
    private val banners = KViewPager { withId(R.id.blog_banner_pager) }
    private val dottedBannerIndicator = KDottedBannerIndicator { withId(R.id.banner_indicator) }
    val articleList = KRecyclerView(
        builder = { withId(R.id.article_list_recycler) },
        itemTypeBuilder = {
            itemType(ArticleListScreen::ArticleListItem)
            itemType(ArticleListScreen::LoadingListItem)
        }
    )
    val tagList = KRecyclerView(
        builder = { withId(R.id.blog_tag_list_recycler) },
        itemTypeBuilder = { itemType(ArticleListScreen::TagListItem) }
    )

    override val layoutId: Int
        get() = R.layout.fragment_blog_article_list

    override val viewClass: Class<*>
        get() = ArticleListFragment::class.java

    fun clickOnLastTag() {
        tagList { lastChild<TagListItem> { click() } }
    }

    fun checkPageDisplaying() {
        banners.isDisplayed()
        dottedBannerIndicator.isDisplayed()
        tagList.isDisplayed()
        articleList.isDisplayed()
    }

    fun checkArticleItemFieldsConsistency() {
        articleList {
            firstChild<ArticleListItem> {
                isVisible()
                headline { hasAnyText() }
            }
        }
    }

    /** TagViewHolder */
    class TagListItem(parent: Matcher<View>) : KRecyclerItem<TagListItem>(parent) {
        val title = KTextView(parent) { withId(R.id.blog_article_tag) }
    }

    /** ArticleViewHolder */
    class ArticleListItem(parent: Matcher<View>) : KRecyclerItem<ArticleListItem>(parent) {
        val image = KImageView(parent) { withId(R.id.blog_article_image) }
        val headline = KTextView(parent) { withId(R.id.blog_article_headline) }
    }

    /** LoadingViewHolder */
    class LoadingListItem(parent: Matcher<View>) : KRecyclerItem<LoadingListItem>(parent) {
        val progress = KLottieAnimationView(parent) { withId(R.id.loading_indicator) }
    }

    fun assertArticleListScreenOpen() {
        step("Экран списка статей открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(RCoreResources.string.app_blog)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            banners.isDisplayed()
        }
    }
}
