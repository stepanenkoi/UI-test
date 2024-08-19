package ru.letu.ui.tests.oldtests.`address-book-location`

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4 import org.junit.runner.RunWith
import ru.letu.feature.addresses.edit.v1.SetCourierAddressFragment
import ru.letu.feature.addresses.routes.SetCourierAddressRoute
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.base.MainActivity
import ru.letu.ui.helpers.accessLocationPermissions
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.ChooseRegionScreen
import ru.letu.ui.screens.SetCourierAddressScreen
import ru.letu.core_resources.R as RCoreResources

@RunWith(AndroidJUnit4::class)
class SetCourierAddressTests : AllureTestCase() {

    private var scenario: ActivityScenario<MainActivity>? = null

    fun changeCityOnSetCourierAddressScreenTest() {
        before {
            val extras = SetCourierAddressFragment.extras(
                SetCourierAddressRoute.TYPE_ADD_ADDRESS,
                null,
                null,
                true,
                ""
            )
            scenario = launchFragmentInHiltContainer<SetCourierAddressFragment>(
                fragmentArgs = extras
            )
            accessLocationPermissions()
        }
            .after {
                scenario?.close()
            }
            .run {
                step("1. Проверяем, что заголовок экрана добавления города верный") {
                    SetCourierAddressScreen {
                        title.isVisible()
                        title.hasText(RCoreResources.string.checkout_courier_add_address_title)
                    }
                }
                step("2. Проверяем, что город предзаполнен значением: Москва (в пределах МКАД)") {
                    SetCourierAddressScreen {
                        city.isVisible()
                        city.hasText("Москва (в пределах МКАД)")
                    }
                }
                step("3. Кликаем на поле города") {
                    SetCourierAddressScreen {
                        city.isClickable()
                        city.click()
                    }
                }
                step("4. Выбираем город Санкт-Петербург") {
                    ChooseRegionScreen {
                        selectCity("Санкт-Петербург")
                    }
                }
                step("5. Проверяем, сменился ли город на экране добавления адреса") {
                    SetCourierAddressScreen {
                        city.isVisible()
                        city.hasText("Санкт-Петербург")
                    }
                }
                step("6. Если поле заполнено, то подсказка не отображается") {
                    SetCourierAddressScreen {
                        cityHint.isGone()
                    }
                }
            }
    }
}
