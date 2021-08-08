package com.riyas.playstorehomepage.Model

import org.json.JSONArray
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("images")
    suspend fun getBannerData(): Response<BannerModel>

    @GET("Row%20Heading%201/items")
    suspend fun getRowData(@Query("limit") limit:Int, @Query("skip") skip:Int): Response<List<RowModel>>

}