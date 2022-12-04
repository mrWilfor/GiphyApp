package com.example.data.gifs.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface GifInfoDao {
    @Query("SELECT * FROM GifInfoDb")
    fun getAll(): Flow<List<GifInfoDb>>

    @Query("UPDATE GifInfoDb SET local_url = :localUrl WHERE gif_id = :gifId")
    suspend fun saveGifLocalUrl(gifId: String, localUrl: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(gifInfoList: List<GifInfoDb>)

    @Query("UPDATE GifInfoDb SET is_deleted = '1', local_url = NULL WHERE gif_id = :gifId")
    suspend fun markAsDeleted(gifId: String)
}
