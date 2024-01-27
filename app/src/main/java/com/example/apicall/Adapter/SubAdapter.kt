package com.example.apicall.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.Model.Address
import com.example.apicall.R

class SubAdapter(val context: Context, val address: Address) :
    RecyclerView.Adapter<SubAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var street=itemView.findViewById<TextView>(R.id.street)
        var city=itemView.findViewById<TextView>(R.id.city)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.sub_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.street.text=address.street
        holder.city.text=address.city
    }
}