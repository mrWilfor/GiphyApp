package com.example.data.gifs.di

import com.example.data.gifs.network.GifInfoNetwork
import com.example.data.gifs.network.GifInfoNetworkDeserializer
import com.example.data.gifs.network.GifsApi
import com.google.gson.GsonBuilder
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single {
        GsonConverterFactory.create(
            GsonBuilder().registerTypeAdapter(
                GifInfoNetwork::class.java,
                GifInfoNetworkDeserializer()
            ).create()
        )
    }
    single {
        Retrofit.Builder()
            .baseUrl("https://api.giphy.com/v1/gifs/")
            .addConverterFactory(get())
            .build()
    }
    single { get<Retrofit>().create(GifsApi::class.java) }
}