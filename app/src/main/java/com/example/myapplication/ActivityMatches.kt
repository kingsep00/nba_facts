package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.util.*

class ActivityMatches : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                // Get the result from intent
                val result = intent.getIntExtra("EXTRA_MESSAGE_ID",1)
                Log.d("BACKRESULT",result.toString())
            }
        }
    }


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_matches)

        val actionBar = supportActionBar

        actionBar?.setDisplayHomeAsUpEnabled(true)

        val extra = intent.getStringExtra("EXTRA_MESSAGE")
        val extraId = intent.getIntExtra("EXTRA_MESSAGE_ID",1)

        actionBar!!.title = extra








                doAsync {
            val serviceGenerator = ServiceGenerator.buildService(ApiServiceWithID::class.java)
            val call = serviceGenerator.getGames(extraId,100)




            val mRecyclerView = findViewById<RecyclerView>(R.id.rwGames)

                    call.enqueue(object : Callback<ListPostGames> {
                        override fun onResponse(
                            call: Call<ListPostGames>,
                            response: Response<ListPostGames>
                        ) {
                            if (response.isSuccessful) {
                                val catch = response.body()
                                val getcatch = catch?.getData()?.toList()
                                val json = GsonBuilder().setPrettyPrinting().create().toJson(getcatch)




                                var objTeams = Gson().fromJson(json, Array<PostGames>::class.java).toList()
                                //val t = Gson().fromJson(json, Array<PostModel>::class.java)
                                //Log.w("object", t.toString())
                                //gson?.fromJson(response, MineUserEntity.MineUserInfo::class.java)

                                Log.d("RESULTGETDATA", objTeams.toString())
                                uiThread {
                                    objTeams.forEach {

                                        Log.d("FOREACH DATA","post visitor ${it.visitorTeam?.abbrevation}  ${it.visitorTeamScore} - ${it.homeTeamScore} ${it.homeTeam?.abbrevation}")
                                        Log.d("FOREACH DATA","post visitor ${it.date} post visitorScore ${it.visitorTeamScore} post homeTeamscore ${it.homeTeamScore} ")


                                    }
                                }



                                objTeams = objTeams.filter { it.homeTeamScore!! > 0 }

                                objTeams = objTeams.sortedWith { a, b ->
                                    val dateA = LocalDate.parse(a.date?.substring(0,10))
                                    val dateB = LocalDate.parse(b.date?.substring(0,10))
                                    dateB.compareTo(dateA)
                                }



                                mRecyclerView.apply {
                                    layoutManager = LinearLayoutManager(this@ActivityMatches)

                                    adapter = PostAdapterGames(objTeams!!)
                                }
                            }
                        }

                        override fun onFailure(call: Call<ListPostGames>, t: Throwable) {
                            t.printStackTrace()
                            Log.w("error", t.message.toString())
                        }

                    })





        }



    }


}



