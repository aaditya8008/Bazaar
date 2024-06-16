package com.example.bazaar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.bazaar.databinding.ActivityDetailBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class DetailActivity : AppCompatActivity() {
val binding by lazy{
    ActivityDetailBinding.inflate(layoutInflater)
}
    var productmodel=datamodel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var pid=intent.getStringExtra("PRODUCT_ID")
        Firebase.firestore.collection("Products").document(pid!!).get().addOnSuccessListener {

            productmodel= it.toObject<datamodel>()!!
            productmodel.id=it.id
            binding.imgMain.load(productmodel.img)
        }
        binding.buy.setOnClickListener {
            startActivity(Intent(this,shippingActivity::class.java))
        }

    }
}