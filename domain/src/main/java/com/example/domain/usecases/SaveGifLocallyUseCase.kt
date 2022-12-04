package com.example.domain.usecases

import com.example.domain.GifInfoRepository

class SaveGifLocallyUseCase(
    private val gifInfoRepository: GifInfoRepository
) {

    suspend operator fun invoke(gifId: String, bytes: ByteArray) = gifInfoRepository.saveGifLocalUrl(gifId, bytes)
}