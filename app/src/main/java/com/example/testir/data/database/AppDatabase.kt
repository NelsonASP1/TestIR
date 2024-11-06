package com.example.testir.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testir.data.database.entity.UserEntity
import com.example.testir.data.database.dao.EsquemaDao
import com.example.testir.data.database.dao.LocalidadDao
import com.example.testir.data.database.dao.UserDao
import com.example.testir.data.database.entity.EsquemaEntity
import com.example.testir.data.database.entity.LocalidadEntity

@Database(entities = [UserEntity::class, EsquemaEntity::class, LocalidadEntity::class], version = 3, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun esquemaDao(): EsquemaDao
    abstract fun localidadDao(): LocalidadDao
}

