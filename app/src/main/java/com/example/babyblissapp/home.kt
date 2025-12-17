package com.example.babyblissapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.card.MaterialCardView

class home : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNav.selectedItemId = R.id.nav_home

        // Navigate on selection
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    true
                }
                R.id.nav_favorite -> {
                    startActivity(Intent(this, favorite::class.java))
                    // optional: avoid stacking this activity
                    finish()
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

        bottomNav.setOnItemReselectedListener {  }

        val cardOrganix = findViewById<MaterialCardView>(R.id.item01)
        cardOrganix.setOnClickListener {
            startActivity(
                Intent(this, item1::class.java)
                    .putExtra("PRODUCT_ID", "organix_garden_veggie_bowl")
            )
        }

        val darkButton = findViewById<ImageButton>(R.id.darkbtn)
        darkButton.setOnClickListener {
            startActivity(Intent(this, darkMode::class.java))
        }

        val menuBtn = findViewById<ImageButton>(R.id.menubtn)

        menuBtn.setOnClickListener {
            val popup = PopupMenu(ContextThemeWrapper(this, R.style.CustomPopupMenu), menuBtn)
            popup.menuInflater.inflate(R.menu.menu_items, popup.menu)
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.item_songs -> {
                        startActivity(Intent(this, Music::class.java))
                        finish()
                        true
                    }
                    R.id.item_recipes -> {
                        startActivity(Intent(this, Recipes::class.java))
                        true
                    }
                    R.id.item_logout -> {
                        startActivity(Intent(this, login::class.java))
                        finish()
                        true
                    }

                    else -> false
                }
            }
            popup.show()
        }




    }
}
