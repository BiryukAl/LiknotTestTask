package ru.liknot.testtask.data.cache

import android.content.Context

class SharedPreferencesImpl(
    context: Context
) {
    private val sharedPref =
        context.getSharedPreferences(FILE_NAME_SHARED_PREFERENCES, Context.MODE_PRIVATE)

    fun saveId(id: String?) {
        with(sharedPref.edit()) {
            putString(KEY_ID_SHARED_PREFERENCES, id)
            apply()
        }
    }

    fun saveUuId(uuid: String?) {
        with(sharedPref.edit()) {
            putString(KEY_UUID_SHARED_PREFERENCES, uuid)
            apply()
        }
    }

    fun getId(): String? {
        return sharedPref.getString(KEY_ID_SHARED_PREFERENCES, "")
    }

    fun getUuId(): String? {
        return sharedPref.getString(KEY_UUID_SHARED_PREFERENCES, "")

    }

    companion object {
        const val FILE_NAME_SHARED_PREFERENCES = "KEY_ID_REDIRECT_LIKNOT"
        const val KEY_ID_SHARED_PREFERENCES = "ID"
        const val KEY_UUID_SHARED_PREFERENCES = "UUID"

    }
}
