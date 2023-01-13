package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceWithID {

    @GET("/api/v1/games?seasons[]=2022")
    fun getGames(@Query("team_ids[]")id: Int?=null,@Query("per_page")page: Int?= null): Call<ListPostGames>


}