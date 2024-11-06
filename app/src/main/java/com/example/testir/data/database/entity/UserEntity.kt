package com.example.testir.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey
    val usuario: String,
    val identificacion: String?,
    val nombre: String?,
    val apellido1: String?
)
