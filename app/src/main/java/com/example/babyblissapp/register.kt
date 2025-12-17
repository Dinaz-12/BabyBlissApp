package com.example.babyblissapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

                val fullName = findViewById<EditText>(R.id.etFullName)
                val email = findViewById<EditText>(R.id.etEmail)
                val username = findViewById<EditText>(R.id.etUsername)
                val password = findViewById<EditText>(R.id.etPassword)
                val confirm = findViewById<EditText>(R.id.etConfirm)
                val register = findViewById<Button>(R.id.registerbtn)

                register.setOnClickListener {
                    var ok = true
                    fun err(v: EditText, msg: String) { v.error = msg; if (ok) v.requestFocus(); ok = false }

                    val name = fullName.text.toString().trim()
                    val mail = email.text.toString().trim()
                    val user = username.text.toString().trim()
                    val pass = password.text.toString()
                    val repass = confirm.text.toString()

                    if (name.isEmpty()) err(fullName, "Enter full name")
                    if (mail.isEmpty()) err(email, "Enter email")
                    else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) err(email, "Invalid email")

                    if (user.length < 3) err(username, "Username min 3 chars")
                    if (pass.length < 8) err(password, "Password min 8 chars")
                    if (repass != pass) err(confirm, "Passwords do not match")

                    if (ok) {
                        Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, login::class.java))
                            finish() // optional: prevents coming back to Register on back press

                    }
                }

    }
}