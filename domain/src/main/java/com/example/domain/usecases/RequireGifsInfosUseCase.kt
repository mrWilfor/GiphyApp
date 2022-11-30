package com.example.domain.usecases

import com.example.domain.GifInfoRepository

class RequireGifsInfosUseCase(
    private val gifInfoRepository: GifInfoRepository
) {

    suspend operator fun invoke() = gifInfoRepository.searchedGifsInfos
}