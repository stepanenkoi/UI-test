package ru.letu.ui.tests.oldtests.pdp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letoile.android.remoteconfig.api.Feature
import ru.letoile.android.remoteconfig.api.FeatureManager
import ru.letoile.android.remoteconfig.api.FeatureManagerHolder
import ru.letu.feature.product.ProductFragment
import ru.letu.feature.product.ProductScreenArguments
import ru.letu.feature.product.feature.PdpFeatures
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

@RunWith(AndroidJUnit4::class)
class PdpSmokeTest : AllureTestCase() {

    fun test() {
        init {
            FeatureManagerHolder.init(object : FeatureManager {
                override suspend fun isEnabled(featureKey: String): Boolean =
                    featureKey == PdpFeatures.PDP_ASSEMBLER.key

                override suspend fun isEnabled(feature: Feature): Boolean =
                    feature == PdpFeatures.PDP_ASSEMBLER
            })
            launchFragmentInHiltContainer<ProductFragment>(
                ProductScreenArguments.args("/product/lancome-idole/77600009", false, "")
            )
        }
            .run {
                step("Закрыть диалог выбора адреса") {
                    PDPScreen {
                        runCatching {
                            SpecifyAddressDialogScreen {
                                negativeButton.click()
                            }
                        }
                    }
                }
                step("Отображается название товара") {
                    PDPScreen {
                        brandNameTitle {
                            isVisible()
                            hasText("LANCOME")
                        }
                        title {
                            isVisible()
                            hasText("Idole")
                        }
                    }
                }
            }
    }
}
