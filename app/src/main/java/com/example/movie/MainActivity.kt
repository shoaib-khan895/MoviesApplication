package com.example.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btn_popular -> {
                      blank_text.visibility = View.GONE

                    // Respond to navigation item 1 click
                    supportFragmentManager.beginTransaction().add(R.id.container, PopularData())
                        .commit();

                }
                R.id.btn_upcoming -> {
                     blank_text.visibility = View.GONE

                    supportFragmentManager.beginTransaction().add(R.id.container, UpcomingData())
                        .commit();

                }
            }

            true
        }
    }
}



