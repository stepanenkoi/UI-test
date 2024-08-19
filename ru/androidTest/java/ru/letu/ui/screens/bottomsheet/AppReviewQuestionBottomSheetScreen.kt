package ru.letu.ui.screens.bottomsheet

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure.step
import ru.letu.ui.LetuBottomSheetDialogFragment
import ru.letu.ui.screens.elements.ToolBarElementScreen
import ru.letu.core_resources.R as RCoreResources
import ru.letu.feature.inappreview.R as RInAppReview

object AppReviewQuestionBottomSheetScreen : KScreen<AppReviewQuestionBottomSheetScreen>() {

    override val layoutId: Int = ru.letu.feature.inappreview.R.layout.dialog_app_review_question
    override val viewClass: Class<*> = LetuBottomSheetDialogFragment::class.java

    private val reviewQuestionBottomImg = KImageView { withId(RInAppReview.id.img_review_question) }
    private val reviewQuestionBottomTitle = KTextView {
        withId(RInAppReview.id.review_question_bottom_dialog_title)
        withText(RCoreResources.string.app_in_app_review_question_bottom_dialog_title)
    }
    private val reviewQuestionBottomCancelBtn = KTextView {
        withId(RInAppReview.id.btnCancel)
        withText(RCoreResources.string.app_in_app_review_question_bottom_dialog_btn_no)
    }
    private val reviewQuestionBottomContinueBtn = KTextView {
        withId(RInAppReview.id.btnContinue)
        withText(RCoreResources.string.app_in_app_review_question_bottom_dialog_btn_yes)
    }

    fun clickCancelBtn() {
        step("Нажать Нет в боттом щите Вам нравится наше приложение") {
            reviewQuestionBottomCancelBtn.click()
            ToolBarElementScreen.assertTitleToolBar(RCoreResources.string.order_status_success)
        }
    }

    fun closeAppReviewQuestionBottomSheet() {
        step("Закрыть боттом щит Вам нравится наше приложение аппаратной кнопкой Back") {
            pressBack()
            ToolBarElementScreen.assertTitleToolBarIndex(1, RCoreResources.string.order_status_success)
        }
    }

    fun assertAppReviewQuestionBottomSheetOpen() {
        step("Боттом щит Вам нравится наше приложение открыт") {
            reviewQuestionBottomImg.isDisplayed()
            reviewQuestionBottomTitle.isDisplayed()
            reviewQuestionBottomCancelBtn.isDisplayed()
            reviewQuestionBottomContinueBtn.isDisplayed()
        }
    }
}
