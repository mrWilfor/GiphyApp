package com.example.giphyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.data.gifs.di.dataModule
import com.example.domain.domainModule
import com.example.giphyapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.stopKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity.applicationContext)
            modules(dataModule, domainModule, appModule)
        }
    }

    override fun onDestroy() {
        stopKoin()
        super.onDestroy()
    }
}