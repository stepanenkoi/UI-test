package ru.letu.ui.screens

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.Visibility
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import org.hamcrest.Matcher
import ru.letoile.android.navigation.routing.featureRouter
import ru.letu.R
import ru.letu.ui.base.DefaultTest.Companion.LONG_WAIT_TIME
import ru.letu.ui.helpers.TestUtils
import ru.letu.ui.helpers.TestUtils.first
import ru.letu.ui.helpers.TestUtils.getText
import ru.letu.ui.helpers.TestUtils.withIndex
import ru.letu.ui.helpers.clickOnRecyclerViewAtPosition
import ru.letu.ui.helpers.clickOnRecyclerViewByItemPositionAndViewId
import ru.letu.ui.helpers.utils.CustomViewActions.waitForDisplayed
import ru.letu.ui.helpers.withPositionOnView
import ru.letu.ui.screens.bottomsheet.SortPlpBottomSheetScreen
import ru.letu.feature.plp.R as RPlp

object PLPScreen : Screen<PLPScreen>() {
    val catalogInfo = KEditText { withId(R.id.catalog) }
    val brandNamePlp = KTextView { withId(R.id.brand_name) }
    val containerPlp = KView { withId(R.id.container) }
    val sortOrderButtonPlp = KView { withId(RPlp.id.sortOrderButton) }
    val filterButtonPlp = KView { withId(RPlp.id.filterButton) }

    private val filtersList = KRecyclerView(
        builder = {
            withId(RPlp.id.filtersList)
        },
        itemTypeBuilder = {
            itemType(BrandScreen::FeaturedBrandsItem)
        }
    )

    class FiltersListItem(parent: Matcher<View>) : KRecyclerItem<FiltersListItem>(parent) {
        val title = KView(parent) { withId(R.id.title) }
    }

    fun selectProductWithName(productName: String) {
        catalogInfo {
            isVisible()
            isFocusable()
        }
        val targetProductView = KView { withText(productName) }
        targetProductView {
            click()
        }
    }

    fun selectProduct(productName: String) {
        val productView = onView(first(withText(productName)))
        productView.perform(click())
    }

    fun selectProductByIndex(index: Int) {
        catalogInfo {
            isVisible()
            isFocusable()
        }
        onView(withId(R.id.catalog))
            .perform(clickOnRecyclerViewByItemPositionAndViewId(index, R.id.product_card))
    }

    fun checkIfStartQuizButtonVisible() {
        // Проверяем, что картридж с квизом отображаается
        onView(withId(R.id.quiz_container)).check(matches(isDisplayed()))
        // Проверяем, что кнопка начала квиза отображается
        onView(withId(R.id.btn_help_choosing_scent)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    fun startQuizAndCheckRunningQuiz() {
        // Запускаем квиз
        onView(withId(R.id.btn_help_choosing_scent)).perform(click())
        checkIfQuizRunning()
    }

    fun selectAnswerOnQuiz(position: Int) {
        onView(withId(R.id.recycler_quiz))
            .perform(clickOnRecyclerViewAtPosition(position))
    }

    fun checkIsImageShowed() {
        checkImageAnswerVisibility(Visibility.VISIBLE)
    }

    fun checkIsImageNotShowed() {
        checkImageAnswerVisibility(Visibility.GONE)
    }

    private fun checkImageAnswerVisibility(visibility: Visibility) {
        onView(withPositionOnView(R.id.recycler_quiz, 0, R.id.image_answer))
            .check(matches(withEffectiveVisibility(visibility)))
    }

    fun clickToQuizBackButton() {
        // Нажимаем на кнопку назад
        onView(withId(R.id.btn_prev))
            .perform(scrollTo())
            .perform(click())
    }

    fun clickToQuizNextButton() {
        // Нажимаем на кнопку далее
        onView(withId(R.id.catalog))
            .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, scrollTo()))

        onView(withId(R.id.btn_next))
            .perform(click())
    }

    fun checkErrorShowed() {
        onView(withId(R.id.error_answer_not_selected)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    fun checkIfQuizNotRunning() {
        // Проверяем, что отображается контейнер с ответами, а все остальное - скрыто
        onView(withId(R.id.started_quiz_container)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.btn_help_choosing_scent)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.quiz_finished_container)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    fun checkIfQuizRunning() {
        // Проверяем, что отображается контейнер с ответами, а все остальное - скрыто
        onView(withId(R.id.started_quiz_container)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.btn_help_choosing_scent)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.quiz_finished_container)).check(matches(withEffectiveVisibility(Visibility.GONE)))
    }

    fun checkIfQuizFinished() {
        // Проверяем, что отображается контейнер с ответами, а все остальное - скрыто
        onView(withId(R.id.started_quiz_container)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.btn_help_choosing_scent)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.quiz_finished_container)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    fun openPLPByDeeplink(deeplink: String) {
        step("Plp бренда по диплинку") {
            featureRouter.open(deeplink)
            assertPLPBrandOpen()
        }
    }

    fun clickSortButtonPlp() {
        step("Нажать на кнопку сортировки") {
            sortOrderButtonPlp.click()
            SortPlpBottomSheetScreen.assertSortPlpBottomOpen()
        }
    }

    fun assertPLPBrandOpen() {
        step("Plp бренда открыт") {
            waitForDisplayed(R.id.brand_name, LONG_WAIT_TIME)
            brandNamePlp.isDisplayed()
            containerPlp.isDisplayed()
            sortOrderButtonPlp.isDisplayed()
            filterButtonPlp.isDisplayed()
        }
    }

    fun assertPLPBrandNameOpen(name: Int) {
        step("Plp бренда открыт") {
            brandNamePlp.hasText(name)
        }
    }

    fun assertSortByHigherPrice() {
        step("Проверка сортировки по возрастанию цены") {
            val priceList = mutableListOf<Int>()
            for (index in 0..2) {
                getText(withIndex(withId(RPlp.id.new_text_discount_price), index))?.let {
                    priceList.add(
                        TestUtils.getPrice(it)
                    )
                }
            }
            assert(priceList.asSequence().windowed(2).all { (a, b) -> a <= b })
        }
    }
}
