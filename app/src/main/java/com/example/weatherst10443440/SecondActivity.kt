package com.example.weatherst10443440

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val backButton: Button = findViewById(R.id.backButton)
        val detailTextView: TextView = findViewById(R.id.detailTextView)

        // Retrieve weekly temperatures from MainActivity
        val weeklyTemperatures = intent.getIntArrayExtra("WEEKLY_TEMPERATURES") ?: intArrayOf()
        val weeklyConditions = intent.getStringArrayExtra("WEEKLY_CONDITIONS") ?: arrayOf()
        // Array of day names
        val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

        // Display temperature details for each day
        val stringBuilder = StringBuilder()
        for (i in weeklyTemperatures.indices) {
            stringBuilder.append("Day ${i + 1}: ${weeklyTemperatures[i]}°C\n")
        }
        detailTextView.text = stringBuilder.toString()

        backButton.setOnClickListener {
            finish() // Navigate back to the main screen
        }
    }
}
