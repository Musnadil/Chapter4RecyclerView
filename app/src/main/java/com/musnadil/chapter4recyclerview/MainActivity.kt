package com.musnadil.chapter4recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.musnadil.chapter4recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listContact = arrayListOf(
            MyContact("Musnadil","085812341234"),
            MyContact("Pak Rt Sulthon","085800000000"),
            MyContact("Pack Rafly","085811111111"),
            MyContact("Pack Khoirul","085822222222"),
            MyContact("Pack Lurah Senno","085888888888"),
            MyContact("EREN","08590129012"),
            MyContact("MIKASA","000000000000"),
            MyContact("Pack Abrar","080808080808"),
            MyContact("Musnadil","085812341234"),
            MyContact("Pak Rt Sulthon","085800000000"),
            MyContact("Pack Rafly","085811111111"),
            MyContact("Pack Khoirul","085822222222"),
            MyContact("Pack Lurah Senno","085888888888"),
            MyContact("EREN","08590129012"),
            MyContact("MIKASA","000000000000"),
            MyContact("Pack Abrar","080808080808")
        )
        val adapter = ContactAdapter(listContact)
        val layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter


        adapter.submitData(listContact)

        binding.btnTambah.setOnClickListener {
//            val listContact = arrayListOf(
//                MyContact("${binding.etData.text}","${binding.etData.text}")
//            )
            listContact.add(
                MyContact("${binding.etData.text}","${binding.etData.text}")
            )
            adapter.submitData(listContact)
        }
    }
}