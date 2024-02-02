package com.natusi.hajidanumroh.adapter

import android.R
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.natusi.hajidanumroh.model.ProfileResponse
import com.squareup.picasso.Picasso


class ProfileAdapter(val context: Context, private val dataList: List<ProfileResponse>) :
    RecyclerView.Adapter<ProfileAdapter.ViewAdapter>() {

    class ViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewAdapter {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false)
        return ViewAdapter(view)
    }

    override fun onBindViewHolder(holder: ViewAdapter, position: Int) {
        holder.tvName.setText(dataList[position].getNamaPerusahaan())
        holder.tvProfile.setText(dataList[position].getProfile())
        holder.tvAlamat.setText(dataList[position].getAlamat())
        holder.tvNotelp.setText(dataList[position].getNoTelp())
        holder.tvEmail.setText(dataList[position].getEmail())
        val imageUrl =
            "http://192.168.2.111/develop/KBIHU_Al-Rahmah/public/img/auth/Logo-small-bottom.png"
        Picasso.get().load(imageUrl).into(holder.imgLogo)
        Log.e("isi imgUrl :", imageUrl)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}