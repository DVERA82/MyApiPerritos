package com.example.myapiperritos.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapiperritos.pojo.Raza
import com.example.myapiperritos.databinding.ItemImageBinding
import com.example.myapiperritos.remote.ImageRaza

class AdapterImage : RecyclerView.Adapter<AdapterImage.ImageVH>() {

    private var listImageAdapterItem = listOf<ImageRaza>()

    private val selectedImage = MutableLiveData<ImageRaza>()
    fun selectedItem() = selectedImage

    fun update(list: List<ImageRaza>) {
        listImageAdapterItem = list
        notifyDataSetChanged()
    }

    inner class ImageVH(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(raza: ImageRaza) {
            Glide.with(binding.textViewImage)
                .load(raza.imgURL)
                .into(binding.textViewImage)

            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            selectedImage.value = listImageAdapterItem[adapterPosition]
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
       return ImageVH(ItemImageBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
       val perritosDataClass = listImageAdapterItem[position]
        holder.bind(perritosDataClass)
    }

    override fun getItemCount(): Int= listImageAdapterItem.size



}