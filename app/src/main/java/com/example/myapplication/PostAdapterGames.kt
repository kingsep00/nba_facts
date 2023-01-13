package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Color.parseColor
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostAdapterGames(val postGames: List<PostGames>):RecyclerView.Adapter<PostViewHolderGames>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderGames {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.card_post_games, parent, false)
        return PostViewHolderGames(view)
    }

    override fun getItemCount(): Int {
        return postGames.size
    }


    override fun onBindViewHolder(holder: PostViewHolderGames, position: Int) {
         return holder.bindView(postGames.get(position))
     }

 }

class PostViewHolderGames(itemView: View): RecyclerView.ViewHolder(itemView) {
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

        val mContext = itemView.context

        val intent = (mContext as Activity).intent

        val extraId = intent.getIntExtra("EXTRA_MESSAGE_ID",1)


        Log.d("WINORL", extraId.toString())
        if(postGames.visitorTeamScore as Int > postGames.homeTeamScore as Int && postGames.visitorTeam?.id == extraId){
            Log.d("STATE GAME", "win")
        }

        if( postGames.visitorTeamScore as Int > postGames.homeTeamScore as Int && postGames.visitorTeam?.id == extraId ){
            txtWin.text = "W"
            txtWin.setTextColor(parseColor("#00ff5f"))
        }

        else if(postGames.homeTeamScore as Int > postGames.visitorTeamScore  && postGames.homeTeam?.id == extraId)
        {
            txtWin.text = "W"
            txtWin.setTextColor(parseColor("#00ff5f"))
        }
        else
        {
            txtWin.text = "L"
            txtWin.setTextColor(parseColor("#FF0000"))
        }

        itemView.setOnClickListener{
            Log.w("CLICK STATS","sucess")
            val intent = Intent(itemView.context, ActivityStats::class.java)

            //extra
            val passAbvHome = postGames.homeTeam?.abbrevation
            val passScoreHome = postGames.homeTeamScore
            val passAbvVisitor = postGames.visitorTeam?.abbrevation
            val passScoreVisitor = postGames.visitorTeamScore
            val passId = postGames.id

            intent.putExtra("EXTRA_ABV_HOME",passAbvHome)
            intent.putExtra("EXTRA_SCORE_HOME", passScoreHome)
            intent.putExtra("EXTRA_ABV_VISITOR", passAbvVisitor)
            intent.putExtra("EXTRA_SCORE_VISITOR",passScoreVisitor)
            intent.putExtra("EXTRA_ID", passId)

            itemView.context.startActivity(intent)
        }


    }


}
