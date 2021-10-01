package com.example.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btn_popular -> {
                    blank_text.visibility = View.GONE
//                    supportFragmentManager.beginTransaction().add(R.id.container, PopularData())
//                        .commit()
                    navController.navigate(R.id.action_global_popularData)

                }
                R.id.btn_upcoming -> {
                    blank_text.visibility = View.GONE
//                    supportFragmentManager.beginTransaction().add(R.id.container, UpcomingData())
//                        .commit()
                    navController.navigate(R.id.action_global_upcomingData)


                }
            }

            true
        }
    }
}



