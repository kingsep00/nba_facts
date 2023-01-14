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

class PostAdapterFav(val postModel:List<PostTeam>): RecyclerView.Adapter<PostViewHolderFav>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolderFav {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.card_post, parent,false)
            return PostViewHolderFav(view)
        }

        override fun onBindViewHolder(holder: PostViewHolderFav, position: Int) {
            return holder.bindView(postModel.get(position))
        }

        override fun getItemCount(): Int {
            return postModel.size
        }

    }

    class PostViewHolderFav(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val dataCity: TextView = itemView.findViewById(R.id.dataCity)
        private val dataFullName: TextView = itemView.findViewById(R.id.dataFullName)
        private val image: ImageView = itemView.findViewById(R.id.item_image)
        private val nofav : TextView = itemView.findViewById(R.id.txtfav)

        private lateinit var database: SQLiteDatabase
        val helper = DatabaseHelper(itemView.context)

        private val btnFav : ImageView = itemView.findViewById(R.id.btnFav)


        //Context context = imageView.getContext();
        //int id = context.getResources().getIdentifier("picture0001", "drawable", context.getPackageName());
        //imageView.setImageResource(id);



        fun bindView(postTeam: PostTeam){

            dataCity.text = postTeam.city
            dataFullName.text = postTeam.fullName


            val imgOff = itemView.resources.getDrawable(android.R.drawable.btn_star_big_off)
            val imgOn = itemView.resources.getDrawable(android.R.drawable.btn_star_big_on)



            val con = itemView.context
            val id = con.resources.getIdentifier(postTeam.abbrevation?.toLowerCase(),"drawable", con.packageName )
            image.setImageResource(id)




            val city : String = dataCity.text as String
            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "GO GO GO GO ${city}", Toast.LENGTH_LONG).show()
                Log.w("click", "GO GO GO ${city}")
                val intent =  Intent(itemView.context, ActivityMatches::class.java)
                val passFullName = dataFullName.text.toString()
                val passId = postTeam.id
                intent.putExtra("EXTRA_MESSAGE",passFullName)
                intent.putExtra("EXTRA_MESSAGE_ID", passId)
                itemView.context.startActivity(intent)


            }


            btnFav.setOnClickListener{

                    btnFav.setImageDrawable(imgOn)



            }
        }
    }
