package com.example.bazaar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bazaar.databinding.ActivityLoginsignupBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.database.database

class loginsignup : AppCompatActivity() {
    val binding by lazy{
        ActivityLoginsignupBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.signup.setOnClickListener{
Firebase.auth.createUserWithEmailAndPassword(binding.email.text.toString(),binding.password.text.toString()).addOnCompleteListener{
    if(it.isSuccessful){
        val um=UserModel(binding.firstname.text.toString(),binding.lastname.text.toString(),binding.email.text.toString(),binding.password.text.toString())
        Firebase.database.reference.child("Users").child(it.result.user!!.uid).setValue(um).addOnSuccessListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
            .addOnFailureListener{
                Toast.makeText(this, it.localizedMessage ,Toast.LENGTH_LONG).show()
            }
        Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()
    }
    else{
        Toast.makeText(this, it.exception?.localizedMessage ,Toast.LENGTH_LONG).show()
    }
}

        }
    }
}