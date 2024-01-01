package com.example.project

import android.content.Context
import android.content.SharedPreferences

class SessionManagerPer (context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()

    companion object {
        private const val PREF_NAME = "UserSession"
        private const val KEY_USER_ID_PER = "userIdPer"
        private const val KEY_USER_EMAIL_PER = "emailPer"
        private const val KEY_USER_USERNAME_PER = "usernamePer"
    }

    fun saveUserSessionPer(userIdPel: String, userEmailPel: String, usernamePel: String) {
        editor.putString(KEY_USER_ID_PER, userIdPel)
        editor.putString(KEY_USER_EMAIL_PER, userEmailPel)
        editor.putString(KEY_USER_USERNAME_PER, usernamePel)

        editor.apply()
    }

    fun isLoggedInPer(): Boolean {
        return sharedPreferences.contains(KEY_USER_ID_PER)
    }


    fun getUserIdPer(): String? {
        return sharedPreferences.getString(KEY_USER_ID_PER, null)
    }

    fun getUserEmailPer(): String? {
        return sharedPreferences.getString(KEY_USER_EMAIL_PER, null)
    }
    fun getUserNamePer(): String? {
        return sharedPreferences.getString(KEY_USER_USERNAME_PER, null)
    }

    fun clearSessionPer() {
        editor.clear()
        editor.apply()
    }

}