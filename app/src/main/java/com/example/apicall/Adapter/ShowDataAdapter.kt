package com.example.apicall.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.Model.Address
import com.example.apicall.Model.MyDataItem
import com.example.apicall.R

class ShowDataAdapter(val context:Context,val listdata:ArrayList<MyDataItem>) :
    RecyclerView.Adapter<ShowDataAdapter.ViewHolder>() {


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_id=itemView.findViewById<TextView>(R.id.tv_id)
        var name=itemView.findViewById<TextView>(R.id.name)
        var username=itemView.findViewById<TextView>(R.id.username)
        var email=itemView.findViewById<TextView>(R.id.email)
        var rv_subitem=itemView.findViewById<RecyclerView>(R.id.rv_subitem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view=LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listdata.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val myDataItem=listdata.get(position)
        holder.tv_id.text= myDataItem.id.toString()
        holder.name.text= myDataItem.name.toString()
        holder.username.text= myDataItem.username.toString()
        holder.email.text= myDataItem.email.toString()

        if(myDataItem.address !=null)
        {
            var subadapter=SubAdapter(context,myDataItem.address)
            holder.rv_subitem.adapter=subadapter
            holder.rv_subitem.layoutManager=LinearLayoutManager(context)
        }
    }
}