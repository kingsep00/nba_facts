package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Fragment1Adapter (val postStats: List<PostStats>): RecyclerView.Adapter<PostViewHolderFragment1>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderFragment1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_stats, parent, false)
        return PostViewHolderFragment1(view)
    }

    override fun getItemCount(): Int {
        return postStats.size
    }


    override fun onBindViewHolder(holder: PostViewHolderFragment1, position: Int) {
        return holder.bindView(postStats.get(position))

    }

}

class PostViewHolderFragment1(itemView: View): RecyclerView.ViewHolder(itemView) {

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