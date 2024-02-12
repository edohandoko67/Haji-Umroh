package com.natusi.hajidanumroh.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.natusi.hajidanumroh.R
import com.natusi.hajidanumroh.auth.ApiClient.URL_IMAGE
import com.natusi.hajidanumroh.model.DataPaket
import com.natusi.hajidanumroh.ui.ShowActivity
import com.squareup.picasso.Picasso

class PaketAdapter(val ctx: Context, val paketList: List<DataPaket>) : RecyclerView.Adapter<PaketAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val (_, image) = paketList[position]
        holder.imgLogo.setOnClickListener {
            val intent = Intent(ctx, ShowActivity::class.java)
            intent.putExtra("image", image)
            ctx.startActivity(intent)
        }
        val imgUrl = "$URL_IMAGE$image"
        Picasso.get().load(imgUrl).into(holder.imgLogo)
        Log.d("image url show:", imgUrl)
    }

    override fun getItemCount(): Int {
        return paketList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLogo = itemView.findViewById(R.id.imgPaket) as ImageView
    }
}
