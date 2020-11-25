package com.example.codingchallenge.network

import com.example.codingchallenge.models.People
import retrofit2.Call

class ApiImplemntor(private val apiInterface: ApiInterface){

    fun getPeoples():Call<People> = apiInterface.getPeoples()

}