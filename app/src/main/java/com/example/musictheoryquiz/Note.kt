package com.example.musictheoryquiz

import android.graphics.Bitmap

data class Note (var icon_Bitmap : Bitmap, var coord_Top_division_value: Float, var id_note : Int, var hasMinus : Boolean, var icon_sharp_flat : Bitmap?) {
}