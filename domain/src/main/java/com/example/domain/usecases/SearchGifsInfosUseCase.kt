package com.example.domain.usecases

import com.example.domain.GifInfoRepository

class SearchGifsInfosUseCase(
    private val gifInfoRepository: GifInfoRepository
) {

    suspend operator fun invoke(searchStr: String) = gifInfoRepository.searchGifs(searchStr)
}