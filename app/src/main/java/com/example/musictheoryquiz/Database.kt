package com.example.musictheoryquiz

import android.graphics.BitmapFactory

class Database{


    val keys : IntArray = intArrayOf(
        R.drawable.music_a,
        R.drawable.music_a_flat,
        R.drawable.music_b_flat,
        R.drawable.music_c,
        R.drawable.music_c_flat,
        R.drawable.music_d,
        R.drawable.music_d_flat,
        R.drawable.music_e,
        R.drawable.music_e_flat,
        R.drawable.music_f,
        R.drawable.music_g,
        R.drawable.music_g_flat,
        R.drawable.music_b,
        R.drawable.music_c_sharp,
        R.drawable.music_f_sharp,
        R.drawable.music_f_flat
    )

    val answers : Array<String> = arrayOf("A","Ab","Bb","C","Cb","D","Db","E","Eb","F","G","Gb","B","C#","F#","Fb")
    val answersMinor : Array<String> = arrayOf("F# minor", "F minor","G minor","A minor","Ab minor","B minor","Bb minor","C# minor", "C minor", "D minor","E minor", "Eb minor")


}