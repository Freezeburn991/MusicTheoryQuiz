package com.example.musictheoryquiz

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.menu_layout.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        supportActionBar?.hide()
        setContentView(R.layout.menu_layout)

        val buttonMajor = findViewById<Button>(R.id.majorButton)
        buttonMajor.setOnClickListener{
            val intent = Intent(this, MajorKeyActivity::class.java)
            startActivity(intent)
        }

        val buttonMinor = findViewById<Button>(R.id.minorButton)
        minorButton.setOnClickListener{
            val intent = Intent(this, MinorKeyActivity::class.java)
            startActivity(intent)
        }

        val buttonInterval = findViewById<Button>(R.id.intervalButton)
        buttonInterval.setOnClickListener{
            val intent = Intent(this, IntervalActivity::class.java)
            startActivity(intent)
        }
    }

}