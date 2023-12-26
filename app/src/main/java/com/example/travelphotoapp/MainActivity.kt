package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var currentImage = 0
    lateinit var image:ImageView
    var places = arrayOf("Coconut Tree Hills", "Galle", "Nelligala", "Red Mosque", "Ruwanweli Seya", "Sigiriya")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev= findViewById<ImageButton>(R.id.btnPrevious)
        val placeName = findViewById<TextView>(R.id.nameOfPlace)

        next.setOnClickListener{
            //getting the next image
            var idCurrentImageString = "image$currentImage"
            // getting the integer address associated with the each image
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (6+(currentImage +1))%6
            var idImageToShowString = "image$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text=places[currentImage]
        }

        prev.setOnClickListener{
            var idCurrentImageString = "image$currentImage"
            // getting the integer address associated with the each image
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha = 0f

            currentImage = (6+(currentImage -1))%6
            var idImageToShowString = "image$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            placeName.text=places[currentImage]

        }

    }
}