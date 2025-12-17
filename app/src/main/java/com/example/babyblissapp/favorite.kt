package com.example.babyblissapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class favorite : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_favorite)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        // Highlight the current tab
        bottomNav.selectedItemId = R.id.nav_favorite

        // Navigate on selection
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, home::class.java))
                    finish()
                    true
                }
                R.id.nav_favorite -> {

                    true
                }
                R.id.nav_cart -> {
                    startActivity(Intent(this, cart::class.java))
                    finish()
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

        val nextButton = findViewById<Button>(R.id.backbtn2)

        nextButton.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)

            }
    }
}