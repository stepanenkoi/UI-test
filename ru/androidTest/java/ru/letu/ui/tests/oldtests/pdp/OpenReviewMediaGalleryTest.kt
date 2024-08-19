package ru.letu.ui.tests.oldtests.pdp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import ru.letu.feature.product.ProductFragment
import ru.letu.feature.product.ProductScreenArguments
import ru.letu.feature.reviews.endeca.cartridge.ui.UIPdpReviewsGalleryCartridge
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.ReviewGalleryScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

@RunWith(AndroidJUnit4::class)
class OpenReviewMediaGalleryTest : AllureTestCase() {

    fun test() {

        init {
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
                step("Скролл к галлереи и просмотр фото") {
                    PDPScreen {
                        recyclerView.childWith<PDPScreen.ReviewGallery> {
                            withTag(UIPdpReviewsGalleryCartridge::class)
                        }.run {
                            media.childAt<PDPScreen.ReviewGallery.Media>(0) {
                                image.click()
                            }
                        }
                    }
                }
                step("Отображается информация об отзыве") {
                    ReviewGalleryScreen {
                        author.isVisible()
                    }
                }
                step("Отображается кнопка просмотра отзыва отзыве") {
                    ReviewGalleryScreen {
                        readReview.isVisible()
                    }
                }
                step("Отображается кнопка добавить в корзину") {
                    ReviewGalleryScreen {
                        addToCart.isVisible()
                    }
                }
            }
    }
}
