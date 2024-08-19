package ru.letu.ui.screens

import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import com.kaspersky.kaspresso.screens.KScreen
import ru.letu.ui.helpers.checkScreenIsDisplayed

open class LetuKScreen<T : KScreen<T>>(
    @LayoutRes override val layoutId: Int,
    override val viewClass: Class<*>,
    @IdRes val rootId: Int
) : KScreen<T>() {
    fun isDisplayed(): Unit = checkScreenIsDisplayed(rootId)
}
