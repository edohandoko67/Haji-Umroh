package com.natusi.hajidanumroh.ui

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natusi.hajidanumroh.adapter.PaketAdapter
import com.natusi.hajidanumroh.auth.API
import com.natusi.hajidanumroh.auth.ApiClient
import com.natusi.hajidanumroh.databinding.ActivityHomeBinding
import com.natusi.hajidanumroh.model.DataPaket
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var calendar: Calendar
    lateinit var recyclerView: RecyclerView
    lateinit var paketAdapter: PaketAdapter
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = binding.recyclerView

        binding.profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java ))
        }

        binding.call.setOnClickListener {
            sendToCall()
        }

        binding.web.setOnClickListener {
            startActivity(Intent(this, WebActivity::class.java ))
        }

        setInitialDate()
        binding.date.setOnClickListener {
            saveDate()
        }

        fetchDataAPI()
    }

    private fun fetchDataAPI() {
        val apis = ApiClient.getRetrofitInstance()?.create(API::class.java)
        val call: Call<DataPaket?>? = apis?.getDataPaket()
        call!!.enqueue(object : Callback<DataPaket?> {
            override fun onResponse(call: Call<DataPaket?>, response: Response<DataPaket?>) {
                if (response.isSuccessful && response.body() != null) {
                    generateDataList(response.body()!!.paket)
                    Log.d("data paket:", response.body().toString())
                }
            }

            override fun onFailure(call: Call<DataPaket?>, t: Throwable) {
                Log.d("errornya apa: ", t.message!!)
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun generateDataList(dataList: List<DataPaket>) {
        paketAdapter = PaketAdapter(this, dataList)
        recyclerView.adapter = paketAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        paketAdapter.notifyDataSetChanged()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setInitialDate() {
        val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
        val currentDate = LocalDate.now().format(dateFormatter)

        binding.date.setText(currentDate)
        Log.d("date:", currentDate)
    }

    private fun saveDate() {
        val calendar = Calendar.getInstance()
        val year: Int = calendar.get(Calendar.YEAR)
        val month: Int = calendar.get(Calendar.MONTH)
        val day: Int = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                val selectedDate =
                    "$selectedYear-${selectedMonth + 1}-$selectedDay"
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