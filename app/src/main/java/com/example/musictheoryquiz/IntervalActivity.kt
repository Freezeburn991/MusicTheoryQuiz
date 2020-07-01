package com.example.musictheoryquiz

import android.content.Intent
import android.graphics.*
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class IntervalActivity : AppCompatActivity() {


    var firstNote : Note? = null
    var secondNote : Note? = null
    var number2ScaleNoteRandom : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_interval)

        var b_answer1 : Button = findViewById(R.id.b_answer1)
        var b_answer2 : Button = findViewById(R.id.b_answer2)
        var b_answer3 : Button = findViewById(R.id.b_answer3)
        var b_answer4 : Button = findViewById(R.id.b_answer4)
        var b_answer5 : Button = findViewById(R.id.b_answer5)
        var b_answer6 : Button = findViewById(R.id.b_answer6)
        var b_answer7 : Button = findViewById(R.id.b_answer7)
        var b_answer8 : Button = findViewById(R.id.b_answer8)
        var b_answer9 : Button = findViewById(R.id.b_answer9)
        var b_answer10 : Button = findViewById(R.id.b_answer10)
        var b_answer11 : Button = findViewById(R.id.b_answer11)
        var b_answer12 : Button = findViewById(R.id.b_answer12)



        // Nema smisla razdvajati u Database jer necu to koristiti nigdje drugdje a opet moram loadati sve slike i dictionare
        val imageNoteUp = BitmapFactory.decodeResource(resources, R.drawable.note_up)
        val imageNoteUpMinus = BitmapFactory.decodeResource(resources, R.drawable.note_up_minus)
        val imageNoteDown = BitmapFactory.decodeResource(resources, R.drawable.note_down)
        val imageNoteDownMinus = BitmapFactory.decodeResource(resources, R.drawable.note_down_minus)
        val imageSharpBitmap = BitmapFactory.decodeResource(resources, R.drawable.sharp)
        val imageFlatBitmap = BitmapFactory.decodeResource(resources, R.drawable.flat)
        val imageNoteDownMinusTwo = BitmapFactory.decodeResource(resources, R.drawable.note_down_minus2)


        val noteC = Note(imageNoteUpMinus, 1.90f,  1, true, null)
        val noteD = Note(imageNoteUp, 2.10f, 2,false,null)
        val noteE = Note(imageNoteUp, 2.30f,  3, false, null)
        val noteF = Note(imageNoteUp, 2.65f,  4, false, null)
        val noteG = Note(imageNoteUp, 3.05f, 5, false, null)
        val noteA = Note(imageNoteUp, 3.75f, 6, false, null)
        val noteB = Note(imageNoteUp, 4.50f, 7, false, null)
        val noteC2 = Note(imageNoteDown, 2.55f, 8, false, null)
        val noteD2 = Note(imageNoteDown, 3.00f, 9, false, null)
        val noteE2 = Note(imageNoteDown, 3.55f, 10, false, null)
        val noteF2 = Note(imageNoteDown, 4.20f, 11, false, null)
        val noteG2 = Note(imageNoteDown, 5.10f, 12, false, null)
        val noteA2 = Note(imageNoteDownMinus, 6.00f, 13, true, null)
        val noteB2 = Note(imageNoteDownMinusTwo, 7.00f, 14, true, null)
        val noteCSharp =  Note(imageNoteUpMinus, 1.90f,  15, true, imageSharpBitmap)
        val noteDSharp = Note(imageNoteUp, 2.10f, 16,false,imageSharpBitmap)
        val noteESharp = Note(imageNoteUp, 2.30f,  17, false, imageSharpBitmap)
        val noteFSharp = Note(imageNoteUp, 2.65f,  18, false, imageSharpBitmap)
        val noteGSharp = Note(imageNoteUp, 3.05f, 19, false, imageSharpBitmap)
        val noteASharp = Note(imageNoteUp, 3.75f, 20, false, imageSharpBitmap)
        val noteBSharp = Note(imageNoteUp, 4.50f, 21, false, imageSharpBitmap)
        val noteCSharp2 = Note(imageNoteDown, 2.55f, 22, false, imageSharpBitmap)
        val noteDSharp2 = Note(imageNoteDown, 3.00f, 23, false, imageSharpBitmap)
        val noteESharp2 = Note(imageNoteDown, 3.55f, 24, false, imageSharpBitmap)
        val noteFSharp2 = Note(imageNoteDown, 4.20f, 25, false, imageSharpBitmap)
        val noteGSharp2 = Note(imageNoteDown, 5.10f, 26, false, imageSharpBitmap)
        val noteASharp2 = Note(imageNoteDownMinus, 6.00f, 27, true, imageSharpBitmap)
        val noteBSharp2 = Note(imageNoteDownMinusTwo, 7.00f, 28, true, imageSharpBitmap)
        val noteCFlat = Note(imageNoteUpMinus, 1.90f,  29, true, imageFlatBitmap)
        val noteDFlat = Note(imageNoteUp, 2.10f, 30,false,imageFlatBitmap)
        val noteEFlat = Note(imageNoteUp, 2.30f,  31, false, imageFlatBitmap)
        val noteFFlat = Note(imageNoteUp, 2.65f,  32, false, imageFlatBitmap)
        val noteGFlat = Note(imageNoteUp, 3.05f, 33, false, imageFlatBitmap)
        val noteAFlat = Note(imageNoteUp, 3.75f, 34, false, imageFlatBitmap)
        val noteBFlat = Note(imageNoteUp, 4.50f, 35, false, imageFlatBitmap)
        val noteCFlat2 = Note(imageNoteDown, 2.55f, 36, false, imageFlatBitmap)
        val noteDFlat2 = Note(imageNoteDown, 3.00f, 37, false, imageFlatBitmap)
        val noteEFlat2 = Note(imageNoteDown, 3.55f, 38, false, imageFlatBitmap)
        val noteFFlat2 = Note(imageNoteDown, 4.20f, 39, false, imageFlatBitmap)
        val noteGFlat2 = Note(imageNoteDown, 5.10f, 40, false, imageFlatBitmap)
        val noteAFlat2 = Note(imageNoteDownMinus, 6.00f, 41, true, imageFlatBitmap)
        val noteBFlat2 = Note(imageNoteDownMinusTwo, 7.00f, 42, true, imageFlatBitmap)

        /*val arrayNotes = arrayListOf<Note>()
        arrayNotes.add(1, noteE)*/

        /*
        * 0 is Tonic / Unison
        * 1 is M2
        * 2 is M3
        * 3 is P4
        * 4 is P5
        * 5 is M6
        * 6 is M7
        * 7 is P8
        * 8 is minor2
        * 9 is m3
        * 10 is m6
        * 11 is m7
        * */

        val c_scale = mapOf<Int, Note>(
            0 to noteC,
            1 to noteD,
            2 to noteE,
            3 to noteF,
            4 to noteG,
            5 to noteA,
            6 to noteB,
            7 to noteC2,
            8 to noteDFlat,
            9 to noteEFlat,
            10 to noteAFlat,
            11 to noteBFlat
        )

        val cSharp_scale = mapOf<Int, Note>(
            0 to noteCSharp,
            1 to noteDSharp,
            2 to noteESharp,
            3 to noteFSharp,
            4 to noteGSharp,
            5 to noteASharp,
            6 to noteBSharp,
            7 to noteCSharp2,
            8 to noteD,
            9 to noteE,
            10 to noteA,
            11 to noteB
        )

        val d_scale = mapOf<Int, Note>(
            0 to noteD,
            1 to noteE,
            2 to noteFSharp,
            3 to noteG,
            4 to noteA,
            5 to noteB,
            6 to noteCSharp2,
            7 to noteD2,
            8 to noteEFlat,
            9 to noteF,
            10 to noteBFlat,
            11 to noteC2
        )

        val eFlat_scale = mapOf<Int, Note>(
            0 to noteEFlat,
            1 to noteF,
            2 to noteG,
            3 to noteAFlat,
            4 to noteBFlat,
            5 to noteC2,
            6 to noteD2,
            7 to noteEFlat2,
            8 to noteFFlat2,
            9 to noteGFlat2,
            10 to noteCFlat2,
            11 to noteDFlat2
        )

        val e_scale = mapOf<Int, Note>(
            0 to noteE,
            1 to noteFSharp,
            2 to noteGSharp,
            3 to noteA,
            4 to noteB,
            5 to noteCSharp2,
            6 to noteDSharp2,
            7 to noteE2,
            8 to noteF,
            9 to noteG,
            10 to noteC2,
            11 to noteDFlat2
        )

        val f_scale = mapOf<Int, Note>(
            0 to noteF,
            1 to noteG,
            2 to noteA,
            3 to noteBFlat,
            4 to noteC2,
            5 to noteD2,
            6 to noteE2,
            7 to noteF2,
            8 to noteGFlat,
            9 to noteAFlat,
            10 to noteDFlat,
            11 to noteEFlat
        )

        val fSharp_scale = mapOf<Int, Note>(
            0 to noteFSharp,
            1 to noteGSharp,
            2 to noteASharp,
            3 to noteB,
            4 to noteCSharp2,
            5 to noteDSharp2,
            6 to noteESharp2,
            7 to noteFSharp2,
            8 to noteG,
            9 to noteA,
            10 to noteD2,
            11 to noteE2
        )

        val g_scale = mapOf<Int, Note>(
            0 to noteG,
            1 to noteA,
            2 to noteB,
            3 to noteC2,
            4 to noteD2,
            5 to noteE2,
            6 to noteFSharp2,
            7 to noteG2,
            8 to noteAFlat,
            9 to noteBFlat,
            10 to noteEFlat,
            11 to noteF
        )



        val aFlat_scale = mapOf<Int, Note>(
            0 to noteAFlat,
            1 to noteBFlat,
            2 to noteC2,
            3 to noteDFlat2,
            4 to noteEFlat2,
            5 to noteF2,
            6 to noteG2,
            7 to noteAFlat2,
            8 to  noteCFlat2,
            9 to noteFFlat2,
            10 to noteGFlat2
        )

        val a_scale = mapOf<Int, Note>(
            0 to noteA,
            1 to noteB2,
            2 to noteCSharp2,
            3 to noteD2,
            4 to noteE2,
            5 to noteFSharp2,
            6 to noteGSharp2,
            7 to noteA2,
            8 to noteBFlat,
            9 to noteC2,
            10 to noteF2,
            11 to noteG2
        )

        val bFlat_scale = mapOf<Int, Note>(
            0 to noteBFlat,
            1 to noteC2,
            2 to noteD2,
            3 to noteEFlat2,
            4 to noteF2,
            5 to noteG2,
            6 to noteA2,
            7 to noteBFlat2,
            8 to noteCFlat2,
            9 to noteDFlat2,
            10 to noteGFlat2,
            11 to noteAFlat2
        )

        val b_scale = mapOf<Int, Note>(
            0 to noteB,
            1 to noteCSharp2,
            2 to noteDSharp2,
            3 to noteE2,
            4 to noteFSharp2,
            5 to noteGSharp2,
            6 to noteASharp2,
            7 to noteB2,
            8 to noteC2,
            9 to noteD2,
            10 to noteG2,
            11 to noteA2
        )


        val arrayOfScales = arrayListOf<Map<Int, Note>>(
            c_scale,
            d_scale,
            e_scale,
            f_scale,
            g_scale,
            cSharp_scale,
            eFlat_scale,
            fSharp_scale,
            aFlat_scale,
            a_scale,
            bFlat_scale,
            b_scale
        )


        /*val dict = mapOf<String, Note>(
            "C" to Note(imageNoteUpMinus, 1.90f,  1, true, null),
            "D" to Note(imageNoteUp, 2.10f, 2,false,null),
            "E" to Note(imageNoteUp, 2.30f,  3, false, null),
            "F" to Note(imageNoteUp, 2.65f,  4, false, null),
            "G" to Note(imageNoteUp, 3.05f, 5, false, null),
            "A" to Note(imageNoteUp, 3.75f, 6, false, null),
            "B" to Note(imageNoteUp, 4.50f, 7, false, null),
            "C2" to Note(imageNoteDown, 2.55f, 8, false, null),
            "D2" to Note(imageNoteDown, 3.00f, 9, false, null),
            "E2" to Note(imageNoteDown, 3.55f, 10, false, null),
            "F2" to Note(imageNoteDown, 4.20f, 11, false, null),
            "G2" to Note(imageNoteDown, 5.10f, 12, false, null),
            "A2" to Note(imageNoteDownMinus, 6.00f, 13, true, null),
            "B2" to Note(imageNoteDownMinusTwo, 7.00f, 14, true, null),
            "C#" to Note(imageNoteUpMinus, 1.90f,  15, true, imageSharpBitmap),
            "D#" to Note(imageNoteUp, 2.10f, 16,false,imageSharpBitmap),
            "E#" to Note(imageNoteUp, 2.30f,  17, false, imageSharpBitmap),
            "F#" to Note(imageNoteUp, 2.65f,  18, false, imageSharpBitmap),
            "G#" to Note(imageNoteUp, 3.05f, 19, false, imageSharpBitmap),
            "A#" to Note(imageNoteUp, 3.75f, 20, false, imageSharpBitmap),
            "B#" to Note(imageNoteUp, 4.50f, 21, false, imageSharpBitmap),
            "C2#" to Note(imageNoteDown, 2.55f, 22, false, imageSharpBitmap),
            "D2#" to Note(imageNoteDown, 3.00f, 23, false, imageSharpBitmap),
            "E2#" to Note(imageNoteDown, 3.55f, 24, false, imageSharpBitmap),
            "F2#" to Note(imageNoteDown, 4.20f, 25, false, imageSharpBitmap),
            "G2#" to Note(imageNoteDown, 5.10f, 26, false, imageSharpBitmap),
            "A2#" to Note(imageNoteDownMinus, 6.00f, 27, true, imageSharpBitmap),
            "B2#" to Note(imageNoteDownMinusTwo, 7.00f, 28, true, imageSharpBitmap),
            "Cb" to Note(imageNoteUpMinus, 1.90f,  29, true, imageFlatBitmap),
            "Db" to Note(imageNoteUp, 2.10f, 30,false,imageFlatBitmap),
            "Eb" to Note(imageNoteUp, 2.30f,  31, false, imageFlatBitmap),
            "Fb" to Note(imageNoteUp, 2.65f,  32, false, imageFlatBitmap),
            "Gb" to Note(imageNoteUp, 3.05f, 33, false, imageFlatBitmap),
            "Ab" to Note(imageNoteUp, 3.75f, 34, false, imageFlatBitmap),
            "Bb" to Note(imageNoteUp, 4.50f, 35, false, imageFlatBitmap),
            "C2b" to Note(imageNoteDown, 2.55f, 36, false, imageFlatBitmap),
            "D2b" to Note(imageNoteDown, 3.00f, 37, false, imageFlatBitmap),
            "E2b" to Note(imageNoteDown, 3.55f, 38, false, imageFlatBitmap),
            "F2b" to Note(imageNoteDown, 4.20f, 39, false, imageFlatBitmap),
            "G2b" to Note(imageNoteDown, 5.10f, 40, false, imageFlatBitmap),
            "A2b" to Note(imageNoteDownMinus, 6.00f, 41, true, imageFlatBitmap),
            "B2b" to Note(imageNoteDownMinusTwo, 7.00f, 42, true, imageFlatBitmap)
        )*/



        var imageNotation = BitmapFactory.decodeResource(resources, R.drawable.notationinterval)

        var random  = Random
        var randomNoteNumber  = Random
      //  var random_scale : Map<Int, Note> = arrayOfScales.elementAt(random.nextInt(arrayOfScales.size))
        var number1ScaleRandom : Int = random.nextInt(arrayOfScales.size)
        var random_scale : Map<Int, Note> = arrayOfScales.elementAt(number1ScaleRandom)
        number2ScaleNoteRandom  = randomNoteNumber.nextInt(random_scale.size)
        var rootNumber : Int = 0
       // dict.entries.elementAt(random.nextInt(dict.size))


         firstNote  = random_scale.get(rootNumber)
         secondNote = random_scale.get(number2ScaleNoteRandom)
        /*var firstNote : Note? = random_scale.get(randomNoteNumber.nextInt(random_scale.size))
        var secondNote : Note? = random_scale.get(randomNoteNumber.nextInt(random_scale.size))*/

        var bitmap = overlay(imageNotation, firstNote!!, secondNote!!) // exclamacion mark is when you want NPE , null pouinter exception you tell it that this field will not be null but it can be :D


        //var bitmap = overlay(imageNotation, dict.get("C#")!!, dict.get("B2b")!!)
        var imgView : ImageView = findViewById(R.id.intervalImg)


        var dstBitmap = Bitmap.createBitmap(
            bitmap.getWidth() ,  // Width
            bitmap.getHeight(),  // Height
            Bitmap.Config.ARGB_8888 // Config
        )

        val canvas = Canvas(dstBitmap)

        //Finally, Draw the source bitmap on the canvas
        canvas.drawBitmap(
            bitmap,  // Bitmap
            0f,  // Left
            0f,  // Top
            null // Paint
        )

        imgView.setImageBitmap(dstBitmap)

        b_answer1.setOnClickListener(View.OnClickListener {

            buttonPressed(0)
        } )

        b_answer2.setOnClickListener(View.OnClickListener {

            buttonPressed(8)
        } )
        b_answer3.setOnClickListener(View.OnClickListener {

            buttonPressed(1)
        } )
        b_answer4.setOnClickListener(View.OnClickListener {

            buttonPressed(9)
        } )
        b_answer5.setOnClickListener(View.OnClickListener {

            buttonPressed(2)
        } )
        b_answer6.setOnClickListener(View.OnClickListener {

            buttonPressed(3)
        } )
        b_answer7.setOnClickListener(View.OnClickListener {

            buttonPressed(4)
        } )
        b_answer8.setOnClickListener(View.OnClickListener {

            buttonPressed(10)
        } )
        b_answer9.setOnClickListener(View.OnClickListener {

            buttonPressed(5)
        } )
        b_answer10.setOnClickListener(View.OnClickListener {

            buttonPressed(11)
        } )
        b_answer11.setOnClickListener(View.OnClickListener {

            buttonPressed(6)
        } )
        b_answer12.setOnClickListener(View.OnClickListener {

            buttonPressed(7)
        } )





    }


    fun buttonPressed(buttonPressedNum : Int){

        /*
        * P1 - 0 - button 1
        * m2 - 1 - button 2
        * M2 - 2 - button 3
        * m3 - 3 - button 4
        * M3 - 4 - button 5
        * P4 - 5 - button 6
        * P5 - 6 - button 7
        * m6 - 7 - button 8
        * M6 - 8 - button 9
        * m7 - 9 - button 10
        * M7 - 10 - button 11
        * P8 - 11 - button 12
        * */


        // Check if the answer is correct
        if(buttonPressedNum == number2ScaleNoteRandom ) {
            Toast.makeText(this@IntervalActivity, "Correct", Toast.LENGTH_SHORT).show()
            val i = Intent(this, IntervalActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            finish()
            startActivity(i)
        }

        else {
            val builder  = AlertDialog.Builder(this)
            builder.setTitle("You lost!")
            builder.setMessage("Do you want to play again ? ")
            /*Toast.makeText(this@MajorKeyActivity, "Wrong", Toast.LENGTH_SHORT).show()
            Toast.makeText(this@MajorKeyActivity, "You lost the game with " + score + " score", Toast.LENGTH_SHORT).show()*/

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
                val i = Intent(this, IntervalActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                finish()
                startActivity(i)
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(applicationContext,
                    "Too bad ! See ya", Toast.LENGTH_SHORT).show()
                finish()
            }
            builder.show()
            }
    }

    fun overlay(bmp1 : Bitmap, noteOne : Note, noteTwo : Note) : Bitmap {

        val bmOverlay = Bitmap.createBitmap(bmp1.width, bmp1.height, bmp1.config)
        val canvas = Canvas(bmOverlay)
        val topDivisionValue : Float = 20f

        var sharpOrFlat_noteOne = noteOne.icon_sharp_flat
        var sharpOrFlat_noteTwo = noteTwo.icon_sharp_flat

        var resizedNoteOne : Bitmap
        var resizedNoteTwo : Bitmap
        var resizedSharpOrFlatOne : Bitmap
        var resizedSharpOrFlatTwo : Bitmap

        if(noteOne.hasMinus == true && noteTwo.hasMinus == false){
            resizedNoteOne = getResizedBitmap(noteOne.icon_Bitmap, bmOverlay.width / 13.475f, bmOverlay.height / 3.1f)
            resizedNoteTwo = getResizedBitmap(noteTwo.icon_Bitmap, bmOverlay.width / 21.56f, bmOverlay.height / 3.1f)
        }
        else if(noteOne.hasMinus == false && noteTwo.hasMinus == true){
            resizedNoteOne = getResizedBitmap(noteOne.icon_Bitmap, bmOverlay.width / 21.56f, bmOverlay.height / 3.1f)
            resizedNoteTwo = getResizedBitmap(noteTwo.icon_Bitmap, bmOverlay.width / 13.475f, bmOverlay.height / 3.1f)
        }
        else if (noteOne.hasMinus == true && noteTwo.hasMinus == true){
            resizedNoteOne = getResizedBitmap(noteOne.icon_Bitmap, bmOverlay.width / 13.475f, bmOverlay.height / 3.1f)
            resizedNoteTwo = getResizedBitmap(noteTwo.icon_Bitmap, bmOverlay.width / 13.475f, bmOverlay.height / 3.1f)
        }
        else {
            resizedNoteOne = getResizedBitmap(noteOne.icon_Bitmap, bmOverlay.width / 21.56f, bmOverlay.height / 3.1f)
            resizedNoteTwo = getResizedBitmap(noteTwo.icon_Bitmap, bmOverlay.width / 21.56f, bmOverlay.height / 3.1f)
        }


        var bitmapTransparentNoteOne = makeTransparent(resizedNoteOne, Color.WHITE)
        var bitmapTransparentNoteTwo = makeTransparent(resizedNoteTwo, Color.WHITE)


        canvas.drawBitmap(bmp1, Matrix(), null)
        canvas.drawBitmap(bitmapTransparentNoteOne, bmOverlay.width / 4.200f, bmOverlay.height / noteOne.coord_Top_division_value, null)
        canvas.drawBitmap(bitmapTransparentNoteTwo, bmOverlay.width / 1.200f, bmOverlay.height / noteTwo.coord_Top_division_value, null)


        if(sharpOrFlat_noteOne != null && sharpOrFlat_noteTwo != null){

            resizedSharpOrFlatOne = getResizedBitmap(sharpOrFlat_noteOne, bmOverlay.width / 21.56f, bmOverlay.height / 3.1f)
            resizedSharpOrFlatTwo = getResizedBitmap(sharpOrFlat_noteTwo, bmOverlay.width / 21.56f, bmOverlay.height / 3.1f)

            var transparentSharpOrFlatOne = makeTransparent(resizedSharpOrFlatOne, Color.WHITE)
            var transparentSharpOrFlatTwo = makeTransparent(resizedSharpOrFlatTwo, Color.WHITE)

            canvas.drawBitmap(transparentSharpOrFlatOne, bmOverlay.width / 5.700f, (bmOverlay.height / noteOne.coord_Top_division_value) + topDivisionValue, null )
            canvas.drawBitmap(transparentSharpOrFlatTwo, bmOverlay.width / 1.300f, (bmOverlay.height / noteTwo.coord_Top_division_value) + topDivisionValue, null )

        }
        else if (sharpOrFlat_noteOne != null && sharpOrFlat_noteTwo == null){
            resizedSharpOrFlatOne = getResizedBitmap(sharpOrFlat_noteOne, bmOverlay.width / 21.56f, bmOverlay.height / 3.1f)
            var transparentSharpOrFlatOne = makeTransparent(resizedSharpOrFlatOne, Color.WHITE)
            canvas.drawBitmap(transparentSharpOrFlatOne, bmOverlay.width / 5.700f, (bmOverlay.height / noteOne.coord_Top_division_value) + topDivisionValue, null )
        }
        else if (sharpOrFlat_noteOne == null && sharpOrFlat_noteTwo != null){
             resizedSharpOrFlatTwo = getResizedBitmap(sharpOrFlat_noteTwo, bmOverlay.width / 21.56f, bmOverlay.height / 3.1f)
             var transparentSharpOrFlatTwo = makeTransparent(resizedSharpOrFlatTwo, Color.WHITE)
            canvas.drawBitmap(transparentSharpOrFlatTwo, bmOverlay.width / 1.300f, (bmOverlay.height / noteTwo.coord_Top_division_value) + topDivisionValue, null )
        }


       // canvas.drawBitmap(bitmapTransparentNoteTwo, bmOverlay.width / 1.200f, bmOverlay.height / , null)


       // canvas.drawBitmap(bitmapTransparentNoteOne, noteOne.coord_Left, noteOne.coord_Top, null)
        //canvas.drawBitmap(bitmapTransparentNoteTwo, noteTwo.coord_Left, noteTwo.coord_Top, null)
        return bmOverlay
    }
    /*fun overlay(bmp1 : Bitmap, bmp2 : Bitmap, offsetLeftBmp2 : Float, offsetTopBmp2: Float) : Bitmap {

        val bmOverlay = Bitmap.createBitmap(bmp1.width, bmp1.height, bmp1.config)
        val canvas = Canvas(bmOverlay)
        var resizedBmp2 = getResizedBitmap(bmp2, 80, 200 )
        var bitmapTransparent = makeTransparent(resizedBmp2, Color.WHITE)
        canvas.drawBitmap(bmp1, Matrix(), null)
        canvas.drawBitmap(bitmapTransparent, offsetLeftBmp2, offsetTopBmp2, null)
        return bmOverlay
    }*/

    // Convert transparentColor to be transparent in a Bitmap.
    fun makeTransparent(bitmap : Bitmap, transparentColor : Int ) : Bitmap {
        var width : Int = bitmap.width
        var height : Int = bitmap.height
        var changedBitmap : Bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        var arrayLenght = changedBitmap.height * changedBitmap.width
        var allpixels = IntArray(arrayLenght)
        bitmap.getPixels(allpixels, 0, width, 0,0, width, height)

        for (i in 0 until arrayLenght) {
            if (allpixels[i] == transparentColor)
                allpixels[i] = Color.alpha(Color.TRANSPARENT)
        }

        changedBitmap.setPixels(allpixels, 0, changedBitmap.getWidth(), 0, 0, changedBitmap.getWidth(), changedBitmap.getHeight());

        return changedBitmap

    }

    fun getResizedBitmap(bm: Bitmap, newWidth: Float, newHeight: Float): Bitmap {
        val width = bm.width
        val height = bm.height
        val scaleWidth = newWidth / width
        val scaleHeight = newHeight / height
        // CREATE A MATRIX FOR THE MANIPULATION
        val matrix = Matrix()
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight)

        // "RECREATE" THE NEW BITMAP
        val resizedBitmap = Bitmap.createBitmap(
            bm, 0, 0, width, height, matrix, false
        )
       // bm.recycle()
        return resizedBitmap
    }
}