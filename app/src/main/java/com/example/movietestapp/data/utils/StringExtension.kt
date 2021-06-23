package com.example.movietestapp.data.utils

import java.text.SimpleDateFormat
import java.util.*

fun String.getFormatDate(): String{
    return try {
        var format = SimpleDateFormat("yyyy-MM-dd")
        val newDate: Date = format.parse(this) ?: Date()

        format = SimpleDateFormat("MMMM dd, yyyy", Locale("ru- RU"))
        format.format(newDate)
    } catch (e: Exception){
        this
    }

}