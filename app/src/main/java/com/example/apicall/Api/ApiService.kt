package com.example.apicall.Api

import com.example.apicall.Model.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getpostNyId():Call<MyData>
}