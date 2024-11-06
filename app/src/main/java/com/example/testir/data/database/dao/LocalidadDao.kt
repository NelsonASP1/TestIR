package com.example.testir.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testir.data.database.entity.LocalidadEntity

@Dao
interface LocalidadDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalidad(localidad: LocalidadEntity)

    @Query("SELECT * FROM localidad_table")
    suspend fun getAllLocalidades(): List<LocalidadEntity>
}
