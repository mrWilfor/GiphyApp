package com.example.giphyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.data.gifs.di.dataModule
import com.example.data.gifs.di.dbModule
import com.example.data.gifs.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(dataModule, domainModule)
        }
    }
}