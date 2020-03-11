package com.team.rich.curious

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.team.rich.curious.controller.GoalAdapter
import com.team.rich.curious.models.Curious
import com.team.rich.curious.models.Provider
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        //test data.
        val listCurious = ArrayList<Curious>()
        listCurious.add(Curious("Face Line 5 Minute Massage","UWZQPclIOKc", Provider(0,"DAISY 데이지",""),0,0,0,0,0))
        listCurious.add(Curious("하루 5분!! 8팩 복근운동. [오늘의 루틴]","cIIowHQ3iBc", Provider(0,"키다리형",""),0,0,0,0,0))
        listCurious.add(Curious("통증을 빨리 없애주는 5분 목 운동","5z7QNdYDi9Q", Provider(0,"밝은 면 Bright Side Korea",""),0,0,0,0,0))


        val goalAdapter = GoalAdapter(listCurious)


        view.recycler_main_goal.setHasFixedSize(true)
        view.recycler_main_goal.layoutManager = LinearLayoutManager(view.context)
        view.recycler_main_goal.adapter = goalAdapter

        return view
    }
}
