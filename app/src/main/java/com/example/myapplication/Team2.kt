package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var adapter : Fragment1Adapter
private lateinit var recyclerView: RecyclerView
/**
 * A simple [Fragment] subclass.
 * Use the [Team2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Team2 : Fragment() {
    // TODO: Rename and change types of parameters

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }






    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val objStats = arguments?.getSerializable("objTeams") as List<PostStats>
        val extraAbvHome = arguments?.getString("ABVVISITOR")

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team2, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val objStats = arguments?.getSerializable("objTeams") as List<PostStats>
        val extraAbvVisitor = arguments?.getString("ABVVISITOR")

        var objStats_filter = objStats.filter { it.team?.abbrevation == extraAbvVisitor }


        objStats_filter = objStats_filter.sortedWith{ a,b ->
            val pointA = a.pts!!
            val pointB = b.pts!!

            pointB.compareTo(pointA)

        }

        objStats_filter.forEach{
            Log.d("INSIDECREATED", "${it.player?.lastName}")
        }

        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rwStatsTeam2)
        recyclerView.layoutManager = layoutManager
        adapter = Fragment1Adapter(objStats_filter)
        recyclerView.adapter = adapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Team1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                Team1().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}