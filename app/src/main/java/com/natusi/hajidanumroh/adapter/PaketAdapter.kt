package com.natusi.hajidanumroh.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.natusi.hajidanumroh.R
import com.natusi.hajidanumroh.model.DataPaket
import com.squareup.picasso.Picasso

class PaketAdapter(val ctx: Context, val paketList: List<DataPaket>) : RecyclerView.Adapter<PaketAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val imgUrl = "192.168.2.111/develop/KBIHU_Al-Rahmah/public/api/paket-umroh"
        Picasso.get().load(imgUrl).into(holder.imgLogo)
    }

    override fun getItemCount(): Int {
        return paketList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLogo = itemView.findViewById(R.id.imgPaket) as ImageView
    }
}
