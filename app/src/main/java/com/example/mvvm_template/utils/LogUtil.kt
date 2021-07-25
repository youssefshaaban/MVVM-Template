package com.example.mvvm_template.utils
import android.util.Log



class LogUtil {

    companion object {
        @JvmStatic
        fun info(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                // do something for a debug build
                Log.i(tag, message)
            }
        }

        @JvmStatic
        fun error(tag: String, message: String?) {
//            if (BuildConfig.DEBUG) {
//                // do something for a debug build
//                if (message != null)
//                    Log.e(tag, message)
//            }
            if (message != null)
                Log.e(tag, message)
        }

        @JvmStatic
        fun debug(tag: String, message: String) {
            if (BuildConfig.DEBUG) {
                // do something for a debug build
                Log.d(tag, message)
            }
        }
    }

}
