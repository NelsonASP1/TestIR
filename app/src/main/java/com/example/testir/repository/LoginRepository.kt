package com.example.testir.repository

import com.example.testir.api.ApiService
import com.example.testir.data.LoginRequest
import com.example.testir.data.LoginResponse
import com.example.testir.data.database.entity.UserEntity
import com.example.testir.data.database.dao.UserDao
import javax.inject.Inject
import retrofit2.Response


class LoginRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao
) {
    suspend fun authenticateUser(request: LoginRequest): Response<LoginResponse> {
        return apiService.authenticateUser(request)
    }

    suspend fun saveUser(user: UserEntity) {
        userDao.insertUser(user)
    }

}
