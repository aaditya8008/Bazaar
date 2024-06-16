package com.example.bazaar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bazaar.databinding.ActivityStartscBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class startsc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy{
            ActivityStartscBinding.inflate(layoutInflater)
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.appCompatButton.setOnClickListener {
            GotiNext(it)
        }
    }
    fun GotiNext(view: View){
        if(Firebase.auth==null) {
            startActivity(Intent(this, loginsignup::class.java))
        }
        else{
            startActivity(Intent(this, HomeActivity::class.java))

        }
    }
}