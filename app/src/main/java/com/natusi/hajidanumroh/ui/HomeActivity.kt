package com.natusi.hajidanumroh.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.natusi.hajidanumroh.databinding.ActivityHomeBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var calendar: Calendar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java ))
        }

        binding.call.setOnClickListener {
            sendToCall()
        }

        binding.web.setOnClickListener {
            startActivity(Intent(this, WebActivity::class.java ))
        }

//        setInitialDate()
//        binding.date.setOnClickListener {
//            saveDate()
//        }
    }

    private fun setInitialDate() {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val currentDate = dateFormat.format(calendar.time)

        binding.date.setText(currentDate)
        Log.d("date:", currentDate.toString())
    }

    private fun saveDate() {
        val year: Int = calendar.get(Calendar.YEAR)
        val month: Int = calendar.get(Calendar.MONTH)
        val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                val selectedDate =
                    selectedYear.toString() + "-" + (selectedMonth + 1) + "-" + selectedDay
                binding.date.setText(selectedDate)
                binding.call.isFocusable = true
                binding.date.isClickable = true
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun sendToCall() {
        val telepon = "+62895342642087"
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$telepon")
        startActivity(intent)
        Log.e("url:", telepon)
    }
}