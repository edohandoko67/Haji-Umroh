package com.natusi.hajidanumroh.ui

import android.R
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.natusi.hajidanumroh.adapter.ProfileAdapter
import com.natusi.hajidanumroh.auth.API
import com.natusi.hajidanumroh.auth.ApiClient.getRetrofitInstance
import com.natusi.hajidanumroh.databinding.ActivityProfileBinding
import com.natusi.hajidanumroh.model.ProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    lateinit var profileList: MutableList<ProfileActivity>
    lateinit var recyclerView: RecyclerView
    lateinit var profileAdapter: ProfileAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = binding.recyclerView

        binding.iconBack.setOnClickListener {
            handleBackPressed()
        }

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        profileList = mutableListOf()
        fetchData()
    }

    private fun fetchData() {
        val api = getRetrofitInstance()!!.create(API::class.java)
        Log.d("response profile", api.getProfile().toString())
        val call: Call<ProfileResponse> = api.getProfile()
        call?.enqueue(object : Callback<ProfileResponse?> {
            override fun onResponse(call: Call<ProfileResponse?>?, response: Response<ProfileResponse?>) {
                if (response.isSuccessful() && response.body() != null) {
                    response.body()!!.profileResponse.let { generateDataList(it) }
                } else {
                    Toast.makeText(applicationContext,"No data Found", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ProfileResponse?>?, t: Throwable) {
                Toast.makeText(applicationContext,t.toString(), Toast.LENGTH_LONG).show()
                Log.d("error nya disini :", t.toString())
            }
        })
    }
    private fun generateDataList(dataList: List<ProfileResponse>) {
        profileAdapter = ProfileAdapter(this, dataList)
        recyclerView.adapter = profileAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        profileAdapter.notifyDataSetChanged()
    }

    private fun handleBackPressed() {
        onBackPressed()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}