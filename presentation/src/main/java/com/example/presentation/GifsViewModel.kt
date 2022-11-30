package com.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.GifInfoDomain
import com.example.domain.usecases.GetGifsInfosUseCase
import com.example.domain.usecases.SearchGifsInfosUseCase
import kotlinx.coroutines.launch

class GifsViewModel(
    private val getGifsInfosUseCase: GetGifsInfosUseCase,
    private val searchGifsInfosUseCase: SearchGifsInfosUseCase
) : ViewModel() {
    val gifsInfos: LiveData<List<GifInfoDomain>> = getGifsInfosUseCase.invoke().asLiveData()


    fun search(searchStr: String) {
        viewModelScope.launch {
            searchGifsInfosUseCase.invoke(searchStr)
        }
    }
}