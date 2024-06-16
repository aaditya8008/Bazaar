package com.example.bazaar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bazaar.databinding.ActivityProjectCatBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class projectCatActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityProjectCatBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: Productadapter
    private lateinit var productList:ArrayList<datamodel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        productList=ArrayList<datamodel>()
        adapter= Productadapter(this,productList)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter
        if(intent.hasExtra("category")){
Firebase.firestore.collection("Products").whereEqualTo("category",intent.getStringExtra("category")).get().addOnSuccessListener {
    productList.clear()
    for(i in it.documents) {
        val y = i.toObject<datamodel>()
        if (y != null) {
            y.id = i.id}

            productList.add(y!!)
Toast.makeText(this,"Done",Toast.LENGTH_LONG).show()
        }
        adapter.notifyDataSetChanged()
    }


}

        else{


        }
    }
}