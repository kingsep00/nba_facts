package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceStats {

    //https://balldontlie.io/api/v1/stats?season[]=2022&game_ids[]=32881
    @GET("/api/v1/stats?seasons[]=2022")
    fun getStats(@Query("game_ids[]")id: Int?=null): Call<ListPostStats>


}