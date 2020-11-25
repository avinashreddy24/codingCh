package com.example.codingchallenge.network

import com.example.codingchallenge.models.People
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/people")
    fun getPeoples(): Call<People>
}