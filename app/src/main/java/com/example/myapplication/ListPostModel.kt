package com.example.myapplication

import androidx.annotation.NonNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListPostModel {

    @SerializedName("data")
    @Expose
    private val teams: ArrayList<PostTeam>? = null

    fun getData() : ArrayList<PostTeam>? {
        return teams
    }

    @NonNull
    @Override
    override fun toString() : String {
        return teams.toString()
    }

}