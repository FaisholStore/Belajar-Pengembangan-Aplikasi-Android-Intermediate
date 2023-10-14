package com.dicoding.ticketingapps.Kelas

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

data class Seat(
    val id: Int,
    var x: Float? = 0F,
    var y: Float? = 0F,
    var name: String,
    var isBooked : Boolean

)
