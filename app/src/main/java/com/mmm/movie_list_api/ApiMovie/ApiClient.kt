package com.mmm.movie_list_api.ApiMovie

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        val Base_Url = "https://api.themoviedb.org/3/movie/"
        val posterUrl = "https://image.tmdb.org/t/p/w500"
        var token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyN2E5ZWZkY2QxNzJkYmEyYTJhYWFiZWY1M2E3OTgyYyIsInN1YiI6IjY0YjRiYTZhMzc4MDYyMDExYzhiZTMxMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fwcEsp19PgLVn7llNYRhF6mg5YRn8jRV3KxszJazpu0"

        var retrofit : Retrofit? = null

        fun getApiClient() : Retrofit{

            if(retrofit == null) {

                retrofit = Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(OkHttpClient().newBuilder().addInterceptor{Chain ->
                        val request = Chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer $token").build()
                        Chain.proceed(request)
                    }.build())
                    .build()
            }
            return retrofit!!
        }
    }
}