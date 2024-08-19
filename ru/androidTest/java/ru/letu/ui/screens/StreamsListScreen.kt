package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.screen.Screen
import io.qameta.allure.kotlin.Allure.step
import ru.letu.core_resources.R
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.acquisition.shopstory.R as RShopstory

object StreamsListScreen : Screen<StreamsListScreen>() {

    private val streamCategories = KView { withId(RShopstory.id.recycler_stream_categories) }

    fun assertStreamsListScreenOpen() {
        step("Экран Прямые эфиры открыт") {
            ToolBarElementScreen {
                assertTitleToolBar(R.string.shop_story_streams_title)
                assertSearchBtnToolBar()
                assertBackBtnToolBar()
            }
            streamCategories.isDisplayed()
        }
    }
}
