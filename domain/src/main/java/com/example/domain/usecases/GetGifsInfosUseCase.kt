package com.example.domain.usecases

import com.example.domain.GifInfoRepository

class GetGifsInfosUseCase(
    private val gifInfoRepository: GifInfoRepository
) {

    operator fun invoke() = gifInfoRepository.searchedGifsInfos
}