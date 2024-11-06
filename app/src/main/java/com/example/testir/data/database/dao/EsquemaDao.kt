package com.example.testir.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testir.data.database.entity.EsquemaEntity

@Dao
interface EsquemaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEsquema(esquema: EsquemaEntity)

    @Query("SELECT * FROM esquema_table")
    suspend fun getAllEsquemas(): List<EsquemaEntity>
}
