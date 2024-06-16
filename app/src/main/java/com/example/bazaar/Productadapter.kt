package com.example.bazaar

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.bazaar.databinding.RoundimgBinding
import java.io.File

class Productadapter(var context:Context,var productList: ArrayList<datamodel>):RecyclerView.Adapter<Productadapter.viewholder>() {
    inner class viewholder(var binding:RoundimgBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var binding=RoundimgBinding.inflate(LayoutInflater.from(context),parent,false)
        return viewholder(binding)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {

    holder.binding.imageProduct.load(productList[position].img)
        holder.binding.name.setText(productList[position].name)
        holder.binding.additional.setText(productList[position].disp)
        holder.binding.price.setText(productList[position].price.toString())
        holder.itemView.setOnClickListener {
            context.startActivity(Intent(context,DetailActivity::class.java).putExtra("PRODUCT_ID",productList[position].id))
        }
    }

}