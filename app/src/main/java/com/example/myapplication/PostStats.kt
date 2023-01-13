package com.example.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


public class PostStats{

    @SerializedName("id")
    @Expose
    val id: Int?=null
    @SerializedName("ast")
    @Expose
    val ast: Int?=null
    @SerializedName("blk")
    @Expose
    val blk: Int?=null
    @SerializedName("dreb")
    @Expose
    val dreb: Int?=null
    @SerializedName("fg3_pct")
    @Expose
    val fg3Pct: Double?=null
    @SerializedName("fg3a")
    @Expose
    val fg3a: Int?=null
    @SerializedName("fg3m")
    @Expose
    val fg3m: Int?=null
    @SerializedName("fg_pct")
    @Expose
    val fgPct: Double?=null
    @SerializedName("fga")
    @Expose
    val fga: Int?=null
    @SerializedName("fgm")
    @Expose
    val fgm: Int?=null
    @SerializedName("ft_pct")
    @Expose
    val ftPct: Double?=null
    @SerializedName("fta")
    @Expose
    val fta: Int?=null
    @SerializedName("ftm")
    @Expose
    val ftm: Int?=null
    @SerializedName("game")
    @Expose
    val game: Game?=null
    @SerializedName("min")
    @Expose
    val min: String?=null
    @SerializedName("oreb")
    @Expose
    val oreb: Int?=null
    @SerializedName("pf")
    @Expose
    val pf: Int?=null
    @SerializedName("player")
    @Expose
    val player: Player?=null
    @SerializedName("pts")
    @Expose
    val pts: Int?=null
    @SerializedName("reb")
    @Expose
    val reb: Int?=null
    @SerializedName("stl")
    @Expose
    val stl: Int?=null
    @SerializedName("team")
    @Expose
    val team: Team?=null
    @SerializedName("turnover")
    @Expose
    val turnover: Int?=null


}
public class Game {

    @SerializedName("id")
    @Expose
    val id: Int? =null
    @SerializedName("date")
    @Expose
    val date: String?= null
    @SerializedName("home_team_id")
    @Expose
    val homeTeamId: Int?=null
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
    @SerializedName("visitor_team_id")
    @Expose
    val visitorTeamId: Int?=null
    @SerializedName("visitor_team_score")
    @Expose
    val visitorTeamScore: Int?=null



}

public class Player {

    @SerializedName("id")
    @Expose
    val id: Int?=null
    @SerializedName("first_name")
    @Expose
    val firstName: String?=null
    @SerializedName("height_feet")
    @Expose
    val heightFeet: Int?=null
    @SerializedName("height_inches")
    @Expose
    val heightInches: Int?=null
    @SerializedName("last_name")
    @Expose
    val lastName: String?=null
    @SerializedName("position")
    @Expose
    val position: String?=null
    @SerializedName("team_id")
    @Expose
    val teamId: Int?=null
    @SerializedName("weight_pounds")
    @Expose
    val weightPounds: Int?=null


}
public class Team {

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