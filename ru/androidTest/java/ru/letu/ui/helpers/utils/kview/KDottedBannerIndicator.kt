package ru.letu.ui.helpers.utils.kview

import android.view.View
import androidx.test.espresso.DataInteraction
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.common.views.KBaseView
import org.hamcrest.Matcher
import ru.letu.ui.components.indicator.DottedBannerIndicator

/**
 * Created by Vladislav Kochetov on 18.03.2022.
 */
class KDottedBannerIndicator : KBaseView<DottedBannerIndicator> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(parent: Matcher<View>, function: ViewBuilder.() -> Unit) : super(parent, function)
    constructor(parent: DataInteraction, function: ViewBuilder.() -> Unit) : super(parent, function)
}
