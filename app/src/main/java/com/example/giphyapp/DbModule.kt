package com.example.giphyapp

import androidx.room.Room
import org.koin.dsl.module

val dbModule = module {
    single {
        Room.databaseBuilder(get(), GifDataBase::class.java, GifDataBase.NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    single { get<GifDataBase>().gifInfoDao() }
}