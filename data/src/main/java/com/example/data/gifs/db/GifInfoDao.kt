package com.example.data.gifs.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GifInfoDao {
    @Query("SELECT * FROM GifInfoDb")
    fun getAll(): Flow<List<GifInfoDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(gifInfoList: List<GifInfoDb>)
}
