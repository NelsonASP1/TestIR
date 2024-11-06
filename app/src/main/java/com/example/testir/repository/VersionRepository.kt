package com.example.testir.repository

import com.example.testir.api.ApiService
import com.example.testir.data.VersionResponse
import retrofit2.Response
import javax.inject.Inject

class VersionRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getVersion(): Response<String> {
        return apiService.getVersion()
    }
}