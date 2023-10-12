package com.example.uts_mobile_caloricare_rasyidk.getstarted

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DatePicker : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar =  Calendar.getInstance()
        val year =  calendar.get(Calendar.YEAR)
        val monthofyear =  calendar.get(Calendar.MONTH)
        val dayofmonth = calendar.get(Calendar.DAY_OF_MONTH)

        return  DatePickerDialog(
            requireActivity(),
            activity as OnDateSetListener,
            year, monthofyear, dayofmonth
        )
    }
}