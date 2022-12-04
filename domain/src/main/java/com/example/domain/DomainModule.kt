package com.example.domain

import com.example.domain.usecases.GetGifsInfosUseCase
import com.example.domain.usecases.RequireGifsInfosUseCase
import com.example.domain.usecases.SearchGifsInfosUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetGifsInfosUseCase(get(), get()) }
    single { RequireGifsInfosUseCase(get()) }
    single { SearchGifsInfosUseCase(get(), get()) }
}