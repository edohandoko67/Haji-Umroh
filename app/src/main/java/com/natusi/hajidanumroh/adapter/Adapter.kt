package com.natusi.hajidanumroh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.natusi.hajidanumroh.R
import com.natusi.hajidanumroh.model.ProfileResponse
import com.squareup.picasso.Picasso

class Adapter(val mCtx: Context, val userList: List<ProfileResponse>) : RecyclerView.Adapter<Adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.profile_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.name.text = userList[position].namaPerusahaan
        holder.profile.text = userList[position].profile
        holder.alamat.text = userList[position].alamat
        holder.telp.text = userList[position].noTelp
        holder.email.text = userList[position].email
        val imageUrl = "http://192.168.2.111/develop/KBIHU_Al-Rahmah/public/img/auth/Logo-small-bottom.png"
        Picasso.get().load(imageUrl).into(holder.logo)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        val logo = itemView.findViewById(R.id.imgLogo) as ImageView
        val name = itemView.findViewById(R.id.tvNama) as TextView
        val profile = itemView.findViewById(R.id.tvHasilProfile) as TextView
        val alamat = itemView.findViewById(R.id.tvHasilAlamat) as TextView
        val telp = itemView.findViewById(R.id.tvHasilTelp) as TextView
        val email = itemView.findViewById(R.id.tvHasilEmail) as TextView
    }

}