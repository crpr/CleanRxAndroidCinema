package com.crpr.androidcinema.data.preferences

import android.content.Context
import android.content.SharedPreferences

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

import java.lang.reflect.Type

/**
 * Created by cribeiro on 07/01/2016.
 */
class AppPreferences(context: Context, private val _gson: Gson, key: String) : PreferencesService {

    override val preferences: SharedPreferences = context.getSharedPreferences(key, Context.MODE_PRIVATE)

    override var isWelcomeWizardDone: Boolean
        get() = preferences.getBoolean("welcome_wizard_done", false)
        set(isDone) = preferences.edit().putBoolean("welcome_wizard_done", isDone).apply()

    private fun putObject(key: String?, `object`: Any?) {
        if (key == null || key == "") {
            throw IllegalArgumentException("Key is empty or null")
        }
        if (`object` == null) {
            preferences.edit().remove(key).apply()
        } else {
            preferences.edit().putString(key, _gson.toJson(`object`)).apply()
        }
    }

    private fun <T> getObject(key: String, a: Class<T>): T? {
        val gson = preferences.getString(key, null)
        if (gson == null) {
            return null
        } else {
            try {
                return _gson.fromJson(gson, a)
            } catch (ex: JsonSyntaxException) {
                throw IllegalArgumentException("Object stored with key "
                        + key + " is instance of other class")
            } catch (ex: NullPointerException) {
                throw IllegalArgumentException("Object stored with key $key is instance of other class")
            }

        }
    }

    fun <T> getObjectByType(key: String, a: Type): T? {
        val gson = preferences.getString(key, null)
        if (gson == null) {
            return null
        } else {
            try {
                return _gson.fromJson<T>(gson, a)
            } catch (ex: JsonSyntaxException) {
                throw IllegalArgumentException("Object stored with key "
                        + key + " is instance of other class")
            } catch (ex: NullPointerException) {
                throw IllegalArgumentException("Object stored with key $key is instance of other class")
            }

        }
    }
}
