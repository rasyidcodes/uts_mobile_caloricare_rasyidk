package com.example.uts_mobile_caloricare_rasyidk.inputdata

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.PopupMenu
import android.widget.Toast
import com.example.uts_mobile_caloricare_rasyidk.R
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityHomePageBinding
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityMakanBinding
import com.example.uts_mobile_caloricare_rasyidk.homepage.HomePageActivity

class MakanActivity : AppCompatActivity(),  TimePickerDialog.OnTimeSetListener  {

    private lateinit var binding: ActivityMakanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //intent
        var beratyangdiinginkan =  intent.getStringExtra("beratyangdiinginkan")
        var satuanberatyangdiinginkan = intent.getStringExtra("satuanberatyangdiinginkan")
        var jumlahkalori = intent.getStringExtra("jumlahkalori")
        var name = intent.getStringExtra("name")
        var reswor = intent.getStringExtra("reswor")
        val jumlahkalorimakannewIntent  = intent.getStringExtra("jumlahkalorimakannew")

        val jumlahkaloris = jumlahkalori?.toInt() ?: 0

//        Toast.makeText(this, jumlahkaloris.toString(), Toast.LENGTH_SHORT).show()

        //Spinner
        val spinner1 = binding.makanSpinnerMakan
        val data = listOf("Lunch", "Dinner", "Sarapan")
        var selectTypeMakan = ""

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectTypeMakan = data[position] // Get the selected item from the data list
                // Perform actions based on the selected item
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case where nothing is selected (optional)
            }
        }

        binding.makanTime.setOnClickListener{
            val timepicker = TimePicker()
            timepicker.show(supportFragmentManager, "TP")
        }

        binding.makanBtSubmit.setOnClickListener {
            var nameMakan = binding.makanEtName.text.toString()
            var waktuMakan = binding.makanTime.text.toString()
            var jumlahKalorinew = binding.makanEtKalori.text.toString()

            if (nameMakan == "" || waktuMakan == "" || jumlahKalorinew == "" || selectTypeMakan == ""){
                Toast.makeText(this, "Data tidak valid!",Toast.LENGTH_SHORT).show()
            }else{



            var resmakan =  "$nameMakan $waktuMakan $jumlahKalorinew $selectTypeMakan"
//            var newResKalori = jumlahKalorinew.toInt() + jumlahkalori
            val intentToFormData = Intent(this, HomePageActivity::class.java)
            intentToFormData.putExtra("name", name)
            intentToFormData.putExtra("beratyangdiinginkan", beratyangdiinginkan)
            intentToFormData.putExtra("satuanberatyangdiinginkan", satuanberatyangdiinginkan)
            intentToFormData.putExtra("jumlahkalori", jumlahkalori)
            intentToFormData.putExtra("sisakalori", (jumlahkaloris + jumlahKalorinew.toInt()).toString())
            intentToFormData.putExtra("jumlahkalorimakan", jumlahKalorinew)
            intentToFormData.putExtra("resmakan", resmakan)
            intentToFormData.putExtra("reswor", reswor)
            startActivity(intentToFormData)
            }
        }


    }

    override fun onTimeSet(view: android.widget.TimePicker?, hourOfDay: Int, minute: Int) {
        val selectedTime =  String.format("%02d:%02d", hourOfDay, minute)
        binding.makanTime.setText(selectedTime)
    }
}