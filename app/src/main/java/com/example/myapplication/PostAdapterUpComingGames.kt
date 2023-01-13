package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapterUpComingGames (val postGames: List<PostGames>):RecyclerView.Adapter<PostViewHolderGamesUpComing>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderGamesUpComing {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_post_games, parent, false)
        return PostViewHolderGamesUpComing(view)
    }

    override fun getItemCount(): Int {
        return postGames.size
    }


    override fun onBindViewHolder(holder: PostViewHolderGamesUpComing, position: Int) {
        return holder.bindView(postGames.get(position))
    }

}

class PostViewHolderGamesUpComing(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val homeTeamScore: TextView = itemView.findViewById(R.id.txtHomeTeamScore)
    private val visitorTeamScore: TextView = itemView.findViewById(R.id.txtVisitorTeamScore)
    private val txtAbvHome: TextView = itemView.findViewById(R.id.txtAbvHome)
    private val txtAbvVisitor: TextView = itemView.findViewById(R.id.txtAbvVisitor)
    private val txtDate: TextView = itemView.findViewById(R.id.txtDate)
    private val txtWin: TextView = itemView.findViewById(R.id.idWin)


    fun bindView(postGames: PostGames){
        homeTeamScore.text = postGames.homeTeamScore.toString()
        visitorTeamScore.text = postGames.visitorTeamScore.toString()
        txtAbvHome.text = postGames.homeTeam?.abbrevation
        txtAbvVisitor.text = postGames.visitorTeam?.abbrevation
        txtDate.text = postGames.date?.substring(0,10)


    }


}