package com.example.data.gifs.di

import com.example.data.gifs.GifInfoLocalDataSource
import com.example.data.gifs.GifInfoRemoteDataSource
import com.example.data.gifs.GifInfoRepositoryImpl
import com.example.domain.GifInfoRepository
import org.koin.dsl.module

val dataModule = module {
    includes(dbModule, networkModule)

    single { GifInfoLocalDataSource(get()) }
    single { GifInfoRemoteDataSource(get()) }
    single<GifInfoRepository> { GifInfoRepositoryImpl(get(), get()) }
}