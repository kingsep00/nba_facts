package com.example.myapplication

import androidx.annotation.NonNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListPostGames {

    @SerializedName("data")
    @Expose
    private val games: ArrayList<PostGames>? = null

    fun getData() : ArrayList<PostGames>? {
        return games
    }

    @NonNull
    @Override
    override fun toString() : String {
        return games.toString()
    }


}