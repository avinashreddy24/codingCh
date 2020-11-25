package com.example.codingchallenge.repository

import com.example.codingchallenge.DAO.Cache
import com.example.codingchallenge.models.People
import com.example.codingchallenge.network.ApiImplemntor
import com.example.codingchallenge.network.ApiInterface
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doAnswer
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import java.io.IOException

@RunWith(MockitoJUnitRunner::class)
class RepostioryTest {

    @Mock
    lateinit var mockCache: Cache

    @Mock
    lateinit var mockCall: Call<People>


    @Mock
    lateinit var apiInterface: ApiInterface

    @Mock
    lateinit var apiImplemntor: ApiImplemntor

    lateinit var repository:Repository




    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)

        repository = Repository(apiImplemntor,mockCache)


    }

    @Test
    fun checkOnFailure(){
        // apiinterface when called for get return a mock

        whenever(apiImplemntor.getPeoples()) .thenReturn(mockCall)

        doAnswer {

            val calback = it.arguments[0] as Callback<People>
            calback.onFailure(mockCall,IOException())
            null
        }.`when`(mockCall).enqueue(any())


        //doanswer to invocke afilure
        //repository.getPeoplesList()

        //verify get from cache
        verify(mockCache).getFromCache()
    }



}