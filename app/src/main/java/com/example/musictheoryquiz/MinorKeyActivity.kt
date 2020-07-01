package com.example.musictheoryquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MinorKeyActivity : AppCompatActivity() {

    lateinit var imgMusicKeyItem : ImageView
    lateinit var scoreText : TextView
    var  list = ArrayList<KeyItem>()
    var r : Random = Random
    var turn : Int = 1
    var score : Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.activity_minor_key)


        scoreText  =  findViewById(R.id.scoreView)
        scoreText.setText(score.toString())
        imgMusicKeyItem = findViewById(R.id.imgMusicKey)

        var  b_answer1 : Button = findViewById(R.id.b_answer1)
        var  b_answer2 : Button = findViewById(R.id.b_answer2)
        var  b_answer3 : Button = findViewById(R.id.b_answer3)
        var  b_answer4 : Button = findViewById(R.id.b_answer4)


        for ((index) in Database().answersMinor.withIndex()) {
            list.add(KeyItem(Database().answersMinor[index], Database().keys[index]))
        }

        Collections.shuffle(list)
        newQuestion(turn)

        b_answer1.setOnClickListener(View.OnClickListener {

            buttonPressed(b_answer1)
        } )

        b_answer2.setOnClickListener(View.OnClickListener {

            buttonPressed(b_answer2)
        } )

        b_answer3.setOnClickListener(View.OnClickListener {
            buttonPressed(b_answer3)
        } )

        b_answer4.setOnClickListener(View.OnClickListener {

            buttonPressed(b_answer4)
        } )


    }

    private fun buttonPressed(buttonPressedNum : Button){
        // check if the answer is correct
        if(buttonPressedNum.text.toString().equals(list.get(turn - 1).name, true)) {
            Toast.makeText(this@MinorKeyActivity, "Correct", Toast.LENGTH_SHORT).show()



            //check if the last question
            if(turn < list.size){
                score = turn * 10
                turn++
                scoreText.setText(score.toString())
                newQuestion(turn)

            }else {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Congrats !! You finished the game with " + score + " score")
                builder.setMessage("Do you want to play again ?")

                builder.setPositiveButton(android.R.string.yes){
                        dialog, which -> Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()
                    val i = Intent(this, MinorKeyActivity::class.java )
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    finish()
                    startActivity(i)
                }

                builder.setNegativeButton(android.R.string.no){
                        dialog, which ->   Toast.makeText(applicationContext, android.R.string.no, Toast.LENGTH_SHORT).show()
                    finish()
                }
                // Toast.makeText(this@MinorKeyActivity, "You finished the game with " + score + " score", Toast.LENGTH_SHORT).show()
                builder.show()
            }

        }else{
            val builder  = AlertDialog.Builder(this)
            builder.setTitle("You lost!")
            builder.setMessage("Do you want to play again ? ")
            /*Toast.makeText(this@MinorKeyActivity, "Wrong", Toast.LENGTH_SHORT).show()
            Toast.makeText(this@MinorKeyActivity, "You lost the game with " + score + " score", Toast.LENGTH_SHORT).show()*/

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    android.R.string.yes, Toast.LENGTH_SHORT
                ).show()
                val i = Intent(this, MinorKeyActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                finish()
                startActivity(i)
            }
            builder.setNegativeButton(android.R.string.no) { dialog, which ->
                Toast.makeText(applicationContext,
                    "Too bad ! You finished the game with "+ score +" score", Toast.LENGTH_SHORT).show()
                finish()
            }
            builder.show()
        }

    }


    private fun newQuestion(number : Int) {
        // set image to the screen
        imgMusicKeyItem.setImageResource(list.get(number - 1).image)


        // decide which button is the correct answer
        var correct_Answer : Int = r.nextInt(4) + 1

        var firstButton : Int = number - 1
        var secondButton : Int
        var thirdButton : Int
        var fourthButton : Int
        var fifthButton : Int

        /* distinct random number
        Random randNum = new Random();
      Set<Integer>set = new LinkedHashSet<Integer>();
      while (set.size() < 10) {
         set.add(randNum.nextInt(10)+1);
      }
      System.out.println("Distinct random numbers = "+set);*/

        when (correct_Answer) {

            1 -> {
                b_answer1.setText(list.get(firstButton).name)
                do {
                    secondButton = r.nextInt(list.size)
                }while (secondButton == firstButton)
                do {
                    thirdButton = r.nextInt(list.size)
                }while (thirdButton == firstButton || thirdButton == secondButton)
                do{
                    fourthButton = r.nextInt(list.size)
                }while(fourthButton == thirdButton ||fourthButton == secondButton || fourthButton == firstButton)
                do {
                    fifthButton = r.nextInt(list.size)
                }while (fifthButton == fourthButton || fifthButton == thirdButton || fifthButton == secondButton || fifthButton == firstButton)

                b_answer2.setText(list.get(secondButton).name)
                b_answer3.setText(list.get(thirdButton).name)
                b_answer4.setText(list.get(fourthButton).name)

            }

            2 -> {
                b_answer2.setText(list.get(firstButton).name)
                do {
                    secondButton = r.nextInt(list.size)
                }while (secondButton == firstButton)
                do {
                    thirdButton = r.nextInt(list.size)
                }while (thirdButton == firstButton || thirdButton == secondButton)
                do{
                    fourthButton = r.nextInt(list.size)
                }while(fourthButton == thirdButton ||fourthButton == secondButton || fourthButton == firstButton)
                do {
                    fifthButton = r.nextInt(list.size)
                }while (fifthButton == fourthButton || fifthButton == thirdButton || fifthButton == secondButton || fifthButton == firstButton)

                b_answer1.setText(list.get(secondButton).name)
                b_answer3.setText(list.get(thirdButton).name)
                b_answer4.setText(list.get(fourthButton).name)

            }

            3 -> {
                b_answer3.setText(list.get(firstButton).name)
                do {
                    secondButton = r.nextInt(list.size)
                }while (secondButton == firstButton)
                do {
                    thirdButton = r.nextInt(list.size)
                }while (thirdButton == firstButton || thirdButton == secondButton)
                do{
                    fourthButton = r.nextInt(list.size)
                }while(fourthButton == thirdButton ||fourthButton == secondButton || fourthButton == firstButton)
                do {
                    fifthButton = r.nextInt(list.size)
                }while (fifthButton == fourthButton || fifthButton == thirdButton || fifthButton == secondButton || fifthButton == firstButton)

                b_answer2.setText(list.get(secondButton).name)
                b_answer1.setText(list.get(thirdButton).name)
                b_answer4.setText(list.get(fourthButton).name)

            }

            4 ->
            {
                b_answer4.setText(list.get(firstButton).name)
                do {
                    secondButton = r.nextInt(list.size)
                }while (secondButton == firstButton)
                do {
                    thirdButton = r.nextInt(list.size)
                }while (thirdButton == firstButton || thirdButton == secondButton)
                do{
                    fourthButton = r.nextInt(list.size)
                }while(fourthButton == thirdButton ||fourthButton == secondButton || fourthButton == firstButton)
                do {
                    fifthButton = r.nextInt(list.size)
                }while (fifthButton == fourthButton || fifthButton == thirdButton || fifthButton == secondButton || fifthButton == firstButton)

                b_answer2.setText(list.get(secondButton).name)
                b_answer3.setText(list.get(thirdButton).name)
                b_answer1.setText(list.get(fourthButton).name)

            }

        }

    }
}