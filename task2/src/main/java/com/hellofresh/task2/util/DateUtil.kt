package com.hellofresh.task2.util

import java.text.SimpleDateFormat
import java.util.*


class DateUtil {
    companion object {
        const val dd_MMM: String = "dd MMM"

        fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
            val formatter = SimpleDateFormat(format, locale)
            return formatter.format(this)
        }

        fun getCurrentDateTime(): Date {
            return Calendar.getInstance().time
        }
    }
}