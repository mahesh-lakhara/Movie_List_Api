package com.kevin.themovie.Api

import com.mmm.movie_list_api.Model.MovieModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("now_playing")
    fun getnowplaying(
        @Query("page") page: Int
    ): Call<MovieModel>

    @GET("popular")
    fun getpopular(
        @Query("page") page: Int
    ): Call<MovieModel>

    @GET("top_rated")
    fun gettoprated(
        @Query("page") page: Int
    ): Call<MovieModel>

    @GET("upcoming")
    fun getupcoming(
        @Query("page") page: Int
    ): Call<MovieModel>

}