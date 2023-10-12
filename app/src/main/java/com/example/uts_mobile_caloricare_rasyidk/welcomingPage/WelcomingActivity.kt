package com.example.uts_mobile_caloricare_rasyidk.welcomingPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.uts_mobile_caloricare_rasyidk.R
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityWelcomingBinding
import com.example.uts_mobile_caloricare_rasyidk.getstarted.GS1_inputNameActivity

import com.example.uts_mobile_caloricare_rasyidk.welcomingPage.adapters.OnboardingViewPagerAdapter2
import com.google.android.material.tabs.TabLayoutMediator

class WelcomingActivity : AppCompatActivity() {
    private lateinit var mViewPager: ViewPager2
    private lateinit var btnCreateAccount: Button

    private lateinit var binding: ActivityWelcomingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        btnCreateAccount = binding.btnCreateAccount
        btnCreateAccount.setOnClickListener {
            val intent = Intent(this, GS1_inputNameActivity::class.java)
            startActivity(intent)
        }

        mViewPager = findViewById(R.id.viewPager)
        mViewPager.adapter = OnboardingViewPagerAdapter2(this, this)
        TabLayoutMediator(binding.pageIndicator, mViewPager) { _, _ -> }.attach()
        mViewPager.offscreenPageLimit = 1
    }
}