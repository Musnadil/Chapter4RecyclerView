package com.musnadil.chapter4recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.musnadil.chapter4recyclerview.databinding.ItemListBinding
import java.security.AccessController.getContext

class ContactAdapter(val listContact:ArrayList<MyContact>):RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    private val diffCallback = object :DiffUtil.ItemCallback<MyContact>(){
        override fun areItemsTheSame(oldItem: MyContact, newItem: MyContact): Boolean {
            return oldItem.nama == newItem.nama
        }

        override fun areContentsTheSame(oldItem: MyContact, newItem: MyContact): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this,diffCallback)
    fun submitData(value:ArrayList<MyContact>) = differ.submitList(value)


    inner class ViewHolder(val binding : ItemListBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.tvNama.text = data.nama
        holder.binding.tvNoHp.text = data.noHp
        holder.binding.btnDelete.setOnClickListener {
            removeItem(position)
            Toast.makeText(it.context, "kontak ${data.nama} berhasil dihapus", Toast.LENGTH_LONG).show()
        }

//        with(holder){
//            with(listContact[position]){
//                binding.tvNama.text = data.nama
//                binding.tvNoHp.text = data.noHp
//                binding.btnDelete.setOnClickListener {
//                    removeItem(position)
//                    Toast.makeText(it.context, "kontak ${data.nama} berhasil dihapus", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun removeItem(position: Int){
        listContact.removeAt(position)
    }
}