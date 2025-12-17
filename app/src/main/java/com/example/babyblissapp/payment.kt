package com.example.babyblissapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class payment : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_payment)

        val nextBtn = findViewById<Button>(R.id.payBack)
        nextBtn.setOnClickListener {
            val intent = Intent(this, cart::class.java)
            startActivity(intent)

        }

        val payButton = findViewById<Button>(R.id.payBtn)
        payButton.setOnClickListener {
            val intent = Intent(this, confirmPayment::class.java)
            startActivity(intent)

        }

        val etCard = findViewById<EditText>(R.id.etCardNumber)
        val etName = findViewById<EditText>(R.id.etCardHolder)
        val etExp  = findViewById<EditText>(R.id.etExpiry)   // format: MM/YY
        val etCvv  = findViewById<EditText>(R.id.etCvv)      // 3 digits
        val btnPay = findViewById<Button>(R.id.payBtn)

        btnPay.setOnClickListener {
            var ok = true
            fun err(v: EditText, msg: String) { v.error = msg; if (ok) v.requestFocus(); ok = false }

            val number = etCard.text.toString().replace(" ", "")
            val name   = etName.text.toString().trim()
            val exp    = etExp.text.toString().trim()
            val cvv    = etCvv.text.toString().trim()

            // very simple checks
            if (number.length != 10 || !number.all { it.isDigit() })
                err(etCard, "Enter 10-digit card number")

            if (name.length < 3) err(etName, "Enter card holder name")

            val expRegex = Regex("^(0[1-9]|1[0-2])/\\d{2}$") // MM/YY
            if (!expRegex.matches(exp)) err(etExp, "Use MM/YY")
            else {
                // basic not-expired check
                val mm = exp.substring(0,2).toInt()
                val yy = 2000 + exp.substring(3,5).toInt()
                val now = java.util.Calendar.getInstance().apply {
                    set(java.util.Calendar.DAY_OF_MONTH, 1)
                }
                val expCal = java.util.Calendar.getInstance().apply {
                    set(java.util.Calendar.YEAR, yy)
                    set(java.util.Calendar.MONTH, mm - 1)
                    set(java.util.Calendar.DAY_OF_MONTH, 1)
                }
                if (expCal.before(now)) err(etExp, "Card expired")
            }

            if (!cvv.matches(Regex("^\\d{3}$"))) err(etCvv, "3-digit CVV")

            if (ok) {
                // go to confirmation page
                val i = Intent(this, confirmPayment::class.java)
                startActivity(i)
                // finish() // uncomment if you don't want to come back to payment on back press
            }
        }



    }
}