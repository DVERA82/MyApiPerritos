package com.example.myapiperritos.ui

import android.graphics.Color
import android.graphics.ColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapiperritos.pojo.Raza
import com.example.myapiperritos.databinding.ItemImageBinding
import com.example.myapiperritos.remote.ImageRaza

class AdapterImage : RecyclerView.Adapter<AdapterImage.ImageVH>() {

    private var listImageAdapterItem = listOf<ImageRaza>()

    private val selectedItem = MutableLiveData<ImageRaza>()
    fun selectedItem() = selectedItem


    fun update(list: List<ImageRaza>) {
        listImageAdapterItem = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        return ImageVH(ItemImageBinding.inflate(LayoutInflater.from(parent.context)))
    }


    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        val perritosDataClass = listImageAdapterItem[position]
        holder.bind(perritosDataClass)
    }

    override fun getItemCount(): Int = listImageAdapterItem.size




    inner class ImageVH(private val binding: ItemImageBinding) :
            RecyclerView.ViewHolder(binding.root), View.OnLongClickListener {
        fun bind(raza: ImageRaza) {
            Glide.with(binding.textViewImage)
                    .load(raza.imgURL)
                    .into(binding.textViewImage)
            if (raza.favority) {
                binding.iVfav.setColorFilter(Color.RED)
            } else {
                binding.iVfav.setColorFilter(Color.BLACK)
            }
            itemView.setOnLongClickListener(this)
        }

        override fun onLongClick(v: View?): Boolean {
            selectedItem.value = listImageAdapterItem[adapterPosition]
            return true
        }

    }

}
