package com.example.codingchallenge.repository

import com.example.codingchallenge.DAO.Cache
import com.example.codingchallenge.models.People
import com.example.codingchallenge.network.ApiImplemntor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(val apiImplemntor: ApiImplemntor, val cache: Cache){

    suspend fun getPeoplesList(){
        apiImplemntor.getPeoples().enqueue(object : Callback<People> {
            override fun onFailure(call: Call<People>, t: Throwable) {
                cache.getFromCache()
            }

            override fun onResponse(call: Call<People>, response: Response<People>) {
                cache.setCache()
            }

        })
    }

}