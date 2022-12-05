package com.example.giphyapp.di

import android.content.Context
import com.example.data.gifs.ApiKeyProvider
import com.example.giphyapp.ApiKeyProviderImpl
import com.example.giphyapp.GifsViewModel
import com.example.giphyapp.R
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { GifsViewModel(get(), get(), get(), get(), get())}
    single<ApiKeyProvider> { ApiKeyProviderImpl(get<Context>().getString(R.string.API_KEY)) }
}