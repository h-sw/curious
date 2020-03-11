package com.team.rich.curious

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        supportFragmentManager.beginTransaction()
            .add(R.id.mainFrameLayout, homeFragment)
            .commit()
        supportFragmentManager.beginTransaction().show(homeFragment)
    }


}
