package com.example.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

public class PostGames {

    @SerializedName("id")
    @Expose
    val id: Int? =null
    @SerializedName("date")
    @Expose
    val date: String?= null
    @SerializedName("home_team")
    @Expose
    val homeTeam: HomeTeam?=null
    @SerializedName("home_team_score")
    @Expose
    val homeTeamScore: Int? = null
    @SerializedName("period")
    @Expose
    val period: Int?=null
    @SerializedName("postseason")
    @Expose
    val postseason : Boolean?=null
    @SerializedName("season")
    @Expose
    val season: Int?=null
    @SerializedName("status")
    @Expose
    val status: String?=null
    @SerializedName("time")
    @Expose
    val time: String?=null
    @SerializedName("visitor_team")
    @Expose
    val visitorTeam: VisitorTeam?=null
    @SerializedName("visitor_team_score")
    @Expose
    val visitorTeamScore: Int?=null

}


public class HomeTeam {

    @SerializedName("id")
    @Expose
    val id: Int?=null
    @SerializedName("abbreviation")
    @Expose
    val abbrevation: String?=null
    @SerializedName("city")
    @Expose
    val city: String?=null
    @SerializedName("conference")
    @Expose
    val conference: String?=null
    @SerializedName("division")
    @Expose
    val division: String?=null
    @SerializedName("full_name")
    @Expose
    val fullName: String?=null
    @SerializedName("name")
    @Expose
    val name: String?=null


}


public class VisitorTeam {

    @SerializedName("id")
    @Expose
    val id: Int?=null
    @SerializedName("abbreviation")
    @Expose
    val abbrevation: String?=null
    @SerializedName("city")
    @Expose
    val city: String?=null
    @SerializedName("conference")
    @Expose
    val conference: String?=null
    @SerializedName("division")
    @Expose
    val division: String?=null
    @SerializedName("full_name")
    @Expose
    val fullName: String?=null
    @SerializedName("name")
    @Expose
    val name: String?=null


}