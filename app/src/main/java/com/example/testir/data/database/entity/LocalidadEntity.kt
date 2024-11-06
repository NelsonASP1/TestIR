package com.example.testir.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "localidad_table")
data class LocalidadEntity(
    @PrimaryKey
    val idLocalidad: String,
    val idTipoLocalidad: String,
    val idAncestroPGrado: String,
    val idAncestroSGrado: String,
    val nombreAncestroSGrado: String?,
    val idAncestroTGrado: String?,
    val nombreAncestroTGrado: String?
)
