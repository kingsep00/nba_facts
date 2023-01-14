package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PostAdapterTeamsUpComing (val postModel:List<PostTeam>):RecyclerView.Adapter<PostViewHolderTeamUpComing>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderTeamUpComing {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_post, parent,false)
        return PostViewHolderTeamUpComing(view)
    }

    override fun onBindViewHolder(holder: PostViewHolderTeamUpComing, position: Int) {
        return holder.bindView(postModel.get(position))
    }

    override fun getItemCount(): Int {
        return postModel.size
    }

}

class PostViewHolderTeamUpComing(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val dataCity: TextView = itemView.findViewById(R.id.dataCity)
    private val dataFullName: TextView = itemView.findViewById(R.id.dataFullName)
    private val image: ImageView = itemView.findViewById(R.id.item_image)

    private lateinit var database: SQLiteDatabase
    val helper = DatabaseHelper(itemView.context)

    private val btnFav : ImageView = itemView.findViewById(R.id.btnFav)


    //Context context = imageView.getContext();
    //int id = context.getResources().getIdentifier("picture0001", "drawable", context.getPackageName());
    //imageView.setImageResource(id);

    fun bindView(postTeam: PostTeam){
        dataCity.text = postTeam.city
        dataFullName.text = postTeam.fullName

        val con = itemView.context
        val id = con.resources.getIdentifier(postTeam.abbrevation?.toLowerCase(),"drawable", con.packageName )
        image.setImageResource(id)

        val imgOff = itemView.resources.getDrawable(android.R.drawable.btn_star_big_off)
        val imgOn = itemView.resources.getDrawable(android.R.drawable.btn_star_big_on)

        val city : String = dataCity.text as String

        database = helper.writableDatabase

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, "GO GO GO GO ${city}", Toast.LENGTH_LONG).show()
            Log.w("click", "GO GO GO ${city}")
            val intent =  Intent(itemView.context, ActivityUpComingMatches::class.java)
            val passFullName = dataFullName.text.toString()
            val passId = postTeam.id
            intent.putExtra("EXTRA_MESSAGE",passFullName)
            intent.putExtra("EXTRA_MESSAGE_ID", passId)
            itemView.context.startActivity(intent)


        }
        val cursor = database.rawQuery("SELECT * FROM favorite_team WHERE id = ?", arrayOf(postTeam.id.toString()))
        val isExist = cursor.count > 0
        cursor.close()

        if(isExist){
            btnFav.setImageDrawable(imgOn)
        }

        btnFav.setOnClickListener{




            val values = ContentValues()
            values.put("id", postTeam.id)
            values.put("abv", postTeam.abbrevation)
            values.put("full_name", postTeam.fullName)

            val cursor = database.rawQuery("SELECT * FROM favorite_team WHERE id = ?", arrayOf(postTeam.id.toString()))
            val isExist = cursor.count > 0
            cursor.close()

            if(isExist){
                val sql = "DELETE FROM favorite_team WHERE id = ${postTeam.id}"
                database.execSQL(sql)
                btnFav.setImageDrawable(imgOff)
                Toast.makeText(itemView.context, "FAV DELETED", Toast.LENGTH_LONG).show()
            }
            else
            {
                btnFav.setImageDrawable(imgOn)
                database.insert("favorite_team",null,values)
            }




            //database.execSQL("DELETE FROM favorite_team")



        }

    }
}