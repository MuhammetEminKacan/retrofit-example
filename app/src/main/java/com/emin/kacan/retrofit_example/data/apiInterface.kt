package com.emin.kacan.retrofit_example.data

import com.emin.kacan.retrofit_example.model.UrunItem
import retrofit2.Call
import retrofit2.http.GET

interface apiInterface {

    @GET("/products")
    fun getData() : Call<List<UrunItem>>
}