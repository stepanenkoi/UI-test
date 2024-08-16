package oasis.letu.tests.personalDataTests

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.qameta.allure.kotlin.AllureId
import io.qameta.allure.kotlin.Step
import oasis.letu.base.DefaultTest
import oasis.letu.scenarios.RegistrationScenario
import oasis.letu.screens.menuScreens.PersonalDataScreen
import org.junit.Test

class PersonalDataScreenElementsTest :
    DefaultTest(
        "UAE.Mobile. Android. Меню. Профиль. Личные данные. Проверка отображения страницы " +
        "после регистрации"
    ) {
    @Test
    @AllureId("63715")
    @Step("UAE.Mobile. Android. Меню. Профиль. Личные данные. Проверка отображения страницы после регистрации")
    fun authTest_63715() {
        test()
    }

    override val runSteps: TestContext<Unit>.() -> Unit = {
        step("Mobile.Android.Auth.Авторизация.Телефон. Авторизация юзера с  UAE телефоном") {
            scenario(RegistrationScenario())
            PersonalDataScreen {
                checkFillAllFieldsText()
                checkFirstNameField()
                checkEmptyFirstNameField()
                checkLastNameField()
                checkEmptyLastNameField()
                checkDateField()
                checkEmptyDateField()
                checkGenderTitle()
                checkMaleGender()
                checkFemaleGender()
                checkAccountTitle()
                checkLocalAccount()
                checkResidentAccount()
                checkTouristAccount()
                checkContactsTitle()
                checkPhoneField()
                scrollToEnd()
                checkEmailField()
                checkEmptyEmailField()
                checkSMSToggle()
                checkEmailToggle()
                checkSaveButton()
                checkPolicyText()
                checkDeleteButton()
                checkChangeLanguage()
            }
        }
    }
}
