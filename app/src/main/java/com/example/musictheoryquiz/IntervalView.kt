package com.example.musictheoryquiz

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.widget.ImageView
import androidx.core.widget.ImageViewCompat


class IntervalView : androidx.appcompat.widget.AppCompatImageView{


    // pogledati dali trtebam init metodu napraviti

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)




    override fun onDraw(canvas: Canvas) {

        super.onDraw(canvas)
        val imageNesto = findViewById<ImageView>(R.id.intervalImg)
        val imageNotation  = BitmapFactory.decodeResource(resources, R.drawable.notation)
        val imageNote = BitmapFactory.decodeResource(resources, R.drawable.note_up)
      //  var imageNotationDrawable = BitmapDrawable(resources, imageNotation)
        val tempImg : Bitmap = overlay(imageNotation, imageNote)
        var imageNotationDrawable = BitmapDrawable(resources, tempImg)

        var canvasNew = Canvas(tempImg)
        canvasNew.drawBitmap(imageNote, 0f, 0f, null)
        imageNesto.setImageBitmap(imageNote)

       // var result : Bitmap = Bitmap.createBitmap(imageNotation.width, imageNotation.height, Bitmap.Config.ARGB_8888)






    }

    fun overlay(bmp1 : Bitmap, bmp2 : Bitmap) : Bitmap {

        val bmOverlay = Bitmap.createBitmap(bmp1.width, bmp1.height, bmp1.config)
        val canvas = Canvas(bmOverlay)
        var paint = Paint()
        paint.color = Color.BLUE
        canvas.drawBitmap(bmp1, Matrix(), paint)



        canvas.drawBitmap(bmp2, 0f, 0f, paint)
        return bmOverlay
    }







}