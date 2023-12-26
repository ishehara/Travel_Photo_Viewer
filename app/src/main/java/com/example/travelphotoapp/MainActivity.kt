package com.example.travelphotoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var currentImage = 0
    lateinit var image:ImageView
    lateinit var imageText:TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //make the connection with button on the frontend
        val next = findViewById<ImageButton>(R.id.btnNext)
        val prev= findViewById<ImageButton>(R.id.btnPrevious)


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


            showName(currentImage)


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


            showName(currentImage)


        }


    }
     //creating a function to show Name of the place in the textView box
    fun showName(num:Int){
         imageText = findViewById<TextView>(R.id.nameOfPlace)

        when(num){
            0->imageText.text="Coconut Tree Hills"
            1->imageText.text="Galle"
            2->imageText.text="Nelligala"
            3->imageText.text="Red Mosque"
            4->imageText.text="Ruwanweli Seya"
            5->imageText.text="Sigiriya"
        }
    }




}

