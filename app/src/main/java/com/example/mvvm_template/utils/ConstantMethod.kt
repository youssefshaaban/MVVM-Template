package com.example.mvvm_template.utils
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue

object ConstantMethod {


    fun pxToDp(px: Int): Int {
        return (px / Resources.getSystem().displayMetrics.density).toInt()
    }

    fun dbToPx(dp: Int): Float {
        val px = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(), Resources.getSystem().displayMetrics
        )
        return px
    }

    fun getGradiantDrawableBorder(color: String?, round: Int): Drawable {
        val gd = GradientDrawable()
        gd.setStroke(2, Color.parseColor(color))
        gd.cornerRadii = floatArrayOf(
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round)
        )
        return gd
    }

    fun getGradiantDrawableSolid(color: String?, round: Int): Drawable {
        val gd = GradientDrawable()
        gd.setColor(Color.parseColor(color))
        gd.cornerRadii = floatArrayOf(
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round),
            dbToPx(round)
        )
        return gd
    }

    fun formatNumber(phone: String): String {
        return if (phone.startsWith("0")) {
            phone.removePrefix("0")
        } else {
            phone
        }
    }
}