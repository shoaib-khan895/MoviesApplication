package com.example.movie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.adapter.MovieAdapter
import com.example.movie.models.Movie
import com.example.movie.vm.PopularViewModel
import kotlinx.android.synthetic.main.popular_data.*


class PopularData : Fragment() {

    private lateinit var mPopularViewModel: PopularViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.popular_data, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPopularViewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
        mPopularViewModel.getMovieData()
        rv_movies_list.layoutManager = LinearLayoutManager(activity)
        rv_movies_list.setHasFixedSize(true)
        tv_sub_title.setText(R.string.popular)
        mPopularViewModel.getPopularMovieList().observe(viewLifecycleOwner, { movies: List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        })
    }
}