package com.example.photoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 1
    lateinit var image: ImageView
    var names = arrayOf("Larry Page","Kevin Systrom","Sergey Brin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val prev = findViewById<ImageButton>(R.id.imgPrevious)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.text2)

        prev.setOnClickListener {

            var currentImageString = "pic$currentImage"
            var currentImageInt =
                this.resources.getIdentifier(currentImageString, "id", packageName)
            image = findViewById(currentImageInt)
            image.alpha = 0f

            currentImage = (3 + currentImage - 1) % 3

            var prevImageString = "pic$currentImage"
            var prevImageInt = this.resources.getIdentifier(prevImageString, "id", packageName)
            image = findViewById(prevImageInt)
            image.alpha = 1f
            text.text = names[currentImage]


        }
        next.setOnClickListener {

            val currentImageString = "pic$currentImage"
            val currentImageInt = this.resources.getIdentifier(currentImageString,"id",packageName)

            image = findViewById(currentImageInt)
            image.alpha = 0f

            currentImage = (3+ currentImage + 1)%3
            val nextImageString = "pic$currentImage"
            val nextImageInt = this.resources.getIdentifier(nextImageString,"id",packageName)

            image = findViewById(nextImageInt)
            image.alpha = 1f
            text.text = names[currentImage]


        }


    }
}