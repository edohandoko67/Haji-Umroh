package com.natusi.hajidanumroh.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natusi.hajidanumroh.adapter.PaketAdapter
import com.natusi.hajidanumroh.adapter.ProfileAdapter
import com.natusi.hajidanumroh.auth.API
import com.natusi.hajidanumroh.auth.ApiClient
import com.natusi.hajidanumroh.databinding.ActivityHomeBinding
import com.natusi.hajidanumroh.model.DataPaket
import com.natusi.hajidanumroh.model.ProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var calendar: Calendar
    lateinit var paketList: MutableList<HomeActivity>
    lateinit var recyclerView: RecyclerView
    lateinit var paketAdapter: PaketAdapter
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

//        setInitialDate()
//        binding.date.setOnClickListener {
//            saveDate()
//        }

        fetchDataAPI()
    }

    private fun fetchDataAPI() {
        val apis = ApiClient.getRetrofitInstance()!!.create(API::class.java)
        Log.d("response paket", apis.getDataPaket().toString());
        val call: Call<DataPaket> = apis.getDataPaket()
        call.enqueue(object : Callback<DataPaket> {
            override fun onResponse(call: Call<DataPaket>, response: Response<DataPaket>) {
                if (response.isSuccessful() && response.body() != null) {
                    response.body()!!.paket.let {
                        generateDataList(it)
                    }
                }
            }

            override fun onFailure(call: Call<DataPaket>, t: Throwable) {
                Toast.makeText(applicationContext,t.toString(), Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun generateDataList(dataList: List<DataPaket>) {
        paketAdapter = PaketAdapter(this, dataList)
        recyclerView.adapter = paketAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        paketAdapter.notifyDataSetChanged()
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