package com.example.quiz

import android.media.Image

data class questions(
    val id:Int,
    val question: String,
    val image: Int,
    val optiona:String,
    val optionb:String,
    val optionc:String,
    val optiond:String,
    val correctoption:Int
)
