package com.example.bazaar

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.bazaar.databinding.FragmentDashboard2Binding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject


class dashboard : Fragment() {
private lateinit var binding:FragmentDashboard2Binding
private lateinit var productList:ArrayList<datamodel>
private lateinit var adapter:Productadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboard2Binding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productList= ArrayList()
        getProductData()
        adapter= Productadapter(requireContext(),productList)
        binding.rv.adapter=adapter


    }

    private fun getProductData() {

Firebase.firestore.collection("Products").limit(10).get().addOnSuccessListener{

   productList.clear()
    for(i in it.documents){
       val y=i.toObject<datamodel>()
        if (y != null) {
            y.id=i.id
        }
       productList.add(y!!)

   }

   adapter.notifyDataSetChanged()

}.addOnFailureListener{
    Toast.makeText(requireContext(),"Failed connection",Toast.LENGTH_LONG).show()
}
binding.tops.setOnClickListener{
    startActivity(Intent(requireContext(),projectCatActivity::class.java).putExtra("category","top"))
}
        binding.dress.setOnClickListener{
            startActivity(Intent(requireContext(),projectCatActivity::class.java).putExtra("category","dress"))
        }
        binding.jumpsuits.setOnClickListener{
            startActivity(Intent(requireContext(),projectCatActivity::class.java).putExtra("category","jumpsuits"))
        }
        binding.bottom.setOnClickListener{
            startActivity(Intent(requireContext(),projectCatActivity::class.java).putExtra("category","bottom"))
        }
    }

    companion object {


    }
}