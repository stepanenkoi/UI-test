package ru.letu.ui.screens

import io.github.kakaocup.kakao.common.views.KView
import ru.letu.feature.checkout.R
import ru.letu.feature.checkout.ui.fragment.OptimalPickupFragment

object OptimalPickupScreen : LetuKScreen<OptimalPickupScreen>(
    R.layout.fragment_optimal_pickup,
    OptimalPickupFragment::class.java,
    R.id.point_of_issue_root
) {
    val filterButton = KView { withId(R.id.filter_button) }
}
