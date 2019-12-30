package com.team.rich.curious

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.team.rich.curious.controller.GoalAdapter
import com.team.rich.curious.models.Curious
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        //test data.
        val listCurious = ArrayList<Curious>()
        listCurious.add(Curious("5분 리프팅 마사지"))

        val goalAdapter = GoalAdapter(listCurious)
        recycler_main_goal.setHasFixedSize(true)
        recycler_main_goal.layoutManager = LinearLayoutManager(this)
        recycler_main_goal.adapter = goalAdapter

    }
}
