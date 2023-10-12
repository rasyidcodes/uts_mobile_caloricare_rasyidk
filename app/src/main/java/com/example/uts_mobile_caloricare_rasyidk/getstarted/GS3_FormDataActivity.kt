package com.example.uts_mobile_caloricare_rasyidk.getstarted

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.uts_mobile_caloricare_rasyidk.MainActivity
import com.example.uts_mobile_caloricare_rasyidk.R
import com.example.uts_mobile_caloricare_rasyidk.databinding.ActivityGs3FormDataBinding
import com.example.uts_mobile_caloricare_rasyidk.homepage.HomePageActivity
import java.security.AccessControlContext
import java.security.AccessController.getContext


class GS3_FormDataActivity : AppCompatActivity() , DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityGs3FormDataBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGs3FormDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



//        global
        var targetTanggal = ""


        //retrieve intent
        val intent = intent
         var nameData = intent.getStringExtra("name")

        //SPinner 1 and berat
        val spinner1 = binding.gs3spinnersatuan1
        val data = listOf("Kg", "Lb")
        var selectedSatuan1 = ""

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = adapter

        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedSatuan1 = data[position] // Get the selected item from the data list
                // Perform actions based on the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case where nothing is selected (optional)
            }
        }

        //SPinner 2 and berat yang diinginkan

        val spinner2 = binding.gs3spinnersatuan2
        val data2 = listOf("Kg", "Lb")
        var selectedSatuan2 = ""

        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, data2)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = adapter2

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedSatuan2 = data[position] // Get the selected item from the data list
                // Perform actions based on the selected item
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case where nothing is selected (optional)
            }
        }


        //Tujuan diet
        var selectedTitle=""
        var selectedPosition: Int? = null
            binding.editTextTujuanDiet.setOnClickListener { view ->
                val popupMenu = PopupMenu(view.context, view)
                popupMenu.menuInflater.inflate(R.menu.list_tujuan, popupMenu.menu)

                popupMenu.setOnMenuItemClickListener { item ->
                    val newPosition = item.itemId
                    if (newPosition != selectedPosition) {
                        Log.d("PositionChange", "Selected Position changed to: $newPosition")
                        selectedPosition = newPosition
                    }
                     selectedTitle = item.title.toString()
                    binding.editTextTujuanDiet.setText(selectedTitle)
                    true
                }

                // Set up a default value if no item is selected
                popupMenu.setOnDismissListener {
                    if (selectedPosition == null) {
                        Log.d("PositionChange", "No item selected, using default value")
                        // Set a default value or handle the unselected state here
                        binding.editTextTujuanDiet.setText("Default Value")
                        selectedPosition = 0  // Set to the default position (or -1 if you prefer)
                    }
                }

                popupMenu.show()
            }


            //getDatepicker
                binding.gs3datePickerTextInputEditText.setOnClickListener{
                    val datePicker = DatePicker()
                    datePicker.show(supportFragmentManager, "DP")
                }

            //Bt send
                binding.gs3btsend.setOnClickListener {
                    Log.d("title", selectedTitle)
                    Log.d("position", selectedPosition.toString())


                    val beratsaatini = binding.gs3beratsaatini.text.toString()
                    val beratyangdiinginkan = binding.gs3beratyangdiinginkan.text.toString()
                    val jumlahkalori    = binding.gs3jumlahkalori.text.toString()
                     targetTanggal = binding.gs3datePickerTextInputEditText.text.toString()



                    if (beratsaatini.isFloat() && beratyangdiinginkan.isFloat() && jumlahkalori.isFloat()) {
                        if (selectedTitle == "" || targetTanggal == ""){
                            Toast.makeText(this, "Data tidak cocok!", Toast.LENGTH_SHORT).show()
                        }else{
                            val intentToFormData = Intent(this, HomePageActivity::class.java)
                            intentToFormData.putExtra("name", nameData)
                            intentToFormData.putExtra("beratsaatini", beratsaatini)
                            intentToFormData.putExtra("satuanberatsaatini", selectedSatuan1)
                            intentToFormData.putExtra("beratyangdiinginkan", beratyangdiinginkan)
                            intentToFormData.putExtra("satuanberatyangdiinginkan", selectedSatuan2)
                            intentToFormData.putExtra("targettanggal", targetTanggal)
                            intentToFormData.putExtra("jumlahkalori", jumlahkalori)
                            startActivity(intentToFormData)

                        }


                    } else {
                        Toast.makeText(this, "Data tidak cocok!", Toast.LENGTH_SHORT).show()
                    }


                }



        }
    fun String.isFloat(): Boolean {
        return try {
            this.toFloat()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun showToast(message: String) {
        Toast.makeText(this@GS3_FormDataActivity, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDateSet(
        view: android.widget.DatePicker?,
        year: Int,
        month: Int,
        dayOfMonth: Int
    ) {
        val selectDate = "$dayOfMonth/${month + 1} / $year"
        binding.gs3datePickerTextInputEditText.setText(selectDate)
    }
}