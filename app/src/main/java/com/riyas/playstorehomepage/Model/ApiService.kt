package com.riyas.playstorehomepage.Model

import org.json.JSONArray
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ApiService {
    val BASE_URL = "http://206.189.139.221:5252/api/"
    private lateinit var api: ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        api = retrofit.create(ApiInterface::class.java)
    }

    suspend fun getBannerData(): Response<BannerModel>{
        return api.getBannerData()
    }

    suspend fun getRowData(limit:Int,skip:Int): Response<List<RowModel>>{
        return api.getRowData(limit,skip)
    }
}