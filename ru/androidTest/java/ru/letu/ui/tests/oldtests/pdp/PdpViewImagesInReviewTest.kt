package ru.letu.ui.tests.oldtests.pdp

import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import org.junit.runner.RunWith
import ru.letoile.android.remoteconfig.api.Feature
import ru.letoile.android.remoteconfig.api.FeatureManager
import ru.letoile.android.remoteconfig.api.FeatureManagerHolder
import ru.letu.BuildConfig
import ru.letu.feature.product.ProductFragment
import ru.letu.feature.product.ProductScreenArguments
import ru.letu.feature.reviews.endeca.cartridge.ui.UIReviewCartridge
import ru.letu.feature.reviews.feature.ReviewFeatures
import ru.letu.ui.base.AllureTestCase
import ru.letu.ui.helpers.launchFragmentInHiltContainer
import ru.letu.ui.screens.PDPScreen
import ru.letu.ui.screens.ReviewGalleryScreen
import ru.letu.ui.screens.SingleReviewDialogScreen
import ru.letu.ui.screens.bottomsheet.SpecifyAddressDialogScreen

@RunWith(AndroidJUnit4::class)
class PdpViewImagesInReviewTest : AllureTestCase() {

    fun test() {

        init {
            FeatureManagerHolder.init(object : FeatureManager {
                override suspend fun isEnabled(featureKey: String): Boolean =
                    featureKey == ReviewFeatures.REVIEW_WATCH_IMAGES_TOGGLE.key

                override suspend fun isEnabled(feature: Feature): Boolean =
                    feature == ReviewFeatures.REVIEW_WATCH_IMAGES_TOGGLE
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
                step("Отображаюстя отзывы") {
                    PDPScreen {
                        recyclerView.childWith<PDPScreen.Review> {
                            reviewWithMediaMatcher()
                        }.checkReviewWithMedia()
                    }
                }
                step("Открывается просмотр фото") {
                    PDPScreen {
                        recyclerView.childWith<PDPScreen.Review> {
                            reviewWithMediaMatcher()
                        }.apply {
                            media.childAt<PDPScreen.Review.Media>(0) {
                                image.click()
                            }
                        }
                    }
                }
                step("Отображается информация об отзыве") {
                    ReviewGalleryScreen {
                        author.isVisible()
                        author.hasText("test")
                    }
                }
                step("Отображается кнопка просмотра отзыва отзыве") {
                    ReviewGalleryScreen {
                        readReview.isVisible()
                    }
                }
                step("Открывается экрана просмотра отзыва") {
                    ReviewGalleryScreen {
                        readReview.click()
                    }
                    SingleReviewDialogScreen {
                        recyclerView.childWith<PDPScreen.Review> {
                            reviewWithMediaMatcher()
                        }.checkReviewWithMedia()
                        pressBack()
                    }
                }
                step("Отображается информация о товаре") {
                    ReviewGalleryScreen {
                        productTitle.isVisible()
                        productTitle.hasText("Idole")
                        productBrand.isVisible()
                        productBrand.hasText("LANCOME")
                        productPrice.isVisible()
                        productPrice.hasText("555\u00a0${BuildConfig.USER_REGION_CURRENCY}")
                        productOldPrice.isVisible()
                        productOldPrice.hasText("777\u00a0₽")
                    }
                }
                step("Отображается кнопка добавить в корзину") {
                    ReviewGalleryScreen {
                        addToCart.isVisible()
                    }
                }
//                Would not work until DefaultProductRepository couldn't load product without external trigger
//                Test rise up this bug because in destroys view models after leaving fragment immediately
//                step("Открывается диалог выбора sku") {
//                    ReviewGalleryScreen {
//                        addToCart.click()
//                    }
//                    SelectSkuDialogScreen {
//                        recyclerView.isVisible()
//                    }
//                }
            }
    }

    private fun ViewBuilder.reviewWithMediaMatcher() {
        withTag(UIReviewCartridge::class)
        withDescendant {
            withText("Ttttesttted")
        }
    }

    private fun PDPScreen.Review.checkReviewWithMedia() {
        reviewText.isVisible()
        reviewText.containsText("Ttttesttted")
        media.isVisible()
        media.childAt<PDPScreen.Review.Media>(0) {
            image.isVisible()
            image.isClickable()
        }
        media.childAt<PDPScreen.Review.Media>(1) {
            image.isVisible()
            image.isClickable()
        }
    }
}
