package com.example.myapplication

import androidx.annotation.NonNull
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListPostStats {

    @SerializedName("data")
    @Expose
    private val stats: ArrayList<PostStats>? = null

    fun getData() : ArrayList<PostStats>? {
        return stats
    }


    @NonNull
    @Override
    override fun toString() : String {
        return stats.toString()
    }

}