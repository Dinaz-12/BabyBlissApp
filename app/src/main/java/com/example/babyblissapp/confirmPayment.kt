package com.example.babyblissapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class confirmPayment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirm_payment)

        val nextBtn = findViewById<Button>(R.id.comBackbtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this, cart::class.java)
            startActivity(intent)

        }
    }
}