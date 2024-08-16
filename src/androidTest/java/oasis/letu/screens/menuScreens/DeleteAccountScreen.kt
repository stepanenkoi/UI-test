package oasis.letu.screens.menuScreens

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.kotlin.Allure
import ru.letu.R
import ru.letu.ui.base.MainActivity

object DeleteAccountScreen : KScreen<DeleteAccountScreen>() {
    override val layoutId: Int
        get() = R.layout.fragment_delete_user

    override
    val viewClass: Class<*>
        get() = MainActivity::class.java

    val title = KTextView {
        withId(R.id.title)
        withText(ru.letu.core_resources.R.string.app_delete_account)
    }
    val description = KTextView {
        withId(R.id.description)
        withText(ru.letu.core_resources.R.string.app_delete_account_description)
    }
    val buttonDelete = KButton {
        withId(R.id.btnDelete)
        withText(ru.letu.core_resources.R.string.app_delete_account)
    }
    val buttonCancel = KButton {
        withId(R.id.btnCancel)
        withText(ru.letu.core_resources.R.string.app_cancel)
    }

    fun checkTitle() {
        Allure.step("Проверка отображения заголовка") {
            title.isDisplayed()
        }
    }
    fun checkDescription() {
        Allure.step("Проверка отображения описания") {
            description.isDisplayed()
        }
    }
    fun checkDelete() {
        Allure.step("Проверка отображения кнопки Delete") {
            buttonDelete.isDisplayed()
        }
    }

    fun clickDelete() {
        Allure.step("Нажать Delete") {
            buttonDelete.click()
        }
    }
    fun checkCancel() {
        Allure.step("Проверка отображения кнопки Cancel") {
            buttonCancel.isDisplayed()
        }
    }

    fun clickCancel() {
        Allure.step("Нажать Cancel") {
            buttonCancel.click()
        }
    }
}
