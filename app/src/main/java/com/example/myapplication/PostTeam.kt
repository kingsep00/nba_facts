package com.example.myapplication

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



class PostTeam {
    @SerializedName("city")
    @Expose
    var city: String? = null

    @SerializedName("full_name")
    @Expose
    var fullName: String? = null

    @SerializedName("id")
    @Expose
    var id: Int?=null

    @SerializedName("abbreviation")
    @Expose
    var abbrevation: String?=null
}
