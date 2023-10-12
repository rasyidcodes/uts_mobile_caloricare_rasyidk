package com.example.uts_mobile_caloricare_rasyidk.getstarted


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uts_mobile_caloricare_rasyidk.R
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityGs1InputNameBinding
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityWelcomingBinding
import com.example.uts_mobile_caloricare_rasyidk.welcomingPage.WelcomingActivity

class GS1_inputNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGs1InputNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGs1InputNameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val intent = Intent(this, GS2_SayHiActivity::class.java)

        with(binding){
            binding.gs1BtLanjut.setOnClickListener {
                val name = binding.gs1EtName.text.toString()
                if (name == ""){
                    Toast.makeText(applicationContext, "Nama Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
                }else{
                    intent.putExtra("name", name)
                    startActivity(intent)
                }
            }
        }

    }
}