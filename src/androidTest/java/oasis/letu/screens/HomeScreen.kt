package oasis.letu.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager.KViewPager
import io.github.kakaocup.kakao.text.KTextView
import oasis.letu.helper.TestUtils.withIndex
import ru.letu.R
import ru.letu.ui.home.v1.HomeFragment

object HomeScreen : KScreen<HomeScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_home
    override val viewClass: Class<*>
        get() = HomeFragment::class.java

    val mainBannerVP = KViewPager {
        withId(ru.letu.feature.banners.R.id.viewPager)
    }
    val expandButton = KImageView { withId(ru.letu.feature.banners.R.id.expand_button) }
    val logoImage = KImageView { withId(ru.letu.feature.banners.R.id.logo_image) }
    val bannerTitle = KTextView { withId(ru.letu.feature.banners.R.id.banner_title) }
    val bannerDescription = KTextView { withId(ru.letu.feature.banners.R.id.banner_description) }
    val bannerIndicator = KView { withId(ru.letu.feature.banners.R.id.indicator) }

    val advertisingBannerVP = KViewPager {
        withId(ru.letu.feature.banners.R.id.viewPager)
    }
    val AdvImage = KImageView { withId(ru.letu.feature.banners.R.id.image) }
    val AdvText = KTextView { withId(ru.letu.feature.banners.R.id.ad_text) }
    fun swipeAdBanner() {
        onView(withIndex(withId(ru.letu.feature.banners.R.id.viewPager), 0)).perform(ViewActions.swipeLeft())
    }
}
