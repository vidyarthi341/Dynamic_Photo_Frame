package com.example.dynamicphotoframe

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var currentIndex = 0
        val images = arrayOf(R.drawable.pic0, R.drawable.pic1, R.drawable.pic2)
        val texts = arrayOf("VIKAS", "KUMAR", "VIDYARTHI")

        var img = findViewById<ImageView>(R.id.imageView)
        var next = findViewById<ImageButton>(R.id.nxtbtn)
        var prev = findViewById<ImageButton>(R.id.prevbtn)
        var name = findViewById<TextView>(R.id.name)

        next.setOnClickListener {

            currentIndex = (currentIndex + 1) % 3
            img.setImageResource(images[currentIndex])
            name.text = texts[currentIndex]

        }

        prev.setOnClickListener {
            currentIndex = (currentIndex - 1 + 3) % 3
            img.setImageResource(images[currentIndex])
            name.text = texts[currentIndex]
        }





    }
}