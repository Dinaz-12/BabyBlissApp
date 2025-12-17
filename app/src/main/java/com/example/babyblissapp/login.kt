package com.example.babyblissapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val nextSignup = findViewById<Button>(R.id.signup)
        nextSignup.setOnClickListener {
            val intent = Intent(this, register::class.java)
            startActivity(intent)
        }

        val logButton = findViewById<Button>(R.id.loginbtn)
        logButton.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }

    }
}