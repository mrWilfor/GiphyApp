package com.example.domain

import com.example.domain.usecases.*
import org.koin.dsl.module

val domainModule = module {
    single { GetGifsInfosUseCase(get(), get()) }
    single { SaveGifLocallyUseCase(get()) }
    single { SearchGifsInfosUseCase(get(), get()) }
    single { DeleteGifFromLocalCacheUseCase(get()) }
    single { ReceiveNextPageUseCase(get(), get()) }
}