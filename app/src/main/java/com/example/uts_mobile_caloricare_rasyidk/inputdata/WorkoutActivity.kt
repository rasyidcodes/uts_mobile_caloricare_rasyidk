package com.example.uts_mobile_caloricare_rasyidk.inputdata

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import android.widget.Toast
import com.example.uts_mobile_caloricare_rasyidk.R
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityMakanBinding
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityWorkoutBinding
import com.example.uts_mobile_caloricare_rasyidk.homepage.HomePageActivity

class WorkoutActivity : AppCompatActivity(),  TimePickerDialog.OnTimeSetListener  {


    private lateinit var binding: ActivityWorkoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //intent
        var beratyangdiinginkan =  intent.getStringExtra("beratyangdiinginkan")
        var satuanberatyangdiinginkan = intent.getStringExtra("satuanberatyangdiinginkan")
        var jumlahkalori = intent.getStringExtra("jumlahkalori")
        var name = intent.getStringExtra("name")
        var resmakan = intent.getStringExtra("resmakan")
        val jumlahkalorimakannewIntent  = intent.getStringExtra("jumlahkalorimakannew")

        val jumlahkaloris = jumlahkalori?.toInt() ?: 0


        binding.worTime.setOnClickListener{
            val timepicker = TimePicker()
            timepicker.show(supportFragmentManager, "TP")
        }

        binding.worBtSubmit.setOnClickListener {

            var nameWor = binding.worEtName.text.toString()
            var waktuWor = binding.worTime.text.toString()
            var jumlahKalorinew = binding.worEtKalori.text.toString()

            if (nameWor == "" || waktuWor == "" || jumlahKalorinew == ""){
                Toast.makeText(this, "Data tidak valid!", Toast.LENGTH_SHORT).show()
            }else {
                var reswor = "$nameWor $waktuWor $jumlahKalorinew "

                val intentToFormData = Intent(this, HomePageActivity::class.java)
                intentToFormData.putExtra("name", name)
                intentToFormData.putExtra("beratyangdiinginkan", beratyangdiinginkan)
                intentToFormData.putExtra("satuanberatyangdiinginkan", satuanberatyangdiinginkan)
                intentToFormData.putExtra("jumlahkalori", jumlahkalori)
                intentToFormData.putExtra(
                    "sisakalori",
                    (jumlahkaloris - jumlahKalorinew.toInt()).toString()
                )
                intentToFormData.putExtra("jumlahkaloriworkout", jumlahKalorinew)
                intentToFormData.putExtra("resmakan", resmakan)
                intentToFormData.putExtra("reswor", reswor)
                startActivity(intentToFormData)
            }
        }
    }

    override fun onTimeSet(view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) {
        val selectedTime =  String.format("%02d:%02d", hourOfDay, minute)
        binding.worTime.setText(selectedTime)
    }
}