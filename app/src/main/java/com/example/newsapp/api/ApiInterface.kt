package com.example.newsapp.api

import com.example.newsapp.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {


    @GET("v2/top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("apiKey") key: String
    ) : Call<News>


    companion object {

        var BASE_URL = "https://newsapi.org/"
        var API_KEY = "3464309b9de34655858ed117d543e8be"
        var RUSSIA = "ru"
        var USA = "us"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}