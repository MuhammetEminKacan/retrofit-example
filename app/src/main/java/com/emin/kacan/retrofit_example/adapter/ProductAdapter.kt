package com.emin.kacan.retrofit_example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.emin.kacan.retrofit_example.R
import com.emin.kacan.retrofit_example.databinding.CardTasarimBinding
import com.emin.kacan.retrofit_example.model.UrunItem
import com.emin.kacan.retrofit_example.ui.AnaSayfaFragmentDirections

class ProductAdapter(var mContext : Context, var myList : List<UrunItem>) : RecyclerView.Adapter<ProductAdapter.cardTasarim>() {

    inner class cardTasarim(var binding : CardTasarimBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardTasarim {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return cardTasarim(binding)
    }

    override fun getItemCount(): Int {
       return myList.size
    }

    override fun onBindViewHolder(holder: cardTasarim, position: Int) {
        val list = myList.get(position)
        val b = holder.binding

        Glide.with(mContext).load(list.image).into(b.imageView)
        b.txtTitle.text = list.title
        b.txtPrice.text = list.price.toString()

        b.cardView.setOnClickListener {
            val gecis =AnaSayfaFragmentDirections.actionDetaySayfaGecis(urun = list)
            Navigation.findNavController(it).navigate(gecis)
        }
    }
}