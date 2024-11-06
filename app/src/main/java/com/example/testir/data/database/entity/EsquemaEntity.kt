package com.example.testir.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "esquema_table")
data class EsquemaEntity(
    @PrimaryKey
    val nombreTabla: String,
    val pk: String,
    val queryCreacion: String,
    val batchSize: Int,
    val filtro: String,
    val error: String?,
    val numeroCampos: Int,
    val metodoApp: String?,
    val fechaActualizacionSincro: String
)
