package com.example.movie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.adapter.UpcomingAdapter
import com.example.movie.models.MovieUpcoming
import com.example.movie.vm.UpcomingViewModel
import kotlinx.android.synthetic.main.upcoming_data.*


class UpcomingData : Fragment() {
    private lateinit var mUpcomingViewModel: UpcomingViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.upcoming_data, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUpcomingViewModel = ViewModelProvider(this).get(UpcomingViewModel::class.java)
        mUpcomingViewModel.getUpcomingMovieData()
        rv_movies_list.layoutManager = LinearLayoutManager(activity)
        rv_movies_list.setHasFixedSize(true)
        tv_sub_title.setText(R.string.Up_Coming)

        mUpcomingViewModel.getupComingMovieList()
            .observe(viewLifecycleOwner, { upcoming: List<MovieUpcoming> ->
                rv_movies_list.adapter = UpcomingAdapter(upcoming)
            })
    }
}