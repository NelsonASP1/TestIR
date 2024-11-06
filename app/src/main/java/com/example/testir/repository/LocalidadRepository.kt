package com.example.testir.repository

import com.example.testir.api.ApiService
import com.example.testir.data.LocalidadResponse
import com.example.testir.data.database.dao.LocalidadDao
import com.example.testir.data.database.entity.LocalidadEntity
import retrofit2.Response
import javax.inject.Inject

class LocalidadRepository @Inject constructor(
    private val apiService: ApiService,
    private val localidadDao: LocalidadDao
) {
    suspend fun fetchLocalidades(): Response<List<LocalidadResponse>> {
        return apiService.getLocalidadesRecogidas()
    }

    suspend fun saveLocalidad(localidad: LocalidadEntity) {
        localidadDao.insertLocalidad(localidad)
    }
}
