package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapterStats(val postStats: List<PostStats>):RecyclerView.Adapter<PostViewHolderStats>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderStats {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_stats, parent, false)
        return PostViewHolderStats(view)
    }

    override fun getItemCount(): Int {
        return postStats.size
    }


    override fun onBindViewHolder(holder: PostViewHolderStats, position: Int) {
        return holder.bindView(postStats.get(position))

    }

}

class PostViewHolderStats(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val txtName: TextView = itemView.findViewById(R.id.txtName)
    private val txtSurname: TextView = itemView.findViewById(R.id.txtSurname)
    private val txtPtn: TextView = itemView.findViewById(R.id.txtPtn)
    private val txtMinute : TextView = itemView.findViewById(R.id.txtMinute)
    private val txtReb: TextView = itemView.findViewById(R.id.txtReb)
    private val txtBlk: TextView = itemView.findViewById(R.id.txtBlk)
    private val txtFg: TextView = itemView.findViewById(R.id.txtFg)
    private val txtTo: TextView = itemView.findViewById(R.id.txtTo)





    fun bindView(postStats: PostStats){

        txtName.text = postStats.player?.firstName
        txtSurname.text = postStats.player?.lastName
        txtPtn.text = postStats.pts.toString()
        txtMinute.text = postStats.min
        txtReb.text = postStats.reb.toString()
        txtBlk.text = postStats.blk.toString()
        txtFg.text = postStats.fgPct.toString().substring(0,3)
        txtTo.text = postStats.turnover.toString()

    }


}