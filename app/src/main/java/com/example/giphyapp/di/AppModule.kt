package com.example.giphyapp.di

import com.example.giphyapp.GifsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { GifsViewModel(get(), get(), get(), get())}
}