package com.mmm.movie_list_api.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kevin.themovie.Fragment.NowPlayingMovie
import com.kevin.themovie.Fragment.PopularMovie
import com.kevin.themovie.Fragment.TopRatedMovie
import com.kevin.themovie.Fragment.UpcominMovie
import com.mmm.movie_list_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var item = arrayOf("Now Playing", "Popular", "Top Rated", "Upcoming")

    var fragments = arrayOf(NowPlayingMovie(), PopularMovie(), TopRatedMovie(), UpcominMovie())



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.viewPager.adapter = FragmentAdapter(supportFragmentManager, fragments, item)
        binding.TabLayout.setupWithViewPager(binding.viewPager)

    }



}