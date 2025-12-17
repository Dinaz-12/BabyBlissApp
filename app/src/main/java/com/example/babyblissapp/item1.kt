package com.example.babyblissapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class item1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_item1)


        val nextButton = findViewById<Button>(R.id.addCart)
        nextButton.setOnClickListener {
            val intent = Intent(this, cart::class.java)
            startActivity(intent)

        }

        val nextBtn = findViewById<Button>(R.id.backbtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)

        }




    }
}