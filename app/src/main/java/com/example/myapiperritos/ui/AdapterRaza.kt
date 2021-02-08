package com.example.myapiperritos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestBuilder
import com.example.myapiperritos.databinding.ItemRaza1Binding
import com.example.myapiperritos.pojo.Raza

class AdapterRaza : RecyclerView.Adapter<AdapterRaza.RazaViewHolder>() {

    private var listRazaItem = listOf<Raza>()

    private var selectedItem = MutableLiveData<Raza>()
    fun selectedItem():LiveData<Raza> = selectedItem
    fun update(list: List<Raza>) {
        listRazaItem = list
        notifyDataSetChanged()
    }

    inner class RazaViewHolder(private val binding: ItemRaza1Binding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(raza: Raza) {
            binding.tvRaza.text= raza.raza
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            selectedItem.value = listRazaItem[adapterPosition]
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRaza.RazaViewHolder {
        return RazaViewHolder(ItemRaza1Binding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AdapterRaza.RazaViewHolder, position: Int) {
        val perritosDataClass = listRazaItem[position]
        holder.bind(perritosDataClass)
    }

    override fun getItemCount(): Int = listRazaItem.size


}

private fun <TranscodeType> RequestBuilder<TranscodeType>.into(tvRaza: TextView) {

}



