package com.example.weatherst10443440


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_DELAY: Long = 3000 // 3 seconds delay

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Using a Handler to delay the transition to the next activity
        Handler().postDelayed({
            // Start your main activity after the specified delay
            startActivity(Intent(this@SplashActivity, Main::class.java))
            finish() // Finish the current activity
        }, SPLASH_DELAY)
    }
}
