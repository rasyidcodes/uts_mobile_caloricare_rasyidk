package com.example.uts_mobile_caloricare_rasyidk.homepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uts_mobile_caloricare_rasyidk.R
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityGs3FormDataBinding
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityHomePageBinding
import com.example.uts_mobile_caloricare_rasyidk.inputdata.MakanActivity
import com.example.uts_mobile_caloricare_rasyidk.inputdata.WorkoutActivity

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var beratyangdiinginkan =  intent.getStringExtra("beratyangdiinginkan")
        var satuanberatyangdiinginkan = intent.getStringExtra("satuanberatyangdiinginkan")
        var jumlahkalori = intent.getStringExtra("jumlahkalori")
        var name = intent.getStringExtra("name")


        var resmakan = intent.getStringExtra("resmakan")
        var reswor = intent.getStringExtra("reswor")



        var sisakalori = intent.getStringExtra("sisakalori")

        var jumlahkalorimakan = intent.getStringExtra("jumlahkalorimakan")

        val jumlahkalorimakannew = jumlahkalorimakan?.toIntOrNull() ?: "0"

        var jumlahkaloriworkout = intent.getStringExtra("jumlahkaloriworkout")

        val jumlahkaloriworkoutnew = jumlahkaloriworkout?.toIntOrNull() ?: "0"


        if (intent.hasExtra("sisakalori")) {
            // The intent contains a value for "sisakalori"
             sisakalori = intent.getStringExtra("sisakalori")
            // You can use the existing value here
        } else {
            // The intent does not contain a value for "sisakalori"
            sisakalori = jumlahkalori
            // You can use the new default value here
        }

        //handle content from intenr
        binding.hmTvTargetkalori.setText(jumlahkalori)
        binding.hmTvTargetberat.setText(beratyangdiinginkan + " " +satuanberatyangdiinginkan)
        binding.hmTvName.setText("Hi!, "+name)
        binding.hmTvSisakalori.setText(sisakalori)
        binding.hmTvMakanan.setText(jumlahkalorimakannew.toString() + " Kcal")
        binding.hmTvWor.setText(jumlahkaloriworkoutnew.toString() + " kcal")


        binding.hmTvResmakan.setText(resmakan)
        binding.hmTvReswor.setText(reswor)


        binding.hmBtMakan.setOnClickListener {
            val intentToFormData = Intent(this, MakanActivity::class.java)
            intentToFormData.putExtra("name", "name")
            intentToFormData.putExtra("beratyangdiinginkan", beratyangdiinginkan)
            intentToFormData.putExtra("satuanberatyangdiinginkan", satuanberatyangdiinginkan)
            intentToFormData.putExtra("jumlahkalori", jumlahkalori)
            intentToFormData.putExtra("reswor", reswor)
            startActivity(intentToFormData)
        }

        binding.hmBtWor.setOnClickListener {
            val intentToFormData = Intent(this, WorkoutActivity::class.java)
            intentToFormData.putExtra("name", "name")
            intentToFormData.putExtra("beratyangdiinginkan", beratyangdiinginkan)
            intentToFormData.putExtra("satuanberatyangdiinginkan", satuanberatyangdiinginkan)
            intentToFormData.putExtra("jumlahkalori", jumlahkalori)
            intentToFormData.putExtra("resmakan", resmakan)
            startActivity(intentToFormData)
        }
    }
}