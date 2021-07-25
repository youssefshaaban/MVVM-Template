@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.example.mvvm_template.utils
import java.text.SimpleDateFormat
import java.util.*


object DateAndTimeFormateUtil {
     val ISO_FORMATE="yyyy-MM-dd'T'HH:mm'Z'"
    val yyyy_MM_ddFORMATE="yyyy-MM-dd"
    val yyyy_MM_dd_HH_mm_ssFORMATE="yyyy-MM-dd HH:mm:ss"
    val time24="HH:mm:ss"
    val time12="hh:mm a"


    fun formateTimeTo12Hours(input: String?):String?{
        val outputFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
        val inputFormat = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)
        var date: Date? = null
        var str: String? = ""
        try {
            date = inputFormat.parse(input)
            str = outputFormat.format(date)
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
        return str
    }



    fun parseDateFormate(
        dateStr: String?,
        inputFormatStr: String,
        outputFormatStr: String
    ): String? {
        val outputFormat = SimpleDateFormat(outputFormatStr, Locale.ENGLISH)
        val inputFormat = SimpleDateFormat(inputFormatStr, Locale.ENGLISH)
        var date: Date? = null
        var str: String? = null
        return try {
            date = inputFormat.parse(dateStr)
            str = outputFormat.format(date)
            str
        } catch (e: Exception) {
            e.printStackTrace()
            str
        }
    }



    fun getDate(inputStr: String?, inputFormate: String):Date?{
        val time1 = SimpleDateFormat(inputFormate).parse(inputStr)
        return time1
    }






    fun convertToISO(date:Date):String{
        val tz = TimeZone.getTimeZone("UTC")
        val df = SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'") // Quoted "Z" to indicate UTC, no timezone offset
        df.setTimeZone(tz)
        val nowAsISO: String = df.format(date)
        return nowAsISO
    }


}