package com.example.mvvm_template.utils
import java.util.regex.Pattern



object RegexUtils {
    private val EMAIL_ADDRESS: Pattern = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    )
    fun isValidEmail(email: String): Boolean {
        return EMAIL_ADDRESS.matcher(email).matches()
    }


    fun isValidPhoneNumber(
        countryCode: String?,
        phoneNumber: String?
    ): Boolean {
        var phone=phoneNumber
        if (phoneNumber!=null&&phoneNumber.startsWith("0")){
            phone=phone!!.removePrefix("0")
        }
        var isvalidNumber = false
        when (countryCode) {
            "20" -> {
                val regexEg = "^(10|11|12|15)[0-9]{8}$"
                isvalidNumber = Pattern.matches(regexEg, phone)
            }
            "966" -> {
                val regexSau = "^(50|53|54|55|56|57|58|59)\\d{7}"
                isvalidNumber = Pattern.matches(regexSau, phone)
            }
            "964" -> {
                val regexIraq = "^(079|078|077|076|075|074|073)[0-9]{8}$"
                isvalidNumber = Pattern.matches(regexIraq, phone)
            }
        }
        return isvalidNumber
    }

}
