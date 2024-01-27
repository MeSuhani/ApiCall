package com.example.apicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.Adapter.ShowDataAdapter
import com.example.apicall.Api.RetrofitInstance
import com.example.apicall.Model.MyData
import com.example.apicall.Model.MyDataItem
import retrofit2.Call
import retrofit2.Response

class ApicallActivity : AppCompatActivity() {

    private lateinit var recyclerview: RecyclerView
    lateinit var showDataAdapter: ShowDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apicall)

        recyclerview = findViewById(R.id.recyclerview)


        getAllData()

    }

    private fun getAllData() {
      val retrofitclicent=RetrofitInstance.apiService.getpostNyId()
        retrofitclicent.enqueue(object :retrofit2.Callback<MyData>{
            override fun onResponse(call: Call<MyData>, response: Response<MyData>) {
                Log.e("SUHANI","response:- "+response.body())

                val myData: MyData? =response.body()
                myData?.let {
                    val listData: ArrayList<MyDataItem> = it
                    showDataAdapter= ShowDataAdapter(this@ApicallActivity,listData)
                    recyclerview.adapter=showDataAdapter
                    recyclerview.layoutManager=LinearLayoutManager(this@ApicallActivity)
                }
            }

            override fun onFailure(call: Call<MyData>, t: Throwable) {
                Log.e("SUHANI","Error:- "+t.localizedMessage)
            }
        })

    }
}