package com.example.giphyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.GifInfoDomain
import com.example.domain.usecases.DeleteGifFromLocalCacheUseCase
import com.example.domain.usecases.GetGifsInfosUseCase
import com.example.domain.usecases.SaveGifLocallyUseCase
import com.example.domain.usecases.SearchGifsInfosUseCase
import kotlinx.coroutines.launch

class GifsViewModel(
    private val getGifsInfosUseCase: GetGifsInfosUseCase,
    private val searchGifsInfosUseCase: SearchGifsInfosUseCase,
    private val saveGifLocallyUseCase: SaveGifLocallyUseCase,
    private val deleteGifFromLocalCacheUseCase: DeleteGifFromLocalCacheUseCase
) : ViewModel() {
    val gifsInfos: LiveData<List<GifInfoDomain>> = getGifsInfosUseCase.invoke().asLiveData()


    fun search(searchStr: String) {
        viewModelScope.launch {
            searchGifsInfosUseCase.invoke(searchStr)
        }
    }

    fun saveGifLocally(gifId: String, bytes: ByteArray) {
        viewModelScope.launch {
            saveGifLocallyUseCase.invoke(gifId, bytes)
        }
    }

    fun deleteGifFromLocalCache(gifId: String, localFilePath: String) {
        viewModelScope.launch {
            deleteGifFromLocalCacheUseCase.invoke(gifId, localFilePath)
        }
    }
}