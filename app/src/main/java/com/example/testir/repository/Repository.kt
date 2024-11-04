package com.example.testir.repository


import com.example.testir.api.ApiService
import com.example.testir.data.ResponseType
import com.example.testir.di.RetrofitClient
import retrofit2.Call

class Repository {
    private val apiService: ApiService

    init {
        val retrofit = RetrofitClient.getClient("https://apitesting.interrapidisimo.co/")
        apiService = retrofit.create(ApiService::class.java)
    }

    fun getVersion(): Call<String> {
        return apiService.getVersion()
    }

    fun getUser(): Call<ResponseType> {
        return apiService.getUser()
    }
}
