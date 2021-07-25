package com.example.mvvm_template

import android.content.Context
import android.provider.Settings


const val SPLASH_DELAY = 3000
const val BASE_URL = "http://85.93.91.32:5020/"

fun getDeviceId(context: Context): String? {
    return Settings.Secure.getString(
        context.contentResolver,
        Settings.Secure.ANDROID_ID
    )



}
