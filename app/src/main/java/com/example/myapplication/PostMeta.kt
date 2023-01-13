package com.example.myapplication

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class PostMeta {
    @SerializedName("total_pages")
    @Expose
    private var totalPages: Int? = null

    @SerializedName("current_page")
    @Expose
    private var currentPage: Int? = null

    @SerializedName("next_page")
    @Expose
    private var nextPage: Int? = null

    @SerializedName("per_page")
    @Expose
    private var perPage: Int? = null

    @SerializedName("total_count")
    @Expose
    private var totalCount: Int? = null



}