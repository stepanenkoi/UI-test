package ru.letu.ui.base

import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue
import io.qameta.allure.kotlin.Allure.step
import ru.letoile.android.remoteconfig.api.Feature
import ru.letoile.android.remoteconfig.api.FeatureManager

object FeatureUiToggles : FeatureManager {
    private val firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
    private fun Map<String, FirebaseRemoteConfigValue>.keyList(): List<String> = keys.toList()

    private fun getMapFeatureToggle(): HashMap<String, Boolean> {
        val feature = HashMap<String, Boolean>()
        firebaseRemoteConfig.all.keyList().forEach {
            feature[it] = firebaseRemoteConfig.getBoolean(it)
        }
        return feature
    }

    private val mapFeatureToggle = getMapFeatureToggle()

    override suspend fun isEnabled(feature: Feature): Boolean {
        return if (mapFeatureToggle.containsKey(feature.key)) {
            mapFeatureToggle.getValue(feature.key)
        } else {
            feature.defaultValue
        }
    }

    override suspend fun isEnabled(featureKey: String): Boolean {
        return if (mapFeatureToggle.containsKey(featureKey)) {
            mapFeatureToggle.getValue(featureKey)
        } else {
            false
        }
    }

    fun enable(key: String) {
        step("Включаем тоггл $key") {
            mapFeatureToggle[key] = true
        }
    }

    fun disable(key: String) {
        step("Выключаем тоггл $key") {
            mapFeatureToggle[key] = false
        }
    }
}
