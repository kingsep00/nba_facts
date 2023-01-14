package com.example.myapplication

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FavoriteActivity : AppCompatActivity() {
    private lateinit var database: SQLiteDatabase

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite2)
        //actionBar?.hide()
        supportActionBar?.hide()

        val helper = DatabaseHelper(this@FavoriteActivity)
        database = helper.writableDatabase

        doAsync {
            val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
            val call = serviceGenerator.getTeams()
            val mRecyclerView = findViewById<RecyclerView>(R.id.rwTeamsFav)
            val nofav =findViewById<TextView>(R.id.txtfav)

            //database


            val favoriteTeamIds = mutableListOf<Int>()






            call.enqueue(object : Callback<ListPostModel> {
                override fun onResponse(
                    call: Call<ListPostModel>,
                    response: Response<ListPostModel>
                ) {
                    if (response.isSuccessful) {
                        val catch = response.body()
                        val getcatch = catch?.getData()?.toList()

                        Log.w(
                            "success00",
                            GsonBuilder().setPrettyPrinting().create().toJson(getcatch.toString())
                        )
                        Log.w(
                            "success11",
                            GsonBuilder().setPrettyPrinting().create().toJson(getcatch)
                        )

                        val json = GsonBuilder().setPrettyPrinting().create().toJson(getcatch)
                        val objTeams = Gson().fromJson(json, Array<PostTeam>::class.java).toList()

                        val cursor = database.rawQuery("SELECT id FROM favorite_team", null)


                        while (cursor.moveToNext()) {
                            val id = cursor.getInt(cursor.getColumnIndex("id"))
                            favoriteTeamIds.add(id)
                        }
                        cursor.close()

                        var objStats_filter = objTeams.filter { (favoriteTeamIds.contains(it.id)) }



                        val cursorCheck = database.rawQuery("SELECT id FROM favorite_team", null)
                        val isExist = cursorCheck.count > 0
                        cursor.close()




                        if(!isExist){
                            nofav.text = "No Favorite ... Click the Stars"
                        }


                        mRecyclerView.apply {
                            layoutManager = LinearLayoutManager(this@FavoriteActivity)

                            adapter = PostAdapter(objStats_filter)
                        }


                    }
                }

                override fun onFailure(call: Call<ListPostModel>, t: Throwable) {
                    t.printStackTrace()
                    Log.w("error", t.message.toString())
                }


            })


        }

    }


}