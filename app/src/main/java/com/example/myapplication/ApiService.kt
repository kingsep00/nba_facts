package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/api/v1/teams")
    fun getTeams(): Call<ListPostModel>

    @GET("/api/v1/games?seasons[]=2022&team_ids[]=1")
    fun getGames(): Call<ListPostGames>


    //@GET("myObjects/{id}")
    //    fun myObjectById(@Path("id") id: Int?, @Query("a_param") aParam: String?): Call<MyObject>
}