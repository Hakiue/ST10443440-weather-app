package com.example.weatherst10443440

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class appdata : AppCompatActivity() {

    // Arrays to store daily temperatures and their indices for the week
    private val weeklyTemperatures = IntArray(7)
    private val weeklyIndices = Array(7) { it }
    private lateinit var averageTemperatureTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        averageTemperatureTextView = findViewById(R.id.averageTemperatureTextView)
        val goToSecondScreenButton: Button = findViewById(R.id.goToSecondScreenButton)
        val clearDataButton: Button = findViewById(R.id.clearDataButton)
        val inputTemperatureEditText: EditText = findViewById(R.id.inputTemperatureEditText)
        val enterButton: Button = findViewById(R.id.enterButton)

        // Button click listener to navigate to the second screen
        goToSecondScreenButton.setOnClickListener {
            val intent = Intent(this, detail::class.java)
            // Pass the weekly temperatures and indices to the second activity
            intent.putExtra("WEEKLY_TEMPERATURES", weeklyTemperatures)
            intent.putExtra("WEEKLY_INDICES", weeklyIndices)
            startActivity(intent)
        }

        // Button click listener to clear data and re-input temperatures
        clearDataButton.setOnClickListener {
            weeklyTemperatures.fill(0)
            inputTemperatureEditText.text.clear()
            calculateAverageTemperature()
        }

        // Button click listener to input temperature
        enterButton.setOnClickListener {
            val temperatureString = inputTemperatureEditText.text.toString()
            if (temperatureString.isNotEmpty()) {
                val temperature = temperatureString.toInt()
                if (temperature in -50..50) { // Assuming valid temperature range
                    val dayIndex = weeklyTemperatures.indexOf(0)
                    if (dayIndex != -1) {
                        weeklyTemperatures[dayIndex] = temperature
                        inputTemperatureEditText.text.clear()
                        calculateAverageTemperature()
                    }
                } else {
                    // Handle invalid temperature
                    inputTemperatureEditText.error = "Invalid temperature!"
                }
            }
        }
    }

    // Function to calculate and display average temperature
    private fun calculateAverageTemperature() {
        var totalTemperature = 0
        var validDays = 0
        for (temperature in weeklyTemperatures) {
            if (temperature != 0) {
                totalTemperature += temperature
                validDays++
            }
        }
        val averageTemperature = totalTemperature.toDouble() / validDays
        averageTemperatureTextView.text = "Average Temperature: $averageTemperature °C"
    }
}
