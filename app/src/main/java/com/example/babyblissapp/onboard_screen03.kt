package com.example.babyblissapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class onboard_screen03 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_onboard_screen03)

        val nextButton = findViewById<Button>(R.id.onboardbtn3)

        nextButton.setOnClickListener {
            val intent = Intent(this, onboard_screen04::class.java)
            startActivity(intent)

        }
    }
}