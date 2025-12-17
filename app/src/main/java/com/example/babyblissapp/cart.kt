package com.example.babyblissapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class cart : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cart)


        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.selectedItemId = R.id.nav_cart

        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, home::class.java))
                    // optional: avoid stacking this activity
                    finish()
                    true
                }
                R.id.nav_favorite -> {
                    startActivity(Intent(this, favorite::class.java))
                    // optional: avoid stacking this activity
                    finish()
                    true
                }
                R.id.nav_cart -> {

                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, profile::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }

        val nextButton = findViewById<Button>(R.id.btnBuy)
        nextButton.setOnClickListener {
            val intent = Intent(this, payment::class.java)
            startActivity(intent)
        }

        val nextBtn = findViewById<Button>(R.id.backbtn1)
        nextBtn.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)

        }
    }
}