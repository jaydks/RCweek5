package com.example.rcweek5

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rcweek5.databinding.ItemTopmenuBinding

class TopmenuAdapter(val topmenuList: ArrayList<Topmenus>) : RecyclerView.Adapter<TopmenuAdapter.CustomViewHolder>(){

    class CustomViewHolder(val binding: ItemTopmenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(topmenu: Topmenus) = with(binding){
            ivEvent.setImageResource(topmenu.img)
            tvEvent.text = topmenu.about
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_topmenu, parent, false)
        return CustomViewHolder(ItemTopmenuBinding.bind(view))
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(topmenuList[position])
    }

    override fun getItemCount(): Int = topmenuList.size
}