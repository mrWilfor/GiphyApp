package com.example.data.gifs.di

import androidx.room.Room
import com.example.data.gifs.db.GifDataBase
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(get(), GifDataBase::class.java, GifDataBase.NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<GifDataBase>().gifInfoDao() }
}