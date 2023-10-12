package com.example.uts_mobile_caloricare_rasyidk.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_mobile_caloricare_rasyidk.MainActivity
import com.example.uts_mobile_caloricare_rasyidk.R
import com.example.uts_mobile_caloricare_rasyidk.welcomingPage.WelcomingActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Simulate a delay (e.g., 2000 milliseconds) using a handler
        val splashDuration = 2000L
        val intent = Intent(this, WelcomingActivity::class.java)

        val handler = android.os.Handler()
        handler.postDelayed({
            startActivity(intent)
            finish()
        }, splashDuration)
    }
}