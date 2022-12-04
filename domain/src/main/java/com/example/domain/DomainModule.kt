package com.example.domain

import com.example.domain.usecases.DeleteGifFromLocalCacheUseCase
import com.example.domain.usecases.GetGifsInfosUseCase
import com.example.domain.usecases.SaveGifLocallyUseCase
import com.example.domain.usecases.SearchGifsInfosUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetGifsInfosUseCase(get(), get()) }
    single { SaveGifLocallyUseCase(get()) }
    single { SearchGifsInfosUseCase(get(), get()) }
    single { DeleteGifFromLocalCacheUseCase(get()) }
}