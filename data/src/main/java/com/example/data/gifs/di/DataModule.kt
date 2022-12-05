package com.example.data.gifs.di

import com.example.data.gifs.*
import com.example.domain.GifInfoRepository
import com.example.domain.SearchParamsRepository
import org.koin.dsl.module

val dataModule = module {
    includes(dbModule, networkModule)

    single { GifInfoLocalDataSource(get()) }
    single { GifInfoRemoteDataSource(get(), get()) }
    single<GifInfoRepository> { GifInfoRepositoryImpl(get(), get(), get()) }
    single<SearchParamsRepository> { SearchParamsRepositoryImpl() }
    single { LocalCacheManager(get()) }
}