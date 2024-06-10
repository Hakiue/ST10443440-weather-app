package com.example.weatherst10443440


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val exitButton: Button = findViewById(R.id.exitButton)

        exitButton.setOnClickListener {
            finishAffinity() // Finish this activity and all parent activities
            System.exit(0) // Exit the app
        }
        val nextButton: Button = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            val intent = Intent(this, appdata::class.java)
            startActivity(intent)
        }

    }
}