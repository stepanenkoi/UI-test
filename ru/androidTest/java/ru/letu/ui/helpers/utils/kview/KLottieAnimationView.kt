package ru.letu.ui.helpers.utils.kview

import android.view.View
import androidx.test.espresso.DataInteraction
import com.airbnb.lottie.LottieAnimationView
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.common.views.KBaseView
import org.hamcrest.Matcher

/**
 * Created by Vladislav Kochetov on 24.11.2021.
 */
class KLottieAnimationView : KBaseView<LottieAnimationView> {
    constructor(function: ViewBuilder.() -> Unit) : super(function)
    constructor(parent: Matcher<View>, function: ViewBuilder.() -> Unit) : super(parent, function)
    constructor(parent: DataInteraction, function: ViewBuilder.() -> Unit) : super(parent, function)
}
