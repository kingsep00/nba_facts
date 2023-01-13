package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ComingGamesActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        //actionBar?.hide()
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doAsync {
            val serviceGenerator = ServiceGenerator.buildService(ApiService::class.java)
            val call = serviceGenerator.getTeams()
            val mRecyclerView = findViewById<RecyclerView>(R.id.rwTeams)





            call.enqueue(object : Callback<ListPostModel> {
                override fun onResponse(
                    call: Call<ListPostModel>,
                    response: Response<ListPostModel>
                ) {
                    if (response.isSuccessful) {
                        val catch = response.body()
                        val getcatch = catch?.getData()?.toList()

                        Log.w("success00", GsonBuilder().setPrettyPrinting().create().toJson(getcatch.toString()))
                        Log.w("success11", GsonBuilder().setPrettyPrinting().create().toJson(getcatch))

                        val json = GsonBuilder().setPrettyPrinting().create().toJson(getcatch)
                        val objTeams = Gson().fromJson(json, Array<PostTeam>::class.java).toList()
                        //val t = Gson().fromJson(json, Array<PostModel>::class.java)
                        //Log.w("object", t.toString())
                        //gson?.fromJson(response, MineUserEntity.MineUserInfo::class.java)


                        uiThread {
                            objTeams.forEach {
                                Log.d("FOREACH DATA","post city ${it.city} post full_name ${it.fullName} post id ${it.id} post abv ${it.abbrevation} ")
                            }
                        }

                        mRecyclerView.apply {
                            layoutManager = LinearLayoutManager(this@ComingGamesActivity)

                            adapter = PostAdapterTeamsUpComing(objTeams!!)
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