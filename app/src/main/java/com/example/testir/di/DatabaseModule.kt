package com.example.testir.di

import android.content.Context
import androidx.room.Room
import com.example.testir.data.database.AppDatabase
import com.example.testir.data.database.dao.EsquemaDao
import com.example.testir.data.database.dao.LocalidadDao
import com.example.testir.data.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides fun provideEsquemaDao(database: AppDatabase): EsquemaDao {
        return database.esquemaDao()
    }

    @Provides fun provideLocalidadDao(database: AppDatabase): LocalidadDao {
        return database.localidadDao() }
}
