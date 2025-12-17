package com.example.babyblissapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Music : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_music)

        val nextBtn = findViewById<Button>(R.id.songBack)
        nextBtn.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)

        }

    }
}