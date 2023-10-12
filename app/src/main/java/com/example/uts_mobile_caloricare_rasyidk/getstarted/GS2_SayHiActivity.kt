package com.example.uts_mobile_caloricare_rasyidk.getstarted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_mobile_caloricare_rasyidk.R
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityGs1InputNameBinding
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityGs2SayHiBinding

class GS2_SayHiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGs2SayHiBinding
    private var nameData: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGs2SayHiBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intentToFormData = Intent(this, GS3_FormDataActivity::class.java)

        val intent = intent
        var nameData = intent.getStringExtra("name")

        with(binding){
            val textHi = binding.gs2TvName
            textHi.text = "Hi, " + nameData

            binding.gs2BtLanjut.setOnClickListener {
                intentToFormData.putExtra("name", nameData)
                startActivity(intentToFormData)
            }
        }
    }
}