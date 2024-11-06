package com.example.testir.repository

import com.example.testir.api.ApiService
import com.example.testir.data.database.dao.EsquemaDao
import com.example.testir.data.database.entity.EsquemaEntity
import retrofit2.Response
import javax.inject.Inject

class EsquemaRepository @Inject constructor(
    private val apiService: ApiService,
    private val esquemaDao: EsquemaDao
) {
    suspend fun getEsquemasFromApi(): Response<List<EsquemaEntity>> {
        return apiService.getEsquemas()
    }

    suspend fun saveEsquema(esquema: EsquemaEntity) {
        esquemaDao.insertEsquema(esquema)
    }

}
